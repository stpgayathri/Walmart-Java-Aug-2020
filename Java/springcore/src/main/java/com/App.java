package com;

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
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	//HelloImpl helloImpl = applicationContext.getBean(HelloImpl.class);
    	
    	Hello hello = applicationContext.getBean(Hello.class);
    	System.out.println(hello.sayHello());
    	
    	
    	
    	
    }
}
