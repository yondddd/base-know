package com.yond.multiThreadedDesign.p1_singleThreadedExecution.sample2;

public class Main {

	public static void main(String[] args) {
		System.out.println("Testing Gate, bit CTRL+C to exit.");
		Gate gate = new Gate();
		new UserThread(gate, "Alice", "Alaska").start();
		new UserThread(gate, "Bobby", "Brazil").start();
		new UserThread(gate, "Chris", "Canada").start();
	}

}