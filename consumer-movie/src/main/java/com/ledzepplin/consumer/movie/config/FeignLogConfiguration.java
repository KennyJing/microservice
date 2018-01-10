package com.ledzepplin.consumer.movie.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:feign请求log配置类
 * @author: Jingjiadong
 * @date: 8:48 PM 08/01/2018
 */
@Configuration
public class FeignLogConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
