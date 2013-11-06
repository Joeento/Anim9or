package com.kudler.anim9or;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.kudler.anim9or.etchings.Curve;
import com.kudler.anim9or.pen.Line;
import com.kudler.anim9or.pen.Point;



public class Anim9orDataModel {
	public Anim9or a;
	public Color currentColor;
	List<Curve> curveList;
	public ArrayList<Line> lineList;
	public String mode;
	public Anim9orDataModel (Anim9or initA) {
		a=initA;
		curveList = new ArrayList<Curve>();
		lineList =new ArrayList<Line>();
		Line newLine = new Line(new Point(100,4),new Point(400,400));
		mode = Anim9or.DRAW_MODE;
		currentColor = Color.BLACK;

		//lineList.add(newLine);
	}
	
	public List<Line> getCurveList() {
		return lineList;
	}
	public List<Curve> getCurveList2() {
		return curveList;
	}
	
	public void setCurrentColor(Color initColor) {
		currentColor = initColor;
	}
	
	public Color getCurrentColor() {
		return currentColor;
	}
	public void setMode(String initMode) {
		mode=initMode;
		a.getPanel().repaint();
	}
	public String getMode(){
		return mode;
	}
	
}
