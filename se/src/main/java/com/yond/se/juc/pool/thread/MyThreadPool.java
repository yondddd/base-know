package com.yond.se.juc.pool.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 6/10/2025
 */
public class MyThreadPool {
    
    private final int corePoolSize;
    private final int maxPoolSize;
    private final int keepAliveTime;
    private final TimeUnit keepAliveTimeUnit;
    private final ArrayBlockingQueue<Runnable> taskQueue;
    private RejectHandle rejectHandle;
    
    public MyThreadPool(int corePoolSize, int maxPoolSize, int keepAliveTime, TimeUnit keepAliveTimeUnit, ArrayBlockingQueue<Runnable> taskQueue) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.keepAliveTimeUnit = keepAliveTimeUnit;
        this.taskQueue = taskQueue;
    }
    
    private final List<Worker> coreWorker = new ArrayList<>();
    private final List<Worker> supportWorker = new ArrayList<>();
    
    public void execute(Runnable runnable) {
        if (coreWorker.size() < corePoolSize) {
            Worker worker = new Worker();
            coreWorker.add(worker);
            worker.start();
        }
        boolean success = taskQueue.offer(runnable);
        if (!success) {
            if (supportWorker.size() < maxPoolSize - corePoolSize) {
                Worker worker = new Worker();
                supportWorker.add(worker);
                worker.start();
            } else {
                rejectHandle.rejectHandle(runnable, this);
            }
        }
    }
    
    
    class Worker extends Thread {
        
        @Override
        public void run() {
            while (true) {
                Runnable poll = taskQueue.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        }
    }
}
