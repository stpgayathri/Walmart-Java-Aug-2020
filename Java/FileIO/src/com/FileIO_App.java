package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileIO_App {

	public static void main(String[] args) {

		// writeToFile();
		//writeToFileResource();
		readFromFile();

	}

	private static void readFromFile() {
		
		try (FileReader fileReader = new FileReader("info.txt");
				BufferedReader reader = new BufferedReader(fileReader)) {
			String content = reader.readLine();
			while(content != null) {
				
				System.out.println(content);
				content = reader.readLine();
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	private static void writeToFileResource() {

		try (FileOutputStream fileOutputStream = new FileOutputStream("data.txt")) {

			fileOutputStream.write("hello world with resources".getBytes());
			System.out.println("FileIO_App.writeToFile() completed");
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.fillInStackTrace();
		}

	}

	private static void writeToFile() {
		
		FileOutputStream fileOutputStream = null;
		try {
			
			fileOutputStream =  new FileOutputStream("data.txt");
			fileOutputStream.write("hello world".getBytes());
			
			System.out.println("FileIO_App.writeToFile() completed");
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} 
		catch (IOException e) {

			e.fillInStackTrace();
		}finally {
			
			if(fileOutputStream != null)
			{
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
