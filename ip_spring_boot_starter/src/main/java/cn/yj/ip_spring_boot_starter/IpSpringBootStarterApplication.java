package cn.yj.ip_spring_boot_starter;

import cn.yj.ip_spring_boot_starter.properties.IpProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class IpSpringBootStarterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IpSpringBootStarterApplication.class, args);
        System.out.println("启动");
        for (String beanDefinitionName : context.getBeanFactory().getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

    }

}
