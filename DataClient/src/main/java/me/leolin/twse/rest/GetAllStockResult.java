package me.leolin.twse.rest;

import java.util.List;

/**
 * @author Leolin
 */
public class GetAllStockResult extends DefaultResult{
    private List<IndustryDto> tse;
    private List<IndustryDto> otc;

    public List<IndustryDto> getTse() {
        return tse;
    }

    public void setTse(List<IndustryDto> tse) {
        this.tse = tse;
    }

    public List<IndustryDto> getOtc() {
        return otc;
    }

    public void setOtc(List<IndustryDto> otc) {
        this.otc = otc;
    }
}
