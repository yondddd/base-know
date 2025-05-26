package com.yond.se.juc.multiThreadedDesign.p4_balking.exercise5;

public class Main {
	public static void main(String[] args) {
		Thread thread = new TestThread();
		thread.start();
//		while(true) {
//			thread.start();
//		}
	}
}
