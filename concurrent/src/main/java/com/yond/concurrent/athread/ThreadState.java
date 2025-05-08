package com.yond.concurrent.athread;

import java.util.concurrent.FutureTask;

/**
 * @author yond
 * @date 10/27/2024
 * @description
 */
public class ThreadState {
    
    
    private static final ThreadState jucBase = new ThreadState();

    public static ThreadState getInstance() {
        return jucBase;
    }

    public static void main(String[] args) {
        ThreadState instance = ThreadState.getInstance();
        instance.threadState();
    }


    public void threadState() {
        new Thread(new FutureTask<>());
        Thread thread = new Thread(() -> {
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            thread.wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(thread.getState());
    }

}
