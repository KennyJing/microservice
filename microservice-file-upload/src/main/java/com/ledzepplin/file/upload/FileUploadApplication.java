package com.ledzepplin.file.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: Jingjiadong
 * @date: 6:57 PM 09/01/2018
 */
@SpringBootApplication
@EnableEurekaClient
public class FileUploadApplication {
    public static void main(String[] args){
        SpringApplication.run(FileUploadApplication.class,args);
    }
}
