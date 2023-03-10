package com.yj.springboot_jetcache;

import com.alicp.jetcache.anno.EnableCache;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCreateCacheAnnotation
public class SpringbootJetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJetcacheApplication.class, args);
    }

}
