package com.yond.se.thread;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/14/2025
 */
public class ABC {
    
    static class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }
    
    static class B extends Thread {
        
        public B(A a) {
            this.a = a;
        }
        
        private final A a;
        
        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("B");
        }
    }
    
    static class C extends Thread {
        
        public C(B b) {
            this.b = b;
        }
        
        private final B b;
        
        @Override
        public void run() {
            try {
                b.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("C");
        }
    }
    
    
    public static void main(String[] args) {
        int total = 100;
        A a = new A();
        B b = new B(a);
        C c = new C(b);
        a.start();
        b.start();
        c.start();
    }
}
