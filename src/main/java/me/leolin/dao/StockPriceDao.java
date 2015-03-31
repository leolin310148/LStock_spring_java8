package me.leolin.dao;

import me.leolin.data.entity.StockPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leolin
 */
public interface StockPriceDao extends JpaRepository<StockPriceEntity,String>{

}
