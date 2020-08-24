package com.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public abstract class Shape implements Serializable{

	//state
	protected Point start;
	protected Point end;
	
	
	
	
	//public accesors and mutators

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	
	//behaviors
	public abstract void draw(Graphics graphics);
		
		
	public void displayCoordinates() {
			System.out.println("start: " + start);
			System.out.println("end: " + end);
	}
	
	public abstract Shape createObject();
}
















