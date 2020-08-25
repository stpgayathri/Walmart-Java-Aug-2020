package com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Load Spring container
    	//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    	applicationContext.getEnvironment().setActiveProfiles("dev");
    	applicationContext.register(AppConfig.class);
    	applicationContext.refresh();
    	
    	
    	//HelloImpl helloImpl = applicationContext.getBean(HelloImpl.class);
    	
    	Hello hello = applicationContext.getBean(Hello.class);
    	System.out.println(hello.sayHello());
    	
    	
    	ProductService service = applicationContext.getBean(ProductService.class);
    	
    	service.save(new Product(104, "IPhone 11", 92000));
    	
//    	List<Product> products = service.fetchAllProducts();
//    	for (Product product : products) {
//			System.out.println(String.format("Id: %d, Name: %s, Price: %.2f", product.getId(), product.getName(), product.getPrice()));
//			
//			
//		}

    	
    	
    	
    }
}
