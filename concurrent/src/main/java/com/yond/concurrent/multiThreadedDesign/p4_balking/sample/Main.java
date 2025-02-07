package com.yond.concurrent.multiThreadedDesign.p4_balking.sample;

public class Main {
    
    public static void main(String[] args) {
        Data data = new Data("static/multiThreadedDesign/data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
    
}
