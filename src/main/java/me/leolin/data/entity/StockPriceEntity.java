package me.leolin.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author leolin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class StockPriceEntity implements Serializable {
    @JsonProperty("ch")
    @Id
    private String id;
    @Column
    @JsonProperty("tv")
    private String lastTradeCount;
    @Column
    @JsonProperty("v")
    private String totalTradeCount;
    @Column
    @JsonProperty("tlong")
    private Date lastTradeDate;
    @Column
    @JsonProperty("f")
    private String waitForSellCounts;
    @Column
    @JsonProperty("a")
    private String waitForSellPrices;
    @Column
    @JsonProperty("g")
    private String waitForBuyCounts;
    @Column
    @JsonProperty("b")
    private String waitForBuyPrices;
    @Column
    @JsonProperty("o")
    private String openPrice;
    @Column
    @JsonProperty("l")
    private String lowPrice;
    @Column
    @JsonProperty("h")
    private String highPrice;
    @Column
    @JsonProperty("u")
    private String lowestPrice;
    @Column
    @JsonProperty("w")
    private String highestPrice;
    @Column
    @JsonProperty("z")
    private String lastPrice;
    @Column
    @JsonProperty("y")
    private String yesterdayPrice;

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

    public String getWaitForSellCounts() {
        return waitForSellCounts;
    }

    public void setWaitForSellCounts(String waitForSellCounts) {
        this.waitForSellCounts = waitForSellCounts;
    }

    public String getWaitForSellPrices() {
        return waitForSellPrices;
    }

    public void setWaitForSellPrices(String waitForSellPrices) {
        this.waitForSellPrices = waitForSellPrices;
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
}
