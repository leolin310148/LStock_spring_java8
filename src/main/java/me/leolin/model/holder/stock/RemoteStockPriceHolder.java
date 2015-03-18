package me.leolin.model.holder.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.leolin.model.dto.stock.RemoteStockPriceDto;

import java.util.List;

/**
 * @author leolin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteStockPriceHolder {
    @JsonProperty("msgArray")
    private List<RemoteStockPriceDto> stockPrices;

    public List<RemoteStockPriceDto> getStockPrices() {
        return stockPrices;
    }

    public void setStockPrices(List<RemoteStockPriceDto> stockPrices) {
        this.stockPrices = stockPrices;
    }
}
