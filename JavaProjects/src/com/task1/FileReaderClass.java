package com.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderClass {
	public static void main(String[] args) throws IOException{
		MyBean obj=MyBean.getBeanInstance();
			try (BufferedReader br = new BufferedReader(new FileReader("src/com/task1/data.txt"))) {
				obj.setFirstname(br.readLine());
				obj.setLastname(br.readLine());	
				System.out.println(obj);
			}
		
		catch (FileNotFoundException e) {
		System.out.println(e);
		}
	}
}
