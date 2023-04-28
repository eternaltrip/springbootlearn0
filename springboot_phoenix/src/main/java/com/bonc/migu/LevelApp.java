package com.bonc.migu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@MapperScan("com.bonc.migu.mapper")
@SpringBootApplication
public class LevelApp {
    public static void main(String[] args) {
        SpringApplication.run(LevelApp.class, args);
    }

}
