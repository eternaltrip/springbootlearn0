package cn.yj.ip_spring_boot_starter.service;


import cn.yj.ip_spring_boot_starter.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class IpCountService {


    private Map<String, Integer> ipCountMap = new HashMap<>();

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IpProperties ipProperties;


    /**
     * 统计每个ip每次访问的次数。并做一个总访问的累加
     */
    public void count(){
        /*
        1.获取当前请求的ip
        2.通过当前获取的ip到map获取次数，并+1
        */
        String ip = request.getRemoteAddr();
        System.out.println("--------------------------------------" + ip);
        Integer count  = ipCountMap.get(ip);
        if(count == null){
            ipCountMap.put(ip , 1);
        }else{
            ipCountMap.put(ip , count+1);
        }
        print();
    }

    @Scheduled(cron = "0/#{ipProperties.circle} * * * * ?")
    public void print(){
        System.out.println("          ip 访问统计");
        if(ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getName())){
             System.out.println("+------ip address-------+");
             for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                 String key = entry.getKey();
                 Integer value = entry.getValue();
                 System.out.println(String.format("|%18s     |",key));
             }
             System.out.println("+-----------------------+");
         }else{
             System.out.println("+------ip address-------+---num---+");
             for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                 String key = entry.getKey();
                 Integer value = entry.getValue();
                 System.out.println(String.format("|%18s     |%7d  |",key,value));
             }
             System.out.println("+-----------------------+---------+");
         }

    }


}
