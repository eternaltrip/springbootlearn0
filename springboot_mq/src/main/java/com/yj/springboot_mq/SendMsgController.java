package com.yj.springboot_mq;


import com.yj.springboot_mq.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/msg")
@RestController
public class SendMsgController {

    @Autowired
    private SendMessage sendMessage;


    @GetMapping("/send")
    public void send(@RequestParam(required = true ,name = "msg") String msg){
        sendMessage.sendMsg(msg);
    }

    @GetMapping("/sendtop")
    public void send2(@RequestParam(required = true ,name = "msg") String msg){
        sendMessage.fanoutSend(msg);
    }
}
