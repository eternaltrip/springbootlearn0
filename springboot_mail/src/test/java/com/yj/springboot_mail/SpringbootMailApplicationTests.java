package com.yj.springboot_mail;

import com.yj.springboot_mail.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMailApplicationTests {

    @Autowired
    private SendMailService sendMailService;

    @Test
    void contextLoads() {
    }


    @Test
    void send() {
        sendMailService.sendSimple();
    }




    @Test
    void sendMimeMail() {
        sendMailService.sendMimeMail();
    }

}
