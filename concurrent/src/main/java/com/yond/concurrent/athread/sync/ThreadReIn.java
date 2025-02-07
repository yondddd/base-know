package com.yond.concurrent.athread.sync;

/**
 * @author yond
 * @date 2024/3/30
 * @description thread re in
 */
public class ThreadReIn implements Runnable {

    private static ThreadReIn instance = new ThreadReIn();
    private static int i;
    private static int j;


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(instance);
        Thread thread1 = new Thread(instance);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
        System.out.println(j);
    }

    @Override
    public void run() {
        for (int k = 0; k < 100000; k++) {
            synchronized (this) {
                i++;
                increaseJ();
            }
        }
    }

    private synchronized void increaseJ() {
        j++;
    }

}
