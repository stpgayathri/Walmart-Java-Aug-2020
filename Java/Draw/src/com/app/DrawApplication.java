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
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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
	private Shape shape ;
	
	private JPanel canvas;
	private List<Shape> shapes = new ArrayList<Shape>();
	
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
		
		
		JPanel bottomPanel = new JPanel();
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try (FileOutputStream fos = new FileOutputStream("shapes.dat")) {
					
					ObjectOutputStream outputStream = new ObjectOutputStream(fos);
					outputStream.writeObject(shapes);
					System.out.println("Saved the shapes...");

					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		JButton openButton = new JButton("Open");
		openButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try (FileInputStream fileInputStream = new FileInputStream("shapes.dat");
						ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
					
					
					shapes = (List<Shape>) inputStream.readObject();
					
					System.out.println("Finished reading shapes: " + shapes.size());
					for (Shape shape : shapes) {
						
						Graphics graphics = canvas.getGraphics();
						shape.draw(graphics);
					}
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		bottomPanel.add(saveButton);
		bottomPanel.add(openButton);
		this.getContentPane().add(bottomPanel,BorderLayout.SOUTH);
		
		
		
		
	
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		//System.out.println("DrawApplication.paint()");
		super.paint(g);
		for (Shape shape : shapes) {
			Graphics graphics = canvas.getGraphics();
			shape.draw(graphics);
		}
		
		
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
			
			if(shape != null) {
				shape.setStart(e.getPoint());
			}
			
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
//			end = e.getPoint();
			
//			Graphics graphics =  canvas.getGraphics();
//			graphics.drawLine(start.x, start.y, end.x, end.y);
			if(shape != null)
			{
				shape.setEnd(e.getPoint());
				Graphics graphics =  canvas.getGraphics();
				shape.draw(graphics);
				
				shapes.add(shape);
				
				//shape = shape.createObject();
				
				//Reflection
				Class clazz = shape.getClass();
				System.out.println(clazz.getName());
				
				try {
					
					shape = (Shape) clazz.newInstance();
					
					
				} catch (InstantiationException e1) {
					
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
			
		}
		
	}
	

}















