package com.yond.se.juc.multiThreadedDesign.p7_threadPerMessage.exercise2;

public class Main {

	public static void main(String[] args) {
		System.out.println("main BEGIN");
		Host host = new Host();
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
		System.out.println("main END");
	}

}
