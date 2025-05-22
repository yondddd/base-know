package com.yond.se.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/21/2025
 */
public class ThreadStatus {
    
    
    /**
     * 1. 为什么一定要获取到监视器锁 才能进行wait
     */
    
    
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            System.out.println("i am thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LockSupport.unpark(currentThread);
            System.out.println("un lock");
        });
        System.out.println(thread.getState());
        
        System.out.println("lock");
        thread.start();
        LockSupport.park(new Object());
        try {
            //  join 实际上 只要thread iaAlive  就一直执行wait, 直到线程结束，jvm 会自动唤醒。这时候就跳出条件了
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(thread.getState());
    }
}
