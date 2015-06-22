package me.leolin.dao;

import me.leolin.data.entity.StockTodayPriceEntity;
import me.leolin.data.entity.StockTodayPriceId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leolin
 */
public interface StockTodayPriceDao extends JpaRepository<StockTodayPriceEntity, StockTodayPriceId> {
}
