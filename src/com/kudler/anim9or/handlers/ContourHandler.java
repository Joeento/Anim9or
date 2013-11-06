package com.kudler.anim9or.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import com.kudler.anim9or.Anim9or;
import com.kudler.anim9or.etchings.Contour;
import com.kudler.anim9or.pen.Point;

public class ContourHandler implements MouseListener, MouseMotionListener {
	public Anim9or a;
	public ContourHandler(Anim9or initA) {
		a=initA;
	}
	

	@Override
	public void mouseDragged(MouseEvent me) {
		for (int i=0;i<a.getDataModel().getCurveList2().size();i++) {
			ArrayList<Contour> contours=a.getDataModel().getCurveList2().get(i).getContourList();
			for (int j=0;j<contours.size();j++) {
				if (contours.get(j).getSelected()) {
					contours.get(j).setPoint(new Point(me.getX(),me.getY()));
					if (j>0) {
						a.getDataModel().getCurveList2().get(i).getLineList().get(j-1).getEnd().setX(me.getX());
						a.getDataModel().getCurveList2().get(i).getLineList().get(j-1).getEnd().setY(me.getY());
					}
					if (j<a.getDataModel().getCurveList2().get(i).getLineList().size()) {
						a.getDataModel().getCurveList2().get(i).getLineList().get(j).getStart().setX(me.getX());
						a.getDataModel().getCurveList2().get(i).getLineList().get(j).getStart().setY(me.getY());
					}
					
					
				}
			}
		}
		 
		a.getPanel().repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		for (int i=0;i<a.getDataModel().getCurveList2().size();i++) {
			ArrayList<Contour> contours=a.getDataModel().getCurveList2().get(i).getContourList();
			for (int j=0;j<contours.size();j++) {
				contours.get(j).setSelected(false);
				if (contours.get(j).getPoint().equals(me.getX(),me.getY())) {
					contours.get(j).setSelected(true);
					//System.out.println("hit!");
					a.getPanel().repaint();
				}
			}
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
