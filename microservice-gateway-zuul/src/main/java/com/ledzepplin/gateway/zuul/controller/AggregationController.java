package com.ledzepplin.gateway.zuul.controller;

import com.google.common.collect.Maps;
import com.ledzepplin.gateway.zuul.entity.User;
import com.ledzepplin.gateway.zuul.service.AggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

/**
 * @Author: Jingjiadong
 * @Description:
 * @Date: 11:12 AM 11/01/2018
 */
@RestController
public class AggregationController {
    private static final Logger logger = LoggerFactory.getLogger(AggregationController.class);

    @Autowired
    private AggregationService aggregationService;

    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String,User>> aggregate(@PathVariable Long id){
        Observable<HashMap<String,User>> result = this.aggregateObservable(id);
        return toDeferredResult(result);
    }
    public Observable<HashMap<String,User>> aggregateObservable(Long id){
        //合并两个或多个Observables发射出的数据项，根据指定的函数变换它们
        return Observable.zip(aggregationService.getUserById(id),
                                  aggregationService.getMovieUserByUserId(id),
                (user,movieUser)->{
                    HashMap<String,User> map = Maps.newHashMap();
                    map.put("user",user);
                    map.put("movieUser",movieUser);
                    return map;
                });
    }

    public DeferredResult<HashMap<String,User>> toDeferredResult(Observable<HashMap<String,User>> details){
        DeferredResult<HashMap<String,User>> result = new DeferredResult<>();
        //订阅
        details.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                logger.info("complete");
            }

            @Override
            public void onError(Throwable e) {
                logger.error("error",e);
            }

            @Override
            public void onNext(HashMap<String, User> movieDetails) {
                result.setResult(movieDetails);
            }
        });
        return result;
    }
}
