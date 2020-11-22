package oop.fact;

import java.util.ArrayList;
import java.util.Random;

import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.beans.Aggrement;
import oop.beans.Country;
import oop.beans.Event;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;
import oop.connectDB.ConnectArangoDB;

public class PushFact {
	String collectionName;
	int m;

	public PushFact(String collectionName, int m) {
		this.collectionName = collectionName;
		this.m = m;
	}

	public void pushFactIntoDatabase(ArrayList<Organization> organizations, ArrayList<Time> times,
			ArrayList<Country> countrys, ArrayList<Event> events, ArrayList<Person> persons,
			ArrayList<Location> locations, ArrayList<Aggrement> aggrements) {
		this.gap_go(persons, persons, times);
		this.to_chuc(persons, events, times);
		this.ky_thoa_thuan(countrys, countrys, times);
		this.tham_gia(persons, organizations, times);
		this.dien_ra_tai(events, locations, times);
		this.ung_ho(persons, aggrements, times);
		this.phan_doi(persons, aggrements, times);
		this.phat_bieu_tai(persons, persons, times);
		this.cang_thang_voi(persons, persons, times);
		this.huy_bo(persons, persons, times);
		this.dam_phan_voi(persons, persons, times);
	}

	public void gap_go(ArrayList<Person> a, ArrayList<Person> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_1");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "gap_go");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}

	}

	public void to_chuc(ArrayList<Person> a, ArrayList<Event> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_2");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "to_chuc");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void ky_thoa_thuan(ArrayList<Country> a, ArrayList<Country> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_3");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "ky_thoa_thuan");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void tham_gia(ArrayList<Person> a, ArrayList<Organization> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_4");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "tham_gia");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void dien_ra_tai(ArrayList<Event> a, ArrayList<Location> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_5");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "dien_ra_tai");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void ung_ho(ArrayList<Person> a, ArrayList<Aggrement> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_6");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "ung_ho");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void phan_doi(ArrayList<Person> a, ArrayList<Aggrement> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_7");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "phan_doi");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void phat_bieu_tai(ArrayList<Person> a, ArrayList<Person> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_8");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "phat_bieu_tai");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void cang_thang_voi(ArrayList<Person> a, ArrayList<Person> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_9");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "cang_thang_voi");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void huy_bo(ArrayList<Person> a, ArrayList<Person> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_10");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "huy_bo");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public void dam_phan_voi(ArrayList<Person> a, ArrayList<Person> b, ArrayList<Time> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k) + "_11");
				myObject.addAttribute("Subject", a.get(randomS).getNhanHienThi());
				myObject.addAttribute("Object", b.get(randomO).getNhanHienThi());
				myObject.addAttribute("QuanHe", "dam_phan_voi");
				myObject.addAttribute("Time", c.get(randomT).getNhanHienThi());
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}
}
