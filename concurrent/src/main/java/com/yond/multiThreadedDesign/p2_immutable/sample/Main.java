package com.yond.multiThreadedDesign.p2_Immutable.sample;

public class Main {

	public static void main(String[] args) {
		Person alice = new Person("Alice", "Alaska");
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
	}

}
