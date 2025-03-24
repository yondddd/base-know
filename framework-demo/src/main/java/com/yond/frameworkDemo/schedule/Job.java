package com.yond.frameworkDemo.schedule;

/**
 * @Description:
 * @Author: yond
 * @Date: 3/15/2025
 */
public class Job implements Comparable<Job> {
    
    private Runnable runnable;
    private long startTime;
    private long delay;
    
    public Runnable getRunnable() {
        return runnable;
    }
    
    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
    
    public long getStartTime() {
        return startTime;
    }
    
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    
    public long getDelay() {
        return delay;
    }
    
    public void setDelay(long delay) {
        this.delay = delay;
    }
    
    
    @Override
    public int compareTo(Job o) {
        return Long.compare(this.startTime, o.startTime);
    }
}
