package com.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class Product {

	private int id;
	
	@NotBlank
	private String name;
	
	@Min(10)
	private double price;
	
	public Product() {
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return String.format("Id: %d, Name: %s, Price: %.2f", id, name, price);
		
	}
	
	
}
