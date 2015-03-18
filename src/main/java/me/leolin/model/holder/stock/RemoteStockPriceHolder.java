package me.leolin.model.holder.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.leolin.model.entity.StockPriceEntity;

import java.util.List;

/**
 * @author leolin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteStockPriceHolder {
    @JsonProperty("msgArray")
    private List<StockPriceEntity> stockPrices;

    public List<StockPriceEntity> getStockPrices() {
        return stockPrices;
    }

    public void setStockPrices(List<StockPriceEntity> stockPrices) {
        this.stockPrices = stockPrices;
    }
}
