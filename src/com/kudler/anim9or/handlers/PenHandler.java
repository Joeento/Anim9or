package com.kudler.anim9or.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.kudler.anim9or.Anim9or;
import com.kudler.anim9or.etchings.Curve;
import com.kudler.anim9or.pen.Line;
import com.kudler.anim9or.pen.Point;

public class PenHandler implements MouseListener,MouseMotionListener {
	public Anim9or a;
	public int startX=0;
	public int startY=0;
	public Curve newCurve;
	public int curveIndex;
	public PenHandler(Anim9or initA) {
		a=initA;
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		newCurve.addLine(new Line(new Point(startX,startY), new Point(me.getX(),me.getY())));
		a.getDataModel().getCurveList2().set(curveIndex, newCurve);
		//a.getDataModel().getCurveList().add(new Line(new Point(startX,startY), new Point(me.getX(),me.getY())));
		
		startX=me.getX();
		startY=me.getY();
		
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
		startX=me.getX();
		startY=me.getY();
		newCurve = new Curve(a);
		a.getDataModel().getCurveList2().add(newCurve);
		curveIndex=a.getDataModel().getCurveList2().size()-1;
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		//System.out.println("("+line.getStart().getX()+", "+line.getStart().getY()+")"+" ("+line.getEnd().getX()+", "+line.getEnd().getY()+")=("+line.getSlope()+", "+line.getIntercept()+")");
		newCurve.addEndPoint(me.getX(), me.getY());
	}
}
