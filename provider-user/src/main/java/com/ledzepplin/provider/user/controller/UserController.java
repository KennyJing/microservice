package com.ledzepplin.provider.user.controller;

import com.ledzepplin.provider.user.entity.User;
import com.ledzepplin.provider.user.mapper.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: Jingjiadong
 * @Description:
 * @Date: 7:25 PM 07/01/2018
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Long id){
        return userRepository.findOne(id);
    }
}
