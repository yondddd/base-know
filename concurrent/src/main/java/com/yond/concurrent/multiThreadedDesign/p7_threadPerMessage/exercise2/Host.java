package com.yond.concurrent.multiThreadedDesign.p7_threadPerMessage.exercise2;

public class Host {
	private final Helper helper = new Helper();
	public void request(final int count, final char c) {
		System.out.println("      request(" + count + ", " + c + ") BEGIN");
		helper.handle(count, c);
		System.out.println("      request(" + count + ", " + c + ") END");
	}
}
