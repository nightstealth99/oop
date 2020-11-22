package oop.main;

import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import com.arangodb.ArangoDatabase;

import oop.connectDB.ConnectArangoDB;
import oop.connectDB.PushDataInDatabase;
import oop.articleDAO.*;
import testtime.*;
public class TestMain {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(prop);
		ArangoDatabase c = ConnectArangoDB.getConnection();
		if (c == null) {
			System.out.println("something wrong");
		} else {
			System.out.println("ok");
		}
		
		long start, end;
//
		start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		PushDataInDatabase.save((int)(100/7), (int)(200/11));
		end = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		System.out.println("Time Millis: " + (end - start));
		System.out.println("success");
		
//		Scanner a = new Scanner(System.in);
//		int i=a.nextInt();
//		QueryArticle query = new QueryArticle();
//		Test11 test = new Test11();
//		start = System.currentTimeMillis();
//		test.thongTinVe("Apple0001", "NhanHienThi", "Organization");
////		test.demsosukien();
//		end = System.currentTimeMillis();
//		System.out.println("Time Millis: " + (end - start));
	}
}
