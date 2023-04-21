package com.bonc.migu.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "hbase")
public class HbaseConfig {
    private Map<String, String> config = new HashMap<>();

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public org.apache.hadoop.conf.Configuration configuration() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
//此处可自己自定义和改造 拓展用
        //        configuration.set(HBASE_QUORUM, "81.68.xx.xx:2181");
//        configuration.set(HBASE_ROOTDIR, "/");
//        configuration.set(HBASE_ZNODE_PARENT, "/hbase");
        for(Map.Entry<String, String> map : config.entrySet()){
            configuration.set(map.getKey(), map.getValue());
        }
        return configuration;
    }

    @Bean
    public Admin admin() {
        Admin admin = null;
        try {
            Connection connection = ConnectionFactory.createConnection(configuration());
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }
}