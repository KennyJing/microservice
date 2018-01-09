package com.ledzepplin.consumer.movie.feign.impl;

import com.ledzepplin.consumer.movie.entity.User;
import com.ledzepplin.consumer.movie.feign.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description:hystrix 断路日志记录
 * @author: Jingjiadong
 * @date: 11:37 AM 09/01/2018
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                logger.info("fallback;reason was:",cause);
                User user = new User();
                user.setId(-1L);
                user.setUsername("默认用户");
                return user;
            }
        };
    }
}
