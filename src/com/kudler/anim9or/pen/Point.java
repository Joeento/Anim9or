package com.kudler.anim9or.pen;

public class Point {
	int x;
	int y;
	public Point(int initX, int initY) {
		x=initX;
		y=initY;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int initX) {
		x=initX;
	}
	
	public void setY(int initY) {
		y=initY;
	}
	public boolean equals(Point point) {
		if (point.getX()==x && point.getY() == y) {
			return true;
		}
		return false;
	}

	public boolean equals(int x2, int y2) {
		// TODO Auto-generated method stub
		if (x2-10<x && x<x2+10) {
			if (y2-10<y && y<y2+10) {
				return true;
			}
			
		}
		return false;
	}
}
