package com.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * 
 * @author anilj
 * 
 *    Customers (1) ======================= (*) Accounts
 *    
 *    id(pK)										id(pK)
 *    name											balance	
 *    ...
 *    												custId(FK)
 *
 */

@Entity
@Table(name="accounts")
public class Account {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Basic
	private double balance;
	
	
	@JsonBackReference
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name="custId")
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}








