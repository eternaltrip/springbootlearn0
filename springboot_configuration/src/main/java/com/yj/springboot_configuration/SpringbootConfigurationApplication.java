package com.yj.springboot_configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.yj.springboot_configuration.config.ServersConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * EnableConfigurationProperties这里可以全部看到需要注入的bean对象,方便管理
 */
@SpringBootApplication
//@EnableConfigurationProperties({ServersConfig.class , a.class,b.class})
@EnableConfigurationProperties(ServersConfig.class )
public class SpringbootConfigurationApplication {


    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }



    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootConfigurationApplication.class, args);
        ServersConfig bean  = ctx.getBean(ServersConfig.class);
        System.out.println(bean.toString());
        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        System.out.println(ds);
        System.out.println(ds.getDriverClassName());

    }

}
