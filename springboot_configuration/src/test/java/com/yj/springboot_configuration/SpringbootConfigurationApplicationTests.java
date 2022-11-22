package com.yj.springboot_configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.temporal.ChronoUnit;

@SpringBootTest
class SpringbootConfigurationApplicationTests {

    @DurationUnit(ChronoUnit.HOURS)
    @Value("${servers.timeout}")
    private String timeout;



    @Test
    void contextLoads() {
        System.out.println(timeout);
    }

}
