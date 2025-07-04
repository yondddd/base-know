package com.yond.se.juc.multiThreadedDesign.p12_activeObject.jucSample.activeobject;

import java.util.concurrent.Future;

public interface ActiveObject {

	public abstract Future<String> makeString(int count, char fillchar);

	public abstract void displayString(String string);
	public abstract void shutdown();
	
}
