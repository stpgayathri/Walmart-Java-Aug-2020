package com.shapes;

import java.awt.Graphics;

public class Rectangle extends Shape{

	
	@Override
	public void draw(Graphics g) {
		
		g.drawRect(start.x, start.y, end.y - start.y, end.x -start.x);
		
	}

	@Override
	public Shape createObject() {
		
		return new Rectangle();
	}

}
