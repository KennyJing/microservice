package com.ledzepplin.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Jingjiadong
 * @Description:
 * @Date: 7:28 PM 07/01/2018
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderUserApplication {
    public static void main(String[] args){
        SpringApplication.run(ProviderUserApplication.class,args);
    }
}
