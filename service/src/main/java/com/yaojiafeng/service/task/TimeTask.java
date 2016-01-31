package com.yaojiafeng.service.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by yaojiafeng on 16/1/31.
 */
@Component
public class TimeTask {

    /**
     * 每次任务执行间隔2秒,任务不叠加
     */
    @Scheduled(fixedDelay = 2000)
    public void printTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date());
    }


}
