package com;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@ComponentScan("com")
@ComponentScan // @EnableWebMvc
public class AppConfig {

	
	
	@Bean //name or id=  derbydatasource
	@Profile("dev")
	public DataSource derbydatasource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:derby://localhost:1527/TrainingDB");
		dataSource.setDriverClassName("org.apache.derby.client.ClientAutoloadedDriver");
		return dataSource;
		
	}
	
	
	@Bean // name or id=mysqldatasource
	@Profile("prod")
	public DataSource mysqldatasource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/productdb");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
}






