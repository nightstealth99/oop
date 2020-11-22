package oop.pushDataInDB;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.CollectionEntity;

import oop.connectDB.ConnectArangoDB;

public class Collection {
	public Collection() {
		
	}
	public void createCollection(String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			CollectionEntity myArangoCollection = arangoDatabase.createCollection(collectionName);
			System.out.println("Collection created: " + myArangoCollection.getName());
		} catch (ArangoDBException e) {
			System.err.println("Failed to create collection: " + collectionName + "; " + e.getMessage());
		}
		
	}
	public void deleteCollection(String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArangoCollection myArangoCollection = arangoDatabase.collection(collectionName);
			myArangoCollection.drop();
			System.out.println("Collection dropped: " + collectionName );
		} catch (ArangoDBException e) {
			System.err.println("Failed to delete collection: " + collectionName + "; " + e.getMessage());
		}
		
	}
}
