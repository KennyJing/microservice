package com.ledzepplin.zuul.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * @Author: Jingjiadong
 * @Description:
 * @Date: 10:48 AM 11/01/2018
 */
@EnableSidecar
@SpringBootApplication
public class SidecarApplication {
    public static void main(String[] args){
        SpringApplication.run(SidecarApplication.class,args);
    }
}
