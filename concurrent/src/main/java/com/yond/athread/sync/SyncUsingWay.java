package com.yond.athread.sync;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.locks.StampedLock;

/**
 * @Date 2024/1/22
 * @Author yond
 * @Description three using way
 */
public class SyncUsingWay {

    // javap -v SyncUsingWay.class
    public synchronized void myMethod() {
        System.out.println("object method");
    }

    public static synchronized void myStaticMethod() {
        System.out.println("object static method");
    }

    public void method() {
//        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
//        Thread thread = new Thread(threadGroup, );
//        Thread.sleep();
//        ExecutorService service = new ThreadPoolExecutor();
//        service.execute();
//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>();
//        arrayBlockingQueue.put();
//        new StampedLock();
//        ArrayList<Object> objects = new ArrayList<>();
//        objects.get();
//        new CountDownLatch();
//        new InputStream()
//        synchronized (this){
//            System.out.println("method");
//        }
    }

}
