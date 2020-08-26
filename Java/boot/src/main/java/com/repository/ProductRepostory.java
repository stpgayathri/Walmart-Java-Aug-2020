package com.repository;

import java.util.List;

import com.model.Product;

public interface ProductRepostory {

	void save(Product product) throws Exception;

	List<Product> fetchAll();
	
	Product	fetchById(int id) throws Exception;
	
	void delete(int id) throws Exception;

}