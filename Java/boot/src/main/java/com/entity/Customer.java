package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/***
 * 
 * @author anilj
 * 
 * 
 *    Customers (Table)
 *    
 *    id int pk identity
 *    name varchar(25)
 *    city varchar
 *    state varchar
 *    pincode varchar
 *    
 *
 */

@Entity
@Table(name="Customers")
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	private int id;
	
	//@Basic
	private String name;
	
	@Embedded
	private Address address;
	
	
	@OneToMany(targetEntity = Account.class, mappedBy = "customer")
	private Set<Account> accounts = new HashSet<Account>();
	
	
	
	


	public Customer() {
	}


	public Customer(int id, String name, Address address) {
		//super();
		this.id = id;
		this.name = name;
		this.address = address;
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


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public Set<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
}





