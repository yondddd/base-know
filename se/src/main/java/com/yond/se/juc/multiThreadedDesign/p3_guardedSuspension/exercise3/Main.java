package com.yond.se.juc.multiThreadedDesign.p3_guardedSuspension.exercise3;

public class Main {
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		new ClientThread(requestQueue, "Alice", 3141592L).start();
		new ServerThread(requestQueue, "Bobby", 6535897L).start();
	}
}
