package com.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Account;
import com.entity.Customer;
import com.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	//CRUD
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> save(@RequestBody Customer customer){
		
		try {
			Customer result =  repository.save(customer);
			return new ResponseEntity<Customer>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping
	public List<Customer> fetchAll(){
		
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer fetchById(@PathVariable int id) {
		
		
		return repository.findById(id).get();
	}
	
	@GetMapping("/name/{name}")
	public Customer fetchByName(@PathVariable String name) {
		
		
		return repository.findByName(name);
	}
	
	@GetMapping("/accounts/{id}")
	public Set<Account> fetchAccountsById(@PathVariable("id") int custId){
		
		Customer customer =  repository.findById(custId).get();
		return customer.getAccounts();
		
	}
}


















