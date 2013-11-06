package com.kudler.anim9or.etchings;

import com.kudler.anim9or.pen.Point;

public class Contour {
	public int x;
	public int y;
	public boolean selected;
	public Contour(int initX,int initY) {
		x=initX;
		y=initY;
		selected=false;
	}
	
	public Contour(Point newPoint) {
		x=newPoint.getX();
		y=newPoint.getY();
		selected=false;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	public Point getPoint() {
		return new Point(x,y);
	}

	public void setSelected(boolean b) {
		selected=b;
		
	}
	public boolean getSelected() {
		return selected;
	}
	
	public void setPoint(Point point) {
		x=point.getX();
		y=point.getY();
	}
}
