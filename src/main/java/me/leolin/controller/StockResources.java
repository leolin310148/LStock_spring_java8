package me.leolin.controller;

import me.leolin.business.service.StockService;
import me.leolin.data.holder.common.DefaultResultHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author leolin
 */
@RestController
public class StockResources {

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/price", method = RequestMethod.POST)
    public DefaultResultHolder getStockPrice(@RequestBody List<String> stockIds) {
        return new DefaultResultHolder(stockService.getStockPriceInfos(stockIds));
    }

    @RequestMapping(value = "/stock/{marketCode}/{industryCode}", method = RequestMethod.GET)
    public DefaultResultHolder getStockByMarketAndIndustry(
            @PathVariable("marketCode") String marketCode,
            @PathVariable("industryCode") String industryCode
    ) {
        return new DefaultResultHolder(stockService.getStockByMarketAndIndustry(marketCode, industryCode));
    }

    @RequestMapping(value = "/industry", method = RequestMethod.GET)
    public DefaultResultHolder getAllStockIndustry() {
        Map<String, Object> map = new HashMap<>();
        map.put("otc", stockService.getAllOtcIndustry());
        map.put("tse", stockService.getAllTseIndustry());
        return new DefaultResultHolder(map);
    }

    @RequestMapping(value = "/stock", method = RequestMethod.GET)
    public DefaultResultHolder searchStock(@RequestParam(value = "search", required = false) Optional<String> searchText) {
        if (searchText.isPresent()) {
            return new DefaultResultHolder(stockService.findLike(searchText.get()));
        }
        return new DefaultResultHolder(false, "search not provide");
    }


}
