package com.yond.se.juc.multiThreadedDesign.p2_immutable.exercise5;

public class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
}
