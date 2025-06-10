package com.yond.se.juc.pool.thread;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 6/10/2025
 */
@FunctionalInterface
public interface RejectHandle {
    
    void rejectHandle(Runnable runnable, MyThreadPool pool);
}
