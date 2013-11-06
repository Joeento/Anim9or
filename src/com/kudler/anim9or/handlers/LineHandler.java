package com.kudler.anim9or.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.kudler.anim9or.Anim9or;
import com.kudler.anim9or.etchings.Curve;
import com.kudler.anim9or.pen.Line;
import com.kudler.anim9or.pen.Point;

public class LineHandler implements MouseListener, MouseMotionListener {
	public Anim9or anim9or;
	public Line line;
	public int lineIndex;
	public Curve newCurve;
	
	public LineHandler(Anim9or init) {
		anim9or = init;
	}
	@Override
	public void mouseDragged(MouseEvent me) {
		line.setEnd(new Point(me.getX(),me.getY()));
		newCurve.getLineList().get(0).setEnd(new Point(me.getX(),me.getY()));
		anim9or.getDataModel().getCurveList2().set(lineIndex, newCurve);
		anim9or.getPanel().repaint();
		
		//System.out.println(line.getEnd().getX());
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
		newCurve = new Curve(anim9or);
		
		line = new Line(new Point(me.getX(),me.getY()),new Point(me.getX(),me.getY()));
		newCurve.addLine(line);
		 
		
		
		anim9or.getDataModel().getCurveList2().add(newCurve);
		lineIndex = anim9or.getDataModel().getCurveList2().size()-1;
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		//System.out.println("("+line.getStart().getX()+", "+line.getStart().getY()+")"+" ("+line.getEnd().getX()+", "+line.getEnd().getY()+")=("+line.getSlope()+", "+line.getIntercept()+")");
		newCurve.addEndPoint(me.getX(), me.getY());
	}

}
