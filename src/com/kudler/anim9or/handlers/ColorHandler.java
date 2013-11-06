package com.kudler.anim9or.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.kudler.anim9or.Anim9or;
import com.kudler.anim9or.swing.ColorPanel;

public class ColorHandler implements MouseListener {
	public Anim9or a;
	public ColorHandler(Anim9or initA) {
		a=initA;
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		ColorPanel cp = (ColorPanel)me.getSource();
		a.getDataModel().setCurrentColor(cp.getColor());
		for (int i=0;i<a.getDataModel().getCurveList2().size();i++) {
			if (a.getDataModel().getCurveList2().get(i).getSelected()) {
				a.getDataModel().getCurveList2().get(i).setColor(cp.getColor());
			}
		}
		a.getColorDisplay();
		a.getColorDisplay().setColor(cp.getColor());
		// cp.getColor();
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
