package oop.pushDataInDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.beans.Time;
import oop.connectDB.ConnectArangoDB;


public class PushTimes implements PushData{
	private ArrayList<Time> times;


	public PushTimes(ArrayList<Time> times) {
		this.times = times;
	}


	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", times.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", times.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", times.get(k).getMoTa());
				myObject.addAttribute("Time", times.get(k).getTime());
				listdocs.add(myObject);
				if(k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		}
		catch (ArangoDBException e) {
			System.err.println("Failed to create document: " + collectionName  + e.getMessage());
		}
		
	}


	
}
