package me.leolin.dao;

import me.leolin.data.entity.StockEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author leolin
 */
public interface StockDao extends JpaRepository<StockEntity, String> {
    @Query("from StockEntity se where se.ex=?1 and se.industryCode=?2")
    List<StockEntity> findByMarketAndIndustry(String marketCode, String industryCode);

    @Query("from StockEntity se where se.name like %:searchText% or se.id like %:searchText%")
    List<StockEntity> findLike(@Param("searchText") String searchText, Pageable pageable);

}
