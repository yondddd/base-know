package com.yond.multiThreadedDesign.p11_threadSpecificStorage.exercise3;

public class Main {

	public static void main(String[] args) {
		new ClientThread("Alice").start();
		new ClientThread("Bobby").start();
		new ClientThread("Chris").start();
	}

}