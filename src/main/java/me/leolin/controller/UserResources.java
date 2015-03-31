package me.leolin.controller;

import me.leolin.business.service.UserService;
import me.leolin.data.dto.user.UserDto;
import me.leolin.data.holder.common.DefaultResultHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leolin
 */
@RestController
public class UserResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResources.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public DefaultResultHolder refreshUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return new DefaultResultHolder(true);
    }
}
