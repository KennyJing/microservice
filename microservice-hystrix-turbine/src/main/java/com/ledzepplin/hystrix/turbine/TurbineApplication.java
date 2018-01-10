package com.ledzepplin.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @description:
 * @author: Jingjiadong
 * @date: 3:10 PM 09/01/2018
 */
@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
public class TurbineApplication {
    public static void main(String[] args){
        SpringApplication.run(TurbineApplication.class,args);
    }
}
