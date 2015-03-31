package me.leolin.dao;

import me.leolin.data.entity.SubscribeStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leolin
 */
public interface SubscribeStockDao extends JpaRepository<SubscribeStockEntity,Integer>{
}
