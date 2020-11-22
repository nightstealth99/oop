package oop.articleDAO;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.arangodb.entity.BaseDocument;

public class PullArticleDAO {
public  void thongtinNhanVat(String nhanhienthi, String collum, String collection) {
	QueryArticle query= new QueryArticle();
	 query.thongTinVe(nhanhienthi, collum, collection);
//	Map<String, Object> map= object.getProperties();
//	System.out.println(map.get("NhanHienThi"));
}

public static void main(String[] args) {
	Properties prop = new Properties();
	prop.setProperty("log4j.rootLogger", "WARN");
	PropertyConfigurator.configure(prop);
	PullArticleDAO dao=new PullArticleDAO();
	
	dao.thongtinNhanVat("Alibaba0001",  "DinhDanh", "Organization");
	
}
	
}
