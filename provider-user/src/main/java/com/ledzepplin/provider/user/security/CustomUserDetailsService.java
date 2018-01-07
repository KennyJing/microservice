package com.ledzepplin.provider.user.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author: Jingjiadong
 * @Description:
 * @Date: 11:52 PM 07/01/2018
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("user".equals(username)){
            return new SecurityUser("user","password1","user-role");
        }else if("admin".equals(username)){
            return new SecurityUser("admin","password2","user-admin-role");
        }else {
            return null;
        }
    }
}
