package oop.generatedata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public abstract class Generate {
	public static ArrayList<String> readData(String path) {
		ArrayList<String> data = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buff = new BufferedReader(isr);
			String line = buff.readLine();
			while (line != null) {
				data.add(line);
				line = buff.readLine();
			};
			buff.close();
		} catch (Exception e) {
			System.out.println("Read data :" + e.getMessage());
		}
		return data;
	}

	 public String randomData(ArrayList<String> data) {
		Random ran = new Random();
		int i = ran.nextInt(data.size());
		return data.get(i);
	}
	 
	public abstract  ArrayList<?>generate(int n);
	
}
