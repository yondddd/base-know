package com.yond.concurrent.multiThreadedDesign.p4_balking.exercise2_2;

public class Main {

	public static void main(String[] args) {
		Data data = new Data("data.txt", "(empty)");
		new ChangerThread("ChangerThread", data).start();
		new SaverThread("SaverThread", data).start();
	}

}
