package com.yj.demo02;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Slf4j
@Component
@PropertySource("classpath:/task-config.ini")
public class ScheduleTask implements SchedulingConfigurer {

    @Value("${printTime.cron}")
    private String cron;

    private Long timer = 10000L;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 动态使用cron表达式设置循环间隔
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                log.info("当前时间： {}", LocalDateTime.now());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 使用CronTrigger触发器，可动态修改cron表达式来操作循环规则,cron表达式只能定义小于等于间隔59秒。
//                CronTrigger cronTrigger = new CronTrigger(cron);
//                Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);




                // 使用不同的触发器，为设置循环时间的关键，区别于CronTrigger触发器，该触发器可随意设置循环间隔时间，单位为毫秒
                PeriodicTrigger periodicTrigger = new PeriodicTrigger(timer);
                Date nextExecutionTime = periodicTrigger.nextExecutionTime(triggerContext);
                return nextExecutionTime;
            }
        });
    }
}
