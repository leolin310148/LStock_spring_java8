package me.leolin;

import me.leolin.business.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author leolin
 */
@SpringBootApplication
@Import(WebConfig.class)
@EnableScheduling
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
//        StockService stockService = context.getBean(StockService.class);
//        stockService.syncStocks();
//        stockService.syncStockPrice();
    }
}
