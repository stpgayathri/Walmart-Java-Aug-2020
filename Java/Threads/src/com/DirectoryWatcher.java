package com;

import java.io.File;
import java.util.Scanner;

public class DirectoryWatcher extends Thread{

	private String directoryPath;
	private int filesCount;
	
	
	public DirectoryWatcher(String directoryPath) {
		super();
		this.directoryPath = directoryPath;
		File directory = new File(this.directoryPath);
		String [] allFiles = directory.list();
		filesCount = allFiles.length;
	}
	private void watchDir() {
	
		File directory = new File(this.directoryPath);
		String [] allFiles = directory.list();
		//System.out.println(allFiles.length);
		if(allFiles.length != this.filesCount) {
			
			this.filesCount = allFiles.length;
			System.out.println("Directory Changed: " + this.filesCount);
		}
		else {
			System.out.println("No change");
		}
		
	}
	@Override
	public void run() {
		
		while(true) {
			watchDir();
			
			if(isInterrupted()) {
				System.out.println("isInterrupted exiting...");
				break;
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				//e.printStackTrace();
				System.out.println("InterruptedException exiting...");
				break;
				
			}
			
		}
		System.out.println("Watcher Thread complete");
	}





	public static void main(String[] args) {
		
		DirectoryWatcher directoryWatcherThread = new DirectoryWatcher("C:\\temp");
		//directoryWatcherThread.watchDir();
		directoryWatcherThread.start();
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		while(!line.equalsIgnoreCase("exit")) {
			System.out.println("You entered: " + line);
			line = scanner.nextLine();
		}
		scanner.close();
		System.out.println("Exitted from the scanner");
		
		directoryWatcherThread.interrupt();
		
		
		try {
			directoryWatcherThread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("main thread exiting...");
	}

}








