package com.shapes;

import java.awt.Graphics;

// is a Shape
public class Line extends Shape{

	@Override
	public void draw(Graphics graphics) {
		
		graphics.drawLine(start.x, start.y, end.x, end.y);
	}
	
	@Override
	public void displayCoordinates() {
		// TODO Auto-generated method stub
		super.displayCoordinates();
	}

	@Override
	public Shape createObject() {
		
		return new Line();
	}
	
}
