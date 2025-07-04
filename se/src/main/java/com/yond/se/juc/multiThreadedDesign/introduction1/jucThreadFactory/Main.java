package com.yond.se.juc.multiThreadedDesign.introduction1.jucThreadFactory;

import com.yond.se.juc.multiThreadedDesign.introduction1.printer.Printer;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new Printer("Nice!")).start();
        for (int i = 0; i < 10000; i++) {
            System.out.print("Good!");
        }
    }
}
