package com.kudler.anim9or.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.kudler.anim9or.Anim9or;
import com.kudler.anim9or.pen.Line;
import com.kudler.anim9or.pen.Point;

public class APanel extends JPanel {
	
	public Anim9or a;
	public APanel(Anim9or initA) {
		a= initA;
	}
	public void paintChildren(Graphics g) {
		g.setColor(Color.WHITE);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		if (a.getDataModel().getMode().equals(Anim9or.DRAW_MODE)) {
			for (int i=0;i<a.getDataModel().getCurveList2().size();i++) {
				g.setColor(a.getDataModel().getCurveList2().get(i).getColor());
				for (int j=0;j<a.getDataModel().getCurveList2().get(i).getLineList().size();j++) {
					if ((a.getDataModel().getCurveList2().get(i).getSelected())) {
						g.setColor(Color.CYAN);
						g.drawLine(a.getDataModel().getCurveList2().get(i).getLineList().get(j).getStart().getX(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getStart().getY(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getEnd().getX(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getEnd().getY());
						g.setColor(a.getDataModel().getCurrentColor());
					} else {
						g.drawLine(a.getDataModel().getCurveList2().get(i).getLineList().get(j).getStart().getX(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getStart().getY(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getEnd().getX(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getEnd().getY());	
					}
					
				}
				
			}
		} else if (a.getDataModel().getMode().equals(Anim9or.CONTOUR_MODE)) {
			g.setColor(new Color(79,128,255));
			for (int i=0;i<a.getDataModel().getCurveList2().size();i++) {			
				for (int j=0;j<a.getDataModel().getCurveList2().get(i).getLineList().size();j++) {
					g.drawLine(a.getDataModel().getCurveList2().get(i).getLineList().get(j).getStart().getX(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getStart().getY(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getEnd().getX(), a.getDataModel().getCurveList2().get(i).getLineList().get(j).getEnd().getY());				
				}
				for (int j=0;j<a.getDataModel().getCurveList2().get(i).getContourList().size();j++) {
					g.fillRect(a.getDataModel().getCurveList2().get(i).getContourList().get(j).getX()-4, a.getDataModel().getCurveList2().get(i).getContourList().get(j).getY()-4, 8, 8);
					if (!a.getDataModel().getCurveList2().get(i).getContourList().get(j).getSelected()) {
						g.setColor(Color.WHITE);
					}
					
					g.fillRect(a.getDataModel().getCurveList2().get(i).getContourList().get(j).getX()-3, a.getDataModel().getCurveList2().get(i).getContourList().get(j).getY()-3, 6, 6);
					g.setColor(new Color(79,128,255));
				}
				
			}

		}
		
		
		

		/*
		for (int i=0;i<a.getDataModel().getCurveList().size();i++) {
			if ((a.getDataModel().getCurveList().get(i).getSelected())) {
				g.setColor(Color.CYAN);
				g.drawLine(a.getDataModel().getCurveList().get(i).getStart().getX(), a.getDataModel().getCurveList().get(i).getStart().getY(), a.getDataModel().getCurveList().get(i).getEnd().getX(), a.getDataModel().getCurveList().get(i).getEnd().getY());
				g.setColor(Color.BLACK);
			} else {
				g.drawLine(a.getDataModel().getCurveList().get(i).getStart().getX(), a.getDataModel().getCurveList().get(i).getStart().getY(), a.getDataModel().getCurveList().get(i).getEnd().getX(), a.getDataModel().getCurveList().get(i).getEnd().getY());
			}
			
		}
		*/
	}
}
