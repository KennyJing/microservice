package com.ledzepplin.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description:
 * @author: Jingjiadong
 * @date: 4:20 PM 09/01/2018
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class,args);
    }
}
