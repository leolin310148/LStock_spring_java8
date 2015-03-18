package me.leolin.dao;

import me.leolin.model.entity.TseIndustryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author leolin
 */
public interface TseIndustryDao extends JpaRepository<TseIndustryEntity, String> {
    @Query("select e.code from TseIndustryEntity e")
    List<String> getAllIndustryCodes();
}
