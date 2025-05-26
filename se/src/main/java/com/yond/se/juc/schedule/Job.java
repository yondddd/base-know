package com.yond.se.juc.schedule;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/23/2025
 */
public class Job implements Comparable<Job> {
    
    private Runnable r;
    
    private long startTime;
    
    private long delay;
    
    public Runnable getR() {
        return r;
    }
    
    public void setR(Runnable r) {
        this.r = r;
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
        return (int) o.getStartTime();
    }
}
