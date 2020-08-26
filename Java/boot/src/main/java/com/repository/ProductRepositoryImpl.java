package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.exceptions.ProductNotFoundException;
import com.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepostory {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;



	@Override
	public void save(Product product) throws Exception {

		System.out.println("ProductRepository.save()");

		String insertSQL = "insert into products(id, name, price) values(?, ?, ?)";
		int rowsAffected = jdbcTemplate.update(insertSQL, product.getId(), product.getName(), product.getPrice());
		if (rowsAffected != 1) {
			throw new Exception("Product Save Failed");
		}

	}

	@Override
	public List<Product> fetchAll() {

		System.out.println("ProductRepository.fetchAll()");
		String query = "Select * from products";
		List<Product> products = jdbcTemplate.query(query, new ProductRowMapper());
		return products;
	}

	@Override
	public Product fetchById(int id) throws Exception {

		System.out.println("ProductRepositoryImpl.fetchById()");

		String query = "select * from products where id=?";

		Product product;
		try {
			product = jdbcTemplate.queryForObject(query, new ProductRowMapper(), id);
			System.out.println("ProductRepositoryImpl.fetchById(): " + product);
			return product;

		} catch (EmptyResultDataAccessException e) {

			e.printStackTrace();
			throw new ProductNotFoundException();
			
		} catch (DataAccessException e) {

			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void delete(int id) throws Exception {
		
		String deleteSQL = "delete from products where id = ?";
		int rowsAffceted = jdbcTemplate.update(deleteSQL, id);
		if(rowsAffceted != 1) {
			throw new ProductNotFoundException();	
		}
		
		
	}
	
	private static final class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

			return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
		}
	}

}












