package me.leolin.business.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.leolin.Config;
import me.leolin.business.transformer.StockTransformer;
import me.leolin.dao.OtcIndustryDao;
import me.leolin.dao.StockDao;
import me.leolin.dao.StockPriceDao;
import me.leolin.dao.TseIndustryDao;
import me.leolin.data.dto.stock.StockPriceDto;
import me.leolin.data.dto.stock.StockTodayPriceDao;
import me.leolin.data.entity.StockPriceEntity;
import me.leolin.data.holder.stock.RemoteStockPriceHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.util.async.Async;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static rx.schedulers.Schedulers.io;

/**
 * @author leolin
 */
@Service
public class StockPriceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockPriceService.class);

    private static final Map<String, StockPriceEntity> CACHED_STOCK_PRICE_ENTITIES = Collections.synchronizedMap(new HashMap<>());

    public static final String KEY_TSE = "tse";
    public static final String KEY_OTC = "otc";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TseIndustryDao tseIndustryDao;
    @Autowired
    private OtcIndustryDao otcIndustryDao;
    @Autowired
    private StockDao stockDao;

    @Autowired
    private StockPriceDao stockPriceDao;
    @Autowired
    private StockTodayPriceDao stockTodayPriceDao;

    public List<StockPriceDto> getStockPriceInfos(List<String> stockIds) {
        List<String> checkedStockIds = stockIds.stream().map(this::checkStockId).collect(toList());
        return CACHED_STOCK_PRICE_ENTITIES.values()
                .stream()
                .filter(e -> checkedStockIds.contains(e.getId()))
                .map(StockTransformer::priceEntityToDto)
                .collect(toList());
    }

    @Transactional
    public void saveStockPrices(List<StockPriceEntity> stockPriceEntities) {
        LOGGER.info("Start save stockPrices");
        if (CACHED_STOCK_PRICE_ENTITIES.isEmpty()) {
            stockPriceDao.findAll().forEach(e -> CACHED_STOCK_PRICE_ENTITIES.put(e.getId(), e));
        }
        stockPriceEntities.forEach(e -> CACHED_STOCK_PRICE_ENTITIES.put(e.getId(), e));

        List<StockPriceEntity> filteredList = stockPriceEntities.stream()
                .filter(this::filterEntityFromMemory)
                .collect(toList());

        stockPriceDao.save(filteredList);
        stockTodayPriceDao.save(StockTransformer.mapStockPriceToStockTodayPrice(stockPriceEntities));
        LOGGER.info("{}/{} priceEntities saved", filteredList.size(), stockPriceEntities.size());
    }


    @Scheduled(cron = "0/5 0-35/1 13 * * MON-FRI")
    @Scheduled(cron = "0/5 * 9-13 * * MON-FRI")
//    @Scheduled(cron = "0/5 * * * * ?")
    public void syncStockPrice() {
        LOGGER.info("Start get price");
        Observable<List<StockPriceEntity>> tseObservable = Observable.from(tseIndustryDao.getAllIndustryCodes())
                .map(code -> String.join("|", (
                        stockDao.findByMarketAndIndustry(KEY_TSE, code)
                                .stream()
                                .map(e -> KEY_TSE + "_" + e.getId())
                                .collect(toList()))))
                .filter(queryString -> !queryString.isEmpty())
                .flatMap(queryString -> Async.start(() -> getRemoteStockPrice(queryString), io()));
        Observable<List<StockPriceEntity>> otcObservable = Observable.from(otcIndustryDao.getAllIndustryCodes())
                .map(code -> String.join("|", (
                        stockDao.findByMarketAndIndustry(KEY_OTC, code)
                                .stream()
                                .map(e -> KEY_OTC + "_" + e.getId())
                                .collect(toList()))))
                .filter(queryString -> !queryString.isEmpty())
                .flatMap(queryString -> Async.start(() -> getRemoteStockPrice(queryString), io()));

        Observable.merge(tseObservable, otcObservable)
                .reduce((list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                })
                .subscribe(this::saveStockPrices, t -> LOGGER.error(t.getMessage(), t));
    }


    private boolean filterEntityFromMemory(StockPriceEntity entity) {
        StockPriceEntity inMemoryEntity = CACHED_STOCK_PRICE_ENTITIES.get(entity.getId());
        if (inMemoryEntity == null) {
            return false;
        }

        if (entity.getLastTradeDate() == null) {
            return false;
        }

        if (entity.getLastTradeDate().after(inMemoryEntity.getLastTradeDate())) {
            return false;
        }

        return true;
    }


    private String checkStockId(String id) {
        if (!id.contains(".tw")) {
            return id + ".tw";
        }
        return id;
    }


    private List<StockPriceEntity> getRemoteStockPrice(String queryString) {
        String url = String.format(Config.URL_GET_STOCK_PIRCE, queryString);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        try {
            RemoteStockPriceHolder holder = objectMapper.readValue(responseEntity.getBody(), RemoteStockPriceHolder.class);
            List<StockPriceEntity> prices = holder.getStockPrices();
            LOGGER.debug("Successfully get {} stock price", prices.size());
            return prices;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>(0);
        }
    }

}
