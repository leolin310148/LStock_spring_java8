package me.leolin.twse.rest;


import java.util.LinkedList;
import java.util.List;

/**
 * @author leolin
 */
public class IndustryDto {
    private String code;
    private String name;
    private List<StockDto> stocks = new LinkedList<StockDto>();

    public IndustryDto() {
    }

    public IndustryDto(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StockDto> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockDto> stocks) {
        this.stocks = stocks;
    }

}
