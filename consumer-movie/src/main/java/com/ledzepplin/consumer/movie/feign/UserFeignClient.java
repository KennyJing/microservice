package com.ledzepplin.consumer.movie.feign;

import com.ledzepplin.consumer.movie.config.FeignLogConfiguration;
import com.ledzepplin.consumer.movie.entity.User;
import com.ledzepplin.consumer.movie.feign.impl.FeignClientFallBack;
import com.ledzepplin.consumer.movie.feign.impl.FeignClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Jingjiadong
 * @Description:
 * @Date: 10:41 PM 07/01/2018
 */
@FeignClient(name = "microservice-provider-user",fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id")Long id);
}
