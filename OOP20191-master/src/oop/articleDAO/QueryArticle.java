package oop.articleDAO;

import java.util.Map;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import com.arangodb.util.MapBuilder;

import oop.connectDB.ConnectArangoDB;

public class QueryArticle {
	private ArangoDatabase database;
	public QueryArticle() {
		this.database = ConnectArangoDB.getConnection();
	}

	public void thongTinVe(String nhanhienthi, String collum, String collection ) {
		String query="FOR t IN "+collection +" FILTER t."+collum+ " == @name RETURN t";
		Map<String, Object> bindVars = new MapBuilder().put("name", nhanhienthi).get();
		ArangoCursor<BaseDocument> cursor=database.query(query, bindVars, null, BaseDocument.class);
		cursor.forEachRemaining(aDocument -> {
			System.out.println("NhanHienThi: " + aDocument.getAttribute("NhanHienThi"));
			System.out.println("DinhDanh: " + aDocument.getAttribute("DinhDanh"));
			System.out.println("MoTa: " + aDocument.getAttribute("MoTa"));
			System.out.println();
		  });
//		return cursor.next();
	}
	
	
	
}
