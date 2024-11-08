package com.yond.multiThreadedDesign.p1_singleThreadExecution;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 2024-11-08
 */
public class GateExample {
    
    private static final int total = 1000000;
    private static int count = 0;
    
    public static void main(String[] args) {
        System.out.println("Start");
        Gate gate = new Gate();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new userThread(gate, "amelia", "alaska")).start();
        threadFactory.newThread(new userThread(gate, "benjamin", "boston")).start();
        threadFactory.newThread(new userThread(gate, "carter", "california")).start();
        System.out.println("End");
    }
    
    static class Gate {
        
        private int count;
        private String passName;
        private String passAddress;
        
        // instance method is no thread safe. add synchronized
        public void pass(String name, String address) {
            count++;
            passName = name;
            passAddress = address;
            check();
        }
        
        private void check() {
            if (passName.charAt(0) != passAddress.charAt(0)) {
                System.out.println(count + ": passName [" + passName + "] is no belong to passAddress [" + passAddress + "]");
            }
        }
    }
    
    
    static class userThread implements Runnable {
        
        private final Gate gate;
        private final String userName;
        private final String userAddress;
        
        public userThread(Gate gate, String name, String address) {
            this.gate = gate;
            userName = name;
            userAddress = address;
        }
        
        @Override
        public void run() {
            while (++count < total) {
                gate.pass(userName, userAddress);
            }
        }
        
    }
    
}
