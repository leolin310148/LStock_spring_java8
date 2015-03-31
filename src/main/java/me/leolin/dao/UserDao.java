package me.leolin.dao;

import me.leolin.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leolin
 */
public interface UserDao extends JpaRepository<UserEntity, String> {
}
