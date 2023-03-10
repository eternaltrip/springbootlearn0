package com.yj.springboot_redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

    }
    @Test
    void set() {
        redisTemplate.opsForValue().set("123","000");
    }
    @Test
    void get() {
        System.out.println(redisTemplate.opsForValue().get("123"));
    }

}
