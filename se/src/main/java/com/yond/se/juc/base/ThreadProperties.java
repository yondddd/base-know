package com.yond.se.juc.base;

import com.yond.common.util.ThreadUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/21/2025
 */
public class ThreadProperties {
    
    /**
     * 1. 为什么一定要获取到监视器锁 才能进行wait
     */
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    
    public static void main(String[] args) throws InterruptedException {
        // ================== 1. 线程状态监控 ==================
        Thread mainThread = Thread.currentThread();
        System.out.println("[主线程启动] " + ThreadUtil.getThreadInfo());
        
        // ================== 2. 创建子线程 ==================
        Thread childThread = new Thread(() -> {
            System.out.println("[子线程启动] " + ThreadUtil.getThreadInfo());
            
            try {
                // 模拟线程执行任务
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("[子线程被中断] " + ThreadUtil.getThreadInfo());
                Thread.currentThread().interrupt(); // 恢复中断状态
            }
            
            // 解锁主线程
            LockSupport.unpark(mainThread);
            System.out.println("[子线程解锁主线程]");
        }, "ChildThread-1"); // 设置线程名
        
        // ================== 3. 线程属性设置 ==================
        System.out.println("\n[线程初始状态] " + childThread.getState());
        childThread.setDaemon(false);    // 设置为用户线程 (默认)
        childThread.setPriority(Thread.NORM_PRIORITY); // 设置优先级
        
        // ================== 4. 线程同步操作 ==================
        childThread.start();
        System.out.println("[启动子线程后状态] " + childThread.getState());
        
        // 使用 LockSupport 挂起主线程
        System.out.println("\n[主线程挂起] 等待子线程解锁...");
        LockSupport.parkUntil(System.currentTimeMillis() + 2000); // 添加超时机制
        
        // ================== 5. 线程连接操作 ==================
        System.out.println("\n[主线程恢复] 等待子线程结束...");
        childThread.join(1000); // 带超时的join
        
        // ================== 6. 线程中断处理 ==================
        if (childThread.isAlive()) {
            System.out.println("[子线程未结束] 尝试中断...");
            childThread.interrupt();
            childThread.join();
        }
        
        // ================== 7. 最终状态检查 ==================
        System.out.println("\n[最终状态]");
        System.out.println("子线程状态: " + childThread.getState());
        System.out.println("子线程是否存活: " + childThread.isAlive());
        System.out.println("子线程ID: " + childThread.getId());
    }
    
}
