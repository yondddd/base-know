package com.yond.se.juc.multiThreadedDesign.p12_activeObject.exercise2_2.activeobject;

public class ActiveObjectFactory {
	
	public static ActiveObject createActiveObject() {
		return new ActiveObjectImpl();
	}

}
