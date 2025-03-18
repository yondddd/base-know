package com.yond.frameworkDemo.schedule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/15/2025
 */
public class ScheduleService {
    
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    
    private final Trigger trigger = new Trigger();
    
    public void schedule(Runnable r, long delay) {
        Job job = new Job();
        job.setRunnable(r);
        job.setStartTime(System.currentTimeMillis() + delay);
        job.setDelay(delay);
        trigger.queue.offer(job);
        trigger.wakeUp();
    }
    
    
    static class Trigger {
        
        private Trigger() {
            t.start();
        }
        
        PriorityBlockingQueue<Job> queue = new PriorityBlockingQueue<>();
        
        Thread t = new Thread(() -> {
            
            while (true) {
                while (queue.isEmpty()) {
                    LockSupport.park();
                }
                Job job = queue.peek();
                if (job != null) {
                    if (job.getStartTime() > System.currentTimeMillis()) {
                        LockSupport.parkUntil(job.getStartTime());
                    } else {
                        job = queue.poll();
                        executorService.execute(job.getRunnable());
                        Job continueJob = new Job();
                        continueJob.setRunnable(job.getRunnable());
                        continueJob.setStartTime(System.currentTimeMillis() + job.getDelay());
                        continueJob.setDelay(job.getDelay());
                        queue.offer(continueJob);
                    }
                }
            }
        });
        
        public void wakeUp() {
            LockSupport.unpark(t);
        }
    }
    
}
