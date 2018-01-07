package com.ledzepplin.provider.user.controller;

import com.ledzepplin.provider.user.entity.User;
import com.ledzepplin.provider.user.mapper.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            collection.stream().forEach((x)->{
                logger.info("当前用户是{},角色是{}",user.getUsername(),x.getAuthority());
            });
        }else {
            //do other things
        }
        return userRepository.findOne(id);
    }
}
