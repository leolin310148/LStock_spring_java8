package me.leolin.twse.rest;

import java.util.LinkedList;
import java.util.List;

/**
 * @author leolin
 */
public class StockPriceDto {
    private String id;
    private PriceInfoDto lastPrice;
    private List<PriceInfoDto> buyRows = new LinkedList<PriceInfoDto>();
    private List<PriceInfoDto> sellRows = new LinkedList<PriceInfoDto>();
    private double yesterdayPrice;
    private String range;
    private int totalCount;
    private PriceInfoDto openPrice;
    private PriceInfoDto highPrice;
    private PriceInfoDto lowPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PriceInfoDto getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(PriceInfoDto lastPrice) {
        this.lastPrice = lastPrice;
    }

    public List<PriceInfoDto> getBuyRows() {
        return buyRows;
    }

    public void setBuyRows(List<PriceInfoDto> buyRows) {
        this.buyRows = buyRows;
    }

    public List<PriceInfoDto> getSellRows() {
        return sellRows;
    }

    public void setSellRows(List<PriceInfoDto> sellRows) {
        this.sellRows = sellRows;
    }

    public double getYesterdayPrice() {
        return yesterdayPrice;
    }

    public void setYesterdayPrice(double yesterdayPrice) {
        this.yesterdayPrice = yesterdayPrice;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public PriceInfoDto getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(PriceInfoDto openPrice) {
        this.openPrice = openPrice;
    }

    public PriceInfoDto getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(PriceInfoDto highPrice) {
        this.highPrice = highPrice;
    }

    public PriceInfoDto getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(PriceInfoDto lowPrice) {
        this.lowPrice = lowPrice;
    }

}
