package com.kudler.anim9or.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kudler.anim9or.Anim9or;

public class DrawBarHandler implements ActionListener {
	public Anim9or a;
	public DrawBarHandler(Anim9or initA) {
		a=initA;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton source =(JButton)ae.getSource();
		if (source.getToolTipText().equals("Draw Line")) {
			a.getDataModel().setMode(Anim9or.DRAW_MODE);
			a.setListener(0);

		} else if (source.getToolTipText().equals("Draw Curve")) {
			a.getDataModel().setMode(Anim9or.DRAW_MODE);
			a.setListener(1);

		} else if ((source.getToolTipText().equals("Cursor"))) {
			a.getDataModel().setMode(Anim9or.DRAW_MODE);
			a.setListener(2);
			
		} else if ((source.getToolTipText().equals("Contour"))) {
			a.getDataModel().setMode(Anim9or.CONTOUR_MODE);
			a.setListener(3);
			
		}
		
	}

}
