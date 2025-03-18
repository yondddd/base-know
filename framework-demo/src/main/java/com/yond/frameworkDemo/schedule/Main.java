package com.yond.frameworkDemo.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/15/2025
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        ScheduleService scheduleService = new ScheduleService();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
        scheduleService.schedule(() -> System.out.println(LocalDateTime.now().format(dateTimeFormatter) + "---100 ms pre time "), 100);
        scheduleService.schedule(() -> System.out.println(LocalDateTime.now().format(dateTimeFormatter) + "---200 ms pre time "), 200);
        Thread.sleep(5000);
        throw new InterruptedException("sda");
    }
}
