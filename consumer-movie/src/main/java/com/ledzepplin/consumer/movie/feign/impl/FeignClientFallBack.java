package com.ledzepplin.consumer.movie.feign.impl;

import com.ledzepplin.consumer.movie.entity.User;
import com.ledzepplin.consumer.movie.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @description: feign断路方法类
 * @author: Jingjiadong
 * @date: 11:27 AM 09/01/2018
 */
//@Component
public class FeignClientFallBack implements UserFeignClient{

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("默认用户");
        return user;
    }
}
