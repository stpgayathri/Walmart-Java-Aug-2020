package com;

public class Counter {

	int count;
	
	private Object mutex = new Object();



	public void increment() {

		 this.count++;
		
		
		
	}

	public void decrement() {

		this.count--;
		
	}

}
