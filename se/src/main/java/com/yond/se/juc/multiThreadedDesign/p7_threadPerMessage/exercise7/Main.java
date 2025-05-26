package com.yond.se.juc.multiThreadedDesign.p7_threadPerMessage.exercise7;

public class Main {
	public static void main(String[] args) {
		System.out.println("BEGIN");
		Object obj = new Object();
		Blackhole.enter(obj);
		System.out.println("END");
	}
}
