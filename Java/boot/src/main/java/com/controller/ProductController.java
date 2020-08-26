package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exceptions.ProductNotFoundException;
import com.model.Product;
import com.repository.ProductRepostory;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepostory repository;
	
	// /products/hello?msg=abc
	@RequestMapping("/hello")
	public String sayHello(@RequestParam("msg") String msg) {
		
		System.out.println("HomeController.sayHello() " + msg);
		return "Hello " + msg.toUpperCase();
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> fetchAll(){
		
		return repository.fetchAll();
		
	}
	
	@GetMapping(value = "/{pid}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//public Product fetchById(@PathVariable("pid") int id) {
	public ResponseEntity<Product> fetchById(@PathVariable("pid") int id) {
		
		try {
			Product product = repository.fetchById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
			
			
		} catch (ProductNotFoundException e) {
			
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> create(@RequestBody Product product){
		
		try {
			
			repository.save(product);
			return ResponseEntity.ok().build();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}








