package com.yj.springboot_mq;

import com.yj.springboot_mq.service.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMqApplicationTests {



    @Autowired
    private SendMessage sendMessage;
    @Test
    void contextLoads() {
    }
    @Test
    void sendMessage() {
        sendMessage.sendMsg("111111");
    }

}
