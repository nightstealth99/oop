package oop.articleDAO;

import java.util.Map;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.KeyType;
import com.arangodb.model.CollectionCreateOptions;

import oop.connectDB.ConnectArangoDB;

public class CreateArticle {
	private static ArangoDatabase arangodatabase;

	/**
	 * @return the arangodatabase
	 */
	public static ArangoDatabase getArangodatabase() {
		return arangodatabase;
	}

	/**
	 * @param arangodatabase the arangodatabase to set
	 */
	public void setArangodatabase(ArangoDatabase arangodatabase) {
		this.arangodatabase = arangodatabase;
	}

	public static void createCollection(String name) {
		try {
			CollectionCreateOptions options = new CollectionCreateOptions();
			options.keyOptions(false, KeyType.autoincrement, 1, 0);
			arangodatabase.createCollection(name);
			System.out.println("Create success colection :" + name);
		} catch (ArangoDBException e) {
			System.out.println("Create fail collection :" + name + ": " + e.getErrorMessage());
		}
	}

	public static ArangoCollection getCollection(String name) {
		ArangoCollection col = arangodatabase.collection(name);
//		if (col.) {
//			try {
//				CollectionCreateOptions options= new CollectionCreateOptions();
//				options.keyOptions(false,KeyType.autoincrement,1, 0);
//				arangodatabase.createCollection(name,options);
//				System.out.println("Create success colection :" + name);
//				col = arangodatabase.collection(name);
//			} catch (ArangoDBException e) {
//				System.out.println("Create fail collection :" + name + ": " + e.getErrorMessage());
//			}
//		}
		return col;
	}
	public void addDocument(String nameCollection, Map<String, Object> properties) {
		BaseDocument doc = new BaseDocument(properties);
		try {
			getCollection(nameCollection).insertDocument(doc);
			System.out.println("Document created");
		} catch (ArangoDBException e) {
			System.out.println("Failed to create document. " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		ConnectArangoDB co = new ConnectArangoDB();
		arangodatabase = co.getConnection();
		createCollection("col1");
		ArangoCollection col = getCollection("col1");

		System.out.println(col.toString());
	}
}
