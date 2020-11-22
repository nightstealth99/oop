package oop.pushDataInDB;

import java.util.ArrayList;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import oop.beans.Event;
import oop.connectDB.ConnectArangoDB;
public class PushEvents implements PushData{
	private ArrayList<Event> events;

	public PushEvents(ArrayList<Event> events) {
		this.events = events;
	}

	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", events.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", events.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", events.get(k).getMoTa());
				myObject.addAttribute("Time", events.get(k).getTime());
				myObject.addAttribute("Location", events.get(k).getLocation());
				listdocs.add(myObject);
				if(k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		}
		catch (ArangoDBException e) {
			System.err.println("Failed to create document: "   + e.getMessage());
		}
		
		
	}

		
}
