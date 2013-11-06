package com.kudler.anim9or.pen;

public class Line {
	public Point start;
	public Point end;

	public Line(Point initStart, Point initEnd) {
		start=initStart;
		end=initEnd;
	
	}
	public Point getStart() {
		return start;
	}
	
	public Point getEnd() {
		return end;
	}


	
	public void setStart(Point initStart) {
		start = initStart;
	}
	
	public void setEnd(Point initEnd) {
		end = initEnd;
	}

	public double getSlope() {
		return (double)(end.getY()-start.getY())/(end.getX()-start.getX());
	}
	public double getIntercept() {
		return (double)(start.getY()-(getSlope()*start.getX()));
	}
	public boolean inLine(int x, int y) {
		if (isBetween(start.getX(),x,end.getX())) { 
			if (inRange((int)((getSlope()*x)+(int)getIntercept()),y)) {
				return true;
			}
		}
		return false;
		
	}

	public boolean inRange(int x,int y) {
		if ((x-4)<y  && y<(x+4)) {
			return true;
		}
		return false;
	}
	public boolean isBetween(int x,int y,int z) {
		if (x<z) {
			if (y>x && y<z) {
				return true;
			}
		} else {
			if (y>z && y<x) {
				return true;
			}
		}
		
		return false;
	}
}
