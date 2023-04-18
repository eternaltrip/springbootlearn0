package com.yj.demo02;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/begin")
public class Begin {
    private final ScheduleTask scheduleTask;

    @Autowired
    public Begin(ScheduleTask scheduleTask) {
        this.scheduleTask = scheduleTask;
    }


    /**
     * 修改定时任务的循环时间，只能在59秒内
     * @param cron
     * @return
     */
    @GetMapping("/updateCron")
    public String updateCron(String cron) {
        log.info("new cron :{}", cron);
        scheduleTask.setCron(cron);
        return "ok";
    }


    /**
     * 修改定时任务的循环时间，任意时间毫秒
     * @param timer
     * @return
     */

    @GetMapping("/updateTimer")
    public String updateTimer(Long timer) {
        log.info("new timer :{}", timer);
        scheduleTask.setTimer(timer);
        return "ok";
    }

}
