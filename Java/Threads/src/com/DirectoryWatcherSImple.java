package com;

import java.io.File;
import java.util.Scanner;

public class DirectoryWatcherSImple {

	private String directoryPath;
	private int filesCount;

	public DirectoryWatcherSImple(String directoryPath) {
		super();
		this.directoryPath = directoryPath;
		File directory = new File(this.directoryPath);
		String[] allFiles = directory.list();
		filesCount = allFiles.length;
		System.out.println(filesCount);
	}

	private void watchDir() {

		while (true) {
			File directory = new File(this.directoryPath);
			String[] allFiles = directory.list();
			

			if (allFiles.length != this.filesCount) {

				this.filesCount = allFiles.length;
				System.out.println("Directory Changed: " + this.filesCount);
			} else {
				//System.out.println("No change");
			}
		}

	}

	public static void main(String[] args) {

		DirectoryWatcherSImple directoryWatcherThread = new DirectoryWatcherSImple("C:\\temp");
		directoryWatcherThread.watchDir();

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		while(!line.equalsIgnoreCase("exit")) {
			System.out.println("You entered: " + line);
			line = scanner.nextLine();
		}
		scanner.close();
		System.out.println("Exitted from the scanner");

		System.out.println("main thread exiting...");
	}

}







