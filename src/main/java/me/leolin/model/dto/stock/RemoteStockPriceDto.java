package me.leolin.model.dto.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author leolin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteStockPriceDto {

    @JsonProperty("ex")
    private String ex;
    @JsonProperty("ch")
    private String id;
    @JsonProperty("tv")
    private String lastTradeCount;
    @JsonProperty("v")
    private String totalTradeCount;
    @JsonProperty("tlong")
    private Date lastTradeDate;
    @JsonProperty("f")
    private String waitForSaleCounts;
    @JsonProperty("a")
    private String waitForSalePrices;
    @JsonProperty("g")
    private String waitForBuyCounts;
    @JsonProperty("b")
    private String waitForBuyPrices;
    @JsonProperty("o")
    private String openPrice;
    @JsonProperty("l")
    private String lowPrice;
    @JsonProperty("h")
    private String highPrice;
    @JsonProperty("u")
    private String lowestPrice;
    @JsonProperty("w")
    private String highestPrice;
    @JsonProperty("z")
    private String lastPrice;
    @JsonProperty("y")
    private String yesterdayPrice;


    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastTradeCount() {
        return lastTradeCount;
    }

    public void setLastTradeCount(String lastTradeCount) {
        this.lastTradeCount = lastTradeCount;
    }

    public String getTotalTradeCount() {
        return totalTradeCount;
    }

    public void setTotalTradeCount(String totalTradeCount) {
        this.totalTradeCount = totalTradeCount;
    }

    public Date getLastTradeDate() {
        return lastTradeDate;
    }

    public void setLastTradeDate(Date lastTradeDate) {
        this.lastTradeDate = lastTradeDate;
    }

    public String getWaitForSaleCounts() {
        return waitForSaleCounts;
    }

    public void setWaitForSaleCounts(String waitForSaleCounts) {
        this.waitForSaleCounts = waitForSaleCounts;
    }

    public String getWaitForSalePrices() {
        return waitForSalePrices;
    }

    public void setWaitForSalePrices(String waitForSalePrices) {
        this.waitForSalePrices = waitForSalePrices;
    }

    public String getWaitForBuyCounts() {
        return waitForBuyCounts;
    }

    public void setWaitForBuyCounts(String waitForBuyCounts) {
        this.waitForBuyCounts = waitForBuyCounts;
    }

    public String getWaitForBuyPrices() {
        return waitForBuyPrices;
    }

    public void setWaitForBuyPrices(String waitForBuyPrices) {
        this.waitForBuyPrices = waitForBuyPrices;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(String highestPrice) {
        this.highestPrice = highestPrice;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getYesterdayPrice() {
        return yesterdayPrice;
    }

    public void setYesterdayPrice(String yesterdayPrice) {
        this.yesterdayPrice = yesterdayPrice;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
