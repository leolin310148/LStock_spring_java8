package me.leolin.data.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author leolin
 */
@Entity
public class StockTodayPriceEntity implements Serializable {

    @EmbeddedId
    private StockTodayPriceId id;

    @Column
    private Integer lastTradeCount;

    @Column
    private Integer totalTradeCount;

    @Column
    private String lastPrice;

    public StockTodayPriceId getId() {
        return id;
    }

    public void setId(StockTodayPriceId id) {
        this.id = id;
    }

    public Integer getLastTradeCount() {
        return lastTradeCount;
    }

    public void setLastTradeCount(Integer lastTradeCount) {
        this.lastTradeCount = lastTradeCount;
    }

    public Integer getTotalTradeCount() {
        return totalTradeCount;
    }

    public void setTotalTradeCount(Integer totalTradeCount) {
        this.totalTradeCount = totalTradeCount;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }


}
