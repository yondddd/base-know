package com.yond.se.juc.multiThreadedDesign.p1_singleThreadedExecution.exercise6;

public class Tool {
	private final String name;
	
	public Tool(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "[ " + name + " ]";
	}
}
