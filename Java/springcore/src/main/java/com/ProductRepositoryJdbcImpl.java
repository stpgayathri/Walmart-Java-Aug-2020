package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ProductRepositoryJdbcImpl implements ProductRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) {
		
		System.out.println("ProductRepositoryJdbcImpl.save()");
		String insert = "insert into products (id, name, price) values(?, ?, ?)";
		int rowsAffected =  jdbcTemplate.update(insert, product.getId(), product.getName(), product.getPrice());
		
		if(rowsAffected == 1) {
			System.out.println("Saved the product");
		}
		else {
			System.out.println("Failed to save");
		}
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
