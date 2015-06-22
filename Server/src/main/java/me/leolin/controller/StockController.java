package me.leolin.controller;

import me.leolin.business.service.StockPriceService;
import me.leolin.business.service.StockService;
import me.leolin.twse.rest.GetAllStockResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leolin
 */
@RestController
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private StockPriceService stockPriceService;

//    @RequestMapping(value = "/price", method = RequestMethod.POST)
//    public DataResult getStockPrice(@RequestBody List<String> stockIds) {
//        return new DataResult(stockPriceService.getStockPriceInfos(stockIds));
//    }
//
//    @RequestMapping(value = "/stock/{marketCode}/{industryCode}", method = RequestMethod.GET)
//    public DataResult getStockByMarketAndIndustry(
//            @PathVariable("marketCode") String marketCode,
//            @PathVariable("industryCode") String industryCode
//    ) {
//        return new DataResult(stockService.getStockByMarketAndIndustry(marketCode, industryCode));
//    }

    @RequestMapping(value = "/stock", method = RequestMethod.GET)
    public GetAllStockResult getAllStock() {
        GetAllStockResult result = new GetAllStockResult();
        result.setTse(stockService.getAllTseIndustry());
        result.setOtc(stockService.getAllOtcIndustry());
        return result;
    }


//    @RequestMapping(value = "/stock", method = RequestMethod.GET)
//    public DataResult searchStock(@RequestParam(value = "search", required = false) Optional<String> searchText) {
//        if (searchText.isPresent()) {
//            return new DataResult(stockService.findLike(searchText.get()));
//        }
//        return new DataResult(false, "search not provide");
//    }

}
