package me.leolin.dao;

import me.leolin.data.entity.SubscribeGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author leolin
 */
public interface SubscribeGroupDao extends JpaRepository<SubscribeGroupEntity, Integer> {
    List<SubscribeGroupEntity> findByUserId(String userId);
}
