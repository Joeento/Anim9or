package com.kudler.anim9or.etchings;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.kudler.anim9or.Anim9or;
import com.kudler.anim9or.pen.Line;

public class Curve extends Shape {
	public Color color;
	public ArrayList<Contour> contourList;
	
	public boolean selected=false;
	List<Line> lineList;
	public Anim9or a;
	public Curve(Anim9or initA) {
		a = initA;
		lineList = new ArrayList<Line>();
		contourList = new ArrayList<Contour>(); 
		color = a.getDataModel().getCurrentColor();
	}
	public void addLine(Line newLine) {
		lineList.add(newLine);
		contourList.add(new Contour(newLine.getStart()));
	}
	public List<Line> getLineList() {
		return lineList;
	}
	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean initS) {
		selected=initS;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color initColor) {
		color = initColor;
	}
	public ArrayList<Contour> getContourList() {
		return contourList;
	}
	public void addEndPoint(int initX, int initY) {
		contourList.add(new Contour(initX,initY));
	}
}
