package com.yond.se.juc.multiThreadedDesign.p2_immutable.jucSample1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
		new WriterThread(list).start();
		new ReaderThread(list).start();
	}

}
