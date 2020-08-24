package com.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import com.listeners.DrawAppWIndowListener;
import com.shapes.Line;
import com.shapes.Rectangle;
import com.shapes.Shape;


//Entity ==> classes (state, behavoir)

// specs client--server, procossor/engine


public class DrawApplication extends JFrame{
	
	
	//private Point start, end;
	private Shape shape;
	
	private JPanel canvas;
	
	public DrawApplication() {
		
		this.setSize(400, 400);
		this.addWindowListener(new DrawAppWIndowListener());
		this.initializeComponents();
		
		
		this.setVisible(true);
		
		
	}
	
	private void initializeComponents() {
		
		JButton lineButton = new JButton("Line");
		JButton rectButton = new JButton("Rectangle");
		
		lineButton.addActionListener(new LineActionListener());
		rectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out
						.println("DrawApplication rect clicked");
				shape = new Rectangle();
			}
		});
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		topPanel.add(lineButton);
		topPanel.add(rectButton);
		
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		
		
		canvas = new JPanel();
		canvas.setBackground(Color.white);
		canvas.addMouseListener(new DrawMouseListener());
		
		this.getContentPane().add(canvas);
		
		
		
		
	}

	public static void main(String[] args) {
		
		System.out.println("The draw app...");
		new DrawApplication();

	}
	
	class LineActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("DrawApplication.LineActionListener.actionPerformed()");
			shape = new Line();
			
		}
		
	}
	
	class DrawMouseListener extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			shape.setStart(e.getPoint());
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
//			end = e.getPoint();
			
//			Graphics graphics =  canvas.getGraphics();
//			graphics.drawLine(start.x, start.y, end.x, end.y);
			
			shape.setEnd(e.getPoint());
			Graphics graphics =  canvas.getGraphics();
			shape.draw(graphics);
			
			
		
		}
		
	}
	

}















