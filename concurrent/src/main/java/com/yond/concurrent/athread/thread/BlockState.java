package com.yond.concurrent.athread.thread;

/**
 * @author yond
 * @date 10/26/2024
 * @description
 */
public class BlockState {

    public static void main(String[] args) throws InterruptedException {
        DemoBlockRunnable demoBlockRunnable = new DemoBlockRunnable();
        demoBlockRunnable.wait();
        Thread thread1 = new Thread(new DemoBlockRunnable());
        Thread thread2 = new Thread(new DemoBlockRunnable());
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        // new runnable waiting time waiting blocked terminated
    }

    static class DemoBlockRunnable implements Runnable {

        @Override
        public void run() {
            block();
        }

        public static synchronized void block() {
            while (true) {
                // block
            }
        }


    }

}
