package com.yj.springboot_mail.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailService   {


    @Resource
    private JavaMailSender mailSender;

    public void sendSimple(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("357802660@qq.com(我是昵称)");
        simpleMailMessage.setTo("eternalyangjin@hotmail.com");
        simpleMailMessage.setSubject("测试主体");
        simpleMailMessage.setText("测试内容");
        mailSender.send(simpleMailMessage);
    }


    /***
     * 复杂的邮件
     */
    public void sendMimeMail(){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage , true);//这里把附件设置为true
            mimeMessageHelper.setFrom("357802660@qq.com(我是昵称)");
            mimeMessageHelper.setTo("654219697@qq.com");
            mimeMessageHelper.setSubject("我的文件");
            mimeMessageHelper.setText("<a href='www.baidu.com'>测试内容,点击打开百度</a>" , true);

            //添加附件
            File file = new File("C:\\Users\\yangjin\\Desktop\\822051-杨锦-学信网截图.pdf");
            File file1 = new File("C:\\Users\\yangjin\\Desktop\\822051-杨锦-专科毕业证.jpg");
            mimeMessageHelper.addAttachment(file.getName() , file);
            mimeMessageHelper.addAttachment("专科毕业证" , file1);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
