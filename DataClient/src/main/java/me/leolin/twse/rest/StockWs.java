package me.leolin.twse.rest;

import retrofit.http.GET;

/**
 * @author Leolin
 */
public interface StockWs {
    @GET("/stock")
    GetAllStockResult getAllStock();
}
