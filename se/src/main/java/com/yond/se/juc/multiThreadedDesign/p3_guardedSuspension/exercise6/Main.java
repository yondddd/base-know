package com.yond.se.juc.multiThreadedDesign.p3_guardedSuspension.exercise6;

public class Main {
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		Thread alice = new ClientThread(requestQueue, "Alice", 314159L);
		Thread bobby = new ServerThread(requestQueue, "Bobby", 265358L);
		bobby.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("***** calling interrupt *****");
		alice.interrupt();
		bobby.interrupt();
	}
}
