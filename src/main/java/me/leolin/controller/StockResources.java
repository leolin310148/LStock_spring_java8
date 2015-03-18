package me.leolin.controller;

import me.leolin.model.holder.common.DefaultResultHolder;
import me.leolin.business.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leolin
 */
@RestController
public class StockResources {

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/stock/{marketCode}/{industryCode}", method = RequestMethod.GET)
    public DefaultResultHolder getStockByMarkeyAndIndustry(
            @PathVariable("marketCode") String marketCode,
            @PathVariable("industryCode") String industryCode
    ) {
        return new DefaultResultHolder(stockService.getStockByMarkeyAndIndustry(marketCode, industryCode));
    }

    @RequestMapping(value = "/industry", method = RequestMethod.GET)
    public DefaultResultHolder getAllStockIndustry() {
        Map<String, Object> map = new HashMap<>();
        map.put("otc", stockService.getAllOtcIndustry());
        map.put("tse", stockService.getAllTseIndustry());
        return new DefaultResultHolder(map);
    }


}
