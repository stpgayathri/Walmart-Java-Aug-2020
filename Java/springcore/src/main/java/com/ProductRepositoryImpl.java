package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository // id or name ==> productRepositoryImpl
public class ProductRepositoryImpl implements ProductRepository {

	
	//CRUD operation on a product DB table
	
	@Autowired
	//@Qualifier("derbydatasource")
	private DataSource dataSource;
	
	@Override
	public List<Product> fetchAllProducts(){
		
		System.out.println("ProductRepositoryImpl.fetchAllProducts()");
		
		List<Product> products = new ArrayList<Product>();
		
			
			try (Connection connection = dataSource.getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from products" )) {
				while(resultSet.next()) {
					
					Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
					products.add(product);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return products;
		
	}
	
	@Override
	public void save(Product product) {
		System.out.println("ProductRepositoryImpl.save()");
		
		try {
			
			//Connection connection =  DriverManager.getConnection("jdbc:derby://localhost:1527/TrainingDB");
			Connection connection = dataSource.getConnection();
			String insert = "insert into products (id, name, price) values(?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			
			
			int rowsAffected = preparedStatement.executeUpdate();
			if(rowsAffected == 1) {
				System.out.println("Saved the product");
			}
			else {
				System.out.println("Failed to save");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(Product product) {
		System.out.println("ProductRepositoryImpl.update()");
	}
	
	@Override
	public void delete(int id) {
		System.out.println("ProductRepositoryImpl.delete()");
	}
}








