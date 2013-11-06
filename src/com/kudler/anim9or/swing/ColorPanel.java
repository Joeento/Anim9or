package com.kudler.anim9or.swing;

import java.awt.Color;

import javax.swing.JPanel;

public class ColorPanel extends JPanel {
	public Color color;
	public ColorPanel(Color  initColor) {
		color = initColor;
		setBackground(color);
		setSize(100,100);
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color initColor) {
		color = initColor;
		setBackground(color);
	}

}
