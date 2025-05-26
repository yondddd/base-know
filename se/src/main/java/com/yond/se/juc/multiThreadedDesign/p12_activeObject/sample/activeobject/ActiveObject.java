package com.yond.se.juc.multiThreadedDesign.p12_activeObject.sample.activeobject;

public interface ActiveObject {

	public Result<String> makeString(int i, char fillchar);

	public void displayString(String string);
	
}
