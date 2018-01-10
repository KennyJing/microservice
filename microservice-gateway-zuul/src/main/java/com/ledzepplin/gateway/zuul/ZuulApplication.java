package com.ledzepplin.gateway.zuul;

import com.ledzepplin.gateway.zuul.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: Jingjiadong
 * @date: 4:20 PM 09/01/2018
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return new PreRequestLogFilter();
    }
    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class,args);
    }
}
