package me.leolin.dao;

import me.leolin.model.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author leolin
 */
public interface StockDao extends JpaRepository<StockEntity,String>{
    @Query("from StockEntity se where se.ex=?1 and se.industryCode=?2")
    List<StockEntity> findByMarketAndIndustry(String marketCode,String industryCode);
}
