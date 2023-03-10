package cn.yj.ip_spring_boot_starter.autoconfig;

import cn.yj.ip_spring_boot_starter.properties.IpProperties;
import cn.yj.ip_spring_boot_starter.service.IpCountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 配置这里，只要能把bean加载上就行。使用ComponentScan或者Import都行
 */
@EnableScheduling
@ComponentScan("cn.yj.ip_spring_boot_starter.properties")
//@Import(IpProperties.class)
public class IpAutoConfiguration  {

    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}
