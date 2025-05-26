package com.yond.se.juc.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/23/2025
 */
public class ScheduleService {
    
    
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    
    private static final PriorityBlockingQueue<Job> QUEUE = new PriorityBlockingQueue<>(1000);
    
    private static final Thread thread = new Thread(() -> {
        
        while (true) {
            Job firstJob = QUEUE.peek();
            if (firstJob == null) {
                continue;
            }
            long delay = firstJob.getStartTime() - System.currentTimeMillis();
            if (delay > 0) {
                LockSupport.parkUntil(firstJob.getStartTime());
            }
            firstJob = QUEUE.poll();
            executor.execute(firstJob.getR());
            Job nextJob = new Job();
            nextJob.setR(firstJob.getR());
            nextJob.setStartTime(System.currentTimeMillis() + firstJob.getDelay());
            nextJob.setDelay(firstJob.getDelay());
            QUEUE.offer(nextJob);
        }
    });
    
    
    static {
        thread.start();
    }
    
    void schedule(Runnable r, long delay) {
        Job job = new Job();
        job.setR(r);
        job.setStartTime(System.currentTimeMillis() + delay);
        job.setDelay(delay);
        QUEUE.offer(job);
        LockSupport.unpark(thread);
    }
    
    
    public static void main(String[] args) {
        ScheduleService scheduleService = new ScheduleService();
        scheduleService.schedule(() -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println(LocalDateTime.now().format(dateTimeFormatter));
        }, 1000);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");
    }
}
