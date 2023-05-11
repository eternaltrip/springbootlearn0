package com.yj.springboot_redis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisController {


    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/set/{key}/{value}")
    @ResponseBody
    public Object setKey(@PathVariable(name = "key") String key , @PathVariable(name = "value") String value){
        System.out.println(key+":"+value);
        return redisTemplate.opsForValue().setIfAbsent(key , value);
    }


    @RequestMapping("/get/{key}")
    @ResponseBody
    public Object getKey(@PathVariable String key ){
        return redisTemplate.opsForValue().get(key );
    }
}
