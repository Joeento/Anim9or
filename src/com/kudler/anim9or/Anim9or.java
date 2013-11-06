package com.kudler.anim9or;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JToolBar.Separator;
import javax.swing.border.EtchedBorder;

import com.kudler.anim9or.handlers.ColorHandler;
import com.kudler.anim9or.handlers.ContourHandler;
import com.kudler.anim9or.handlers.CursorHandler;
import com.kudler.anim9or.handlers.DrawBarHandler;
import com.kudler.anim9or.handlers.LineHandler;
import com.kudler.anim9or.handlers.PenHandler;
import com.kudler.anim9or.swing.AFrame;
import com.kudler.anim9or.swing.APanel;
import com.kudler.anim9or.swing.ColorPanel;

public class Anim9or {
	public static String DRAW_MODE = "DRAW_MODE";
	public static String CONTOUR_MODE = "CONTOUR_MODE";
	
	public AFrame window;
	public APanel panel;
	public JToolBar displayBar;
	public JToolBar drawBar;
	public JPanel colorPanel;
	public DrawBarHandler dbh;
	public PenHandler ph;
	public LineHandler lh;
	public CursorHandler ch;
	public ContourHandler coh;
	public int colorX=1;
	public int colorY=0;
	public Anim9orDataModel data;
	public ColorPanel colorDisplay;
	public Anim9or() {
		data = new Anim9orDataModel(this);
		initWindow();
		initToolBar();
	}
	public void initWindow() {
		displayBar = new JToolBar("Still draggable");
		drawBar = new JToolBar("Draw Tool Bar");
		window = new AFrame();
		panel = new APanel(this);
		ch = new CursorHandler(this);
		ph =new PenHandler(this);
		lh =new LineHandler(this);
		dbh = new DrawBarHandler(this);
		coh = new ContourHandler(this);
		
		panel.addMouseListener(ch);
		panel.addMouseMotionListener(ch);
		window.add(panel);
		
	}
	public void initToolBar() {
		colorPanel = new JPanel();
		colorPanel.setLayout(new GridBagLayout());
		
		
		addToolBarItem(displayBar, "images/line.png","Line View");
		addToolBarItem(displayBar, "images/contour.png","Contour View");
		addToolBarItem(drawBar, "images/drawCursor.png","Cursor");
		addToolBarItem(drawBar, "images/drawContour.png","Contour");
		addToolBarItem(drawBar, "images/drawCurve.png","Draw Curve");
		addToolBarItem(drawBar, "images/drawLine.png","Draw Line");
		drawBar.add(colorPanel);
		
		
		addColorButton(Color.BLACK);
		addColorButton(Color.GRAY);
		addColorButton(Color.MAGENTA);
		addColorButton(Color.RED);
		addColorButton(Color.ORANGE);
		addColorButton(Color.YELLOW);
		addColorButton(Color.GREEN);
		addColorButton(Color.CYAN);
		addColorButton(Color.BLUE);
		addColorButton(new Color(163,73,164));
		addColorButton(Color.WHITE);
		addColorButton(Color.LIGHT_GRAY);
		addColorButton(new Color(185, 122, 87));
		addColorButton(Color.PINK);
		addColorButton(new Color(255,201,14));
		addColorButton(new Color(239,228,176));
		addColorButton(new Color(181,230,29));
		addColorButton(new Color(153,217,234));
		addColorButton(new Color(112,146,190));
		addColorButton(new Color(200,191,231));
		
		GridBagConstraints c = new GridBagConstraints();
		colorDisplay = new ColorPanel(Color.BLACK);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight=colorY+1;
		c.ipadx=20;
		c.ipady=20;
		c.insets = new Insets(3, 3, 3, 3);
		colorDisplay.setBorder(BorderFactory.createEtchedBorder());
		colorPanel.add(colorDisplay , c);
		
		displayBar.addSeparator(new Dimension(50,20));		
		window.add(displayBar,BorderLayout.PAGE_END);
		window.add(drawBar,BorderLayout.PAGE_START);
		
	}
	
	public void addToolBarItem(JToolBar bar,String imgLocation, String toolTipText) {
		JButton button = new JButton();
		button.setToolTipText(toolTipText);		
		button.setIcon(new ImageIcon(imgLocation, toolTipText));
		button.addActionListener(dbh);
		bar.add(button);
		
	}
	public void addColorButton(Color color) {
		GridBagConstraints c = new GridBagConstraints();
		
		ColorPanel colorButton = new ColorPanel(color);
		c.gridx = colorX;
		c.gridy = colorY;
		c.ipadx=8;
		c.ipady=8;
		c.insets = new Insets(1, 1, 1, 1);
		colorButton.setBorder(BorderFactory.createEtchedBorder());
		colorPanel.add(colorButton , c);
		colorButton.addMouseListener(new ColorHandler(this));
		colorX++;
		if (colorX>9) {
			colorX=1;
			colorY++;
		}
		
		//add listener
		
		//colorPanel.add(button);
	}
	
	public APanel getPanel() {
		return panel;
	}
	
	
	public static void main(String[] args) {
		Anim9or a = new Anim9or();
	}
	public void setListener(int i) {
		if (i==0) {
			panel.removeMouseListener(ch);
			panel.removeMouseMotionListener(ch);
			panel.removeMouseListener(ph);
			panel.removeMouseMotionListener(ph);
			panel.removeMouseListener(coh);
			panel.removeMouseMotionListener(coh);
			
			panel.addMouseListener(lh);
			panel.addMouseMotionListener(lh);
		} else if (i==1) {
			panel.removeMouseListener(ch);
			panel.removeMouseMotionListener(ch);
			panel.removeMouseListener(lh);
			panel.removeMouseMotionListener(lh);
			panel.removeMouseListener(coh);
			panel.removeMouseMotionListener(coh);

			panel.addMouseListener(ph);
			panel.addMouseMotionListener(ph);
		} else if (i==2) {
			panel.removeMouseListener(ph);
			panel.removeMouseMotionListener(ph);
			panel.removeMouseListener(lh);
			panel.removeMouseMotionListener(lh);
			panel.removeMouseListener(coh);
			panel.removeMouseMotionListener(coh);

			panel.addMouseListener(ch);
			panel.addMouseMotionListener(ch);	
		}else if (i==3) {
			panel.removeMouseListener(ph);
			panel.removeMouseMotionListener(ph);
			panel.removeMouseListener(lh);
			panel.removeMouseMotionListener(lh);
			panel.removeMouseListener(ch);
			panel.removeMouseMotionListener(ch);
			
			panel.addMouseListener(coh);
			panel.addMouseMotionListener(coh);
		}
		
	}
	public Anim9orDataModel getDataModel() {
		return data;
	}
	public ColorPanel getColorDisplay() {
		return colorDisplay;
	}
	public void setColorDisplay(ColorPanel  initColorDisplay) {
		colorDisplay = initColorDisplay;
	}
	

}
