package com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) {
		
		
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(25);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 60, TimeUnit.SECONDS, workQueue);
		
		
		
		threadPoolExecutor.shutdown();
		
		
		try {
			threadPoolExecutor.awaitTermination(3, TimeUnit.MINUTES);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("ExecutorDemo.main() completed");
		

	}

}
