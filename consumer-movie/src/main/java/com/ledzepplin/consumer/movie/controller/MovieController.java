package com.ledzepplin.consumer.movie.controller;

import com.ledzepplin.consumer.movie.entity.User;
import com.ledzepplin.consumer.movie.feign.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Author: Jingjiadong
 * @Description:
 * @Date: 7:59 PM 07/01/2018
 */
@RestController
@Import(FeignClientsConfiguration.class)
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private UserFeignClient userUserFeignClient;

    private UserFeignClient adminUserFeignClient;

    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).
                requestInterceptor(new BasicAuthRequestInterceptor("user","password1")).
                target(UserFeignClient.class,"http://microservice-provider-user/");
        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).
                requestInterceptor(new BasicAuthRequestInterceptor("admin","password2")).
                target(UserFeignClient.class,"http://microservice-provider-user/");
    }

    @GetMapping("/user-user/{id}")
    public User findByIdUser(@PathVariable Long id){
        return userUserFeignClient.findById(id);
    }

    @GetMapping("/user-admin/{id}")
    public User findByIdAdmin(@PathVariable Long id){
        return adminUserFeignClient.findById(id);
    }
//    @GetMapping("/user/{id}")
//    public User findById(@PathVariable Long id){
//        return restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
//    }

    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
