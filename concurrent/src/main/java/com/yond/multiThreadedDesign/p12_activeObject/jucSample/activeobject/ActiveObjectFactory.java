package com.yond.multiThreadedDesign.p12_activeObject.jucSample.activeobject;

public class ActiveObjectFactory {
	
	public static ActiveObject createActiveObject() {
		return new ActiveObjectImpl();
	}

}