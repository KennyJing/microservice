package com.ledzepplin.consumer.movie.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @description: feign禁用hystrix配置类
 * @author: Jingjiadong
 * @date: 11:55 AM 09/01/2018
 */

/**
 *
 */
//@Configuration
public class FeignDisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
