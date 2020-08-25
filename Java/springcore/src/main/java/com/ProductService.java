package com;

import java.util.List;

public interface ProductService {

	List<Product> fetchAllProducts();

	void save(Product product);

	void update(Product product);

	void delete(int id);

}