package com.yond.se.juc.multiThreadedDesign.p10_twoPhaseTermination.exercise5;

public class ServiceThread extends GracefulThread {
	private int count = 0;

	@Override
	protected void doWork() throws InterruptedException {
		System.out.print(".");
		sleep(100);
		count++;
		if (count >= 50) {
			shutdownRequest();
		}
	}

	@Override
	protected void doShutdown() {
		System.out.println("done.");
	}
	
	
}
