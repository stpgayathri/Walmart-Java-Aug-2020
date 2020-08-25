package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		
		
		ExecutorService executorService 
							//= Executors.newCachedThreadPool();
								//= Executors.newFixedThreadPool(20);
								= Executors.newSingleThreadExecutor();
	
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Task(i));
		}

		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("ExecutorServiceDemo.main() completed");
	}

}
