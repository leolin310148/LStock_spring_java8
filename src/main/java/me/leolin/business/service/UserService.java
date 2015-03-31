package me.leolin.business.service;

import me.leolin.dao.UserDao;
import me.leolin.data.dto.user.UserDto;
import me.leolin.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leolin
 */
@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public void saveUser(UserDto userDto) {
        List<UserEntity> friends = userDao.findAll(userDto.getFriends());
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setFriends(friends);

        userDao.save(userEntity);
    }


}
