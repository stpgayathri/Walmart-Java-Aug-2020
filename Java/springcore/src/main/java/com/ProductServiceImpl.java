package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository ;
	
	@Override
	public List<Product> fetchAllProducts(){
		
		System.out.println("ProductServiceImpl.fetchAllProducts()");
		return repository.fetchAllProducts();
		
	}
	
	@Override
	public void save(Product product) {
		
		System.out.println("ProductServiceImpl.save()");
		repository.save(product);
	}
	
	
	@Override
	public void update(Product product) {
		
		System.out.println("ProductServiceImpl.update()");
		repository.update(product);
	}
	
	
	@Override
	public void delete(int id) {
		
		System.out.println("ProductServiceImpl.delete()");
		repository.delete(id);
		
	}
}
