package oop.pushDataInDB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.beans.Aggrement;
import oop.connectDB.ConnectArangoDB;



//INSERT document INTO collection [ OPTIONS options ]
public class PushAggrement implements PushData{

	private ArrayList<Aggrement> aggrements;
	public PushAggrement(ArrayList<Aggrement> aggrements) {
		this.aggrements = aggrements;
	}
	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", aggrements.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", aggrements.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", aggrements.get(k).getMoTa());
				myObject.addAttribute("Location", aggrements.get(k).getLocation());
				myObject.addAttribute("Time", aggrements.get(k).getTime());
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
