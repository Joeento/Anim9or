package com.kudler.anim9or.handlers;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.kudler.anim9or.Anim9or;

public class CursorHandler implements MouseListener, MouseMotionListener {
	public Anim9or a;
	
	public CursorHandler(Anim9or initA) {
		a=initA;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		//System.out.println("Length="+a.getPanel().lineList.size());
		boolean wasOver=false;
		for (int i=0;i<a.getDataModel().getCurveList2().size();i++) {
			for (int j=0;j<a.getDataModel().getCurveList2().get(i).getLineList().size();j++) {
				if (a.getDataModel().getCurveList2().get(i).getLineList().get(j).inLine(me.getX(), me.getY())) {
					//System.out.println("SUCCESS!!");
					a.getPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					wasOver=true;
				} else {
					
					//System.out.println(probablyY+"!="+me.getY());
				}
			}
			//int probablyY=(int) (((a.getPanel().lineList.get(i).getSlope()*me.getX())+(a.getPanel().lineList.get(i).getIntercept())));
			
			
		}
		if (!wasOver) {
			
			a.getPanel().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			wasOver=false;
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		boolean hit=false;
		for (int i=0;i<a.getDataModel().getCurveList2().size();i++) {
			a.getDataModel().getCurveList2().get(i).setSelected(false);
			for (int j=0;j<a.getDataModel().getCurveList2().get(i).getLineList().size();j++) {
				
				
				if (a.getDataModel().getCurveList2().get(i).getLineList().get(j).inLine(me.getX(), me.getY())) {
					a.getDataModel().getCurveList2().get(i).setSelected(true);
					a.getPanel().repaint();
					hit=true;
					
					
				}
				//System.out.println(me.getY()+"!="+((int)((a.getDataModel().getCurveList2().get(i).getLineList().get(j).getSlope()*me.getX())+(int)a.getDataModel().getCurveList2().get(i).getLineList().get(j).getIntercept()))+"-"+a.getDataModel().getCurveList2().get(i).getSelected());
				
			}
			
			
		}
		a.getPanel().repaint();
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
