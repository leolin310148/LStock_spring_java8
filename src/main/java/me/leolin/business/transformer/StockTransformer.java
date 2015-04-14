package me.leolin.business.transformer;

import me.leolin.data.dto.stock.PriceInfoDto;
import me.leolin.data.dto.stock.StockDto;
import me.leolin.data.dto.stock.StockPriceDto;
import me.leolin.data.entity.StockEntity;
import me.leolin.data.entity.StockPriceEntity;
import me.leolin.data.entity.StockTodayPriceEntity;
import me.leolin.data.entity.StockTodayPriceId;

import java.text.NumberFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.math.NumberUtils.toDouble;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

/**
 * @author leolin
 */
public class StockTransformer {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();
    public static final String COLOR_YELLOW = "y";
    private static final String COLOR_GREEN = "g";
    private static final String COLOR_RED = "r";

    static {
        numberFormat.setMinimumFractionDigits(2);
    }

    public static StockDto mapStockEntityToDto(StockEntity e) {
        return new StockDto(e.getId(), e.getName());
    }


    public static StockPriceDto priceEntityToDto(StockPriceEntity entity) {
        StockPriceDto dto = new StockPriceDto();
        dto.setId(entity.getId());

        double yesterdayPrice = toDouble(entity.getYesterdayPrice());
        dto.setYesterdayPrice(yesterdayPrice);
        dto.setTotalCount(toInt(entity.getTotalTradeCount(), 0));

        //漲跌
        double lastPrice = toDouble(entity.getLastPrice(), yesterdayPrice);
        String range = numberFormat.format((lastPrice - yesterdayPrice) * 100 / yesterdayPrice) + "%";
        dto.setRange(range);

        //成交價 成交量
        PriceInfoDto lastPriceInfoDto = new PriceInfoDto();
        lastPriceInfoDto.setPrice(Optional.ofNullable(entity.getLastPrice()).orElse("-"));
        lastPriceInfoDto.setCount(entity.getLastTradeCount());
        if (range.equals("0.00")) {
            lastPriceInfoDto.setColor(COLOR_YELLOW);
        } else if (range.startsWith("-")) {
            lastPriceInfoDto.setColor(COLOR_GREEN);
        } else {
            lastPriceInfoDto.setColor(COLOR_RED);
        }
        dto.setLastPrice(lastPriceInfoDto);


        //開盤價
        dto.setOpenPrice(getPriceInfo(yesterdayPrice, entity.getOpenPrice()));
        //最高價
        dto.setHighPrice(getPriceInfo(yesterdayPrice, entity.getHighPrice()));
        //最低價
        dto.setLowPrice(getPriceInfo(yesterdayPrice, entity.getLowPrice()));


        String waitForBuyCounts = entity.getWaitForBuyCounts();
        if (!"-".equals(waitForBuyCounts)) {
            String[] wfbcs = waitForBuyCounts.split("_");
            String[] wfbps = entity.getWaitForBuyPrices().split("_");
            for (int i = 0; i < wfbcs.length; i++) {
                PriceInfoDto priceInfo = getPriceInfo(yesterdayPrice, wfbps[i]);
                priceInfo.setCount(wfbcs[i]);
                dto.getBuyRows().add(priceInfo);
            }
        }
        String waitForSellCounts = entity.getWaitForSellCounts();
        if (!"-".equals(waitForSellCounts)) {
            String[] wfscs = waitForSellCounts.split("_");
            String[] wfsps = entity.getWaitForSellPrices().split("_");
            for (int i = 0; i < wfscs.length; i++) {
                PriceInfoDto priceInfo = getPriceInfo(yesterdayPrice, wfsps[i]);
                priceInfo.setCount(wfscs[i]);
                dto.getSellRows().add(priceInfo);
            }
        }

        return dto;

    }

    private static PriceInfoDto getPriceInfo(double yesterdayPrice, String targetPrice) {
        PriceInfoDto openPriceInfoDto = new PriceInfoDto();
        Optional<String> optionalPrice = Optional.ofNullable(targetPrice);
        openPriceInfoDto.setPrice(optionalPrice.orElse("-"));
        if (optionalPrice.isPresent()) {
            openPriceInfoDto.setColor(toDouble(optionalPrice.get()) - yesterdayPrice > 0 ? COLOR_RED : COLOR_GREEN);
        } else {
            openPriceInfoDto.setColor(COLOR_YELLOW);
        }

        return openPriceInfoDto;
    }


    public static List<StockTodayPriceEntity> mapStockPriceToStockTodayPrice(List<StockPriceEntity> entities) {
        return entities.stream().map(StockTransformer::mapStockPriceToStockTodayPrice).collect(Collectors.toList());
    }

    private static StockTodayPriceEntity mapStockPriceToStockTodayPrice(StockPriceEntity entity) {
        StockTodayPriceEntity tpe = new StockTodayPriceEntity();
        StockTodayPriceId id = new StockTodayPriceId();
        id.setId(entity.getId());
        id.setTime(entity.getLastTradeDate());

        tpe.setId(id);
        tpe.setLastPrice(entity.getLastPrice());
        tpe.setLastTradeCount(Integer.parseInt(entity.getLastTradeCount()));
        tpe.setTotalTradeCount(Integer.parseInt(entity.getTotalTradeCount()));

        return tpe;
    }
}
