package oop.connectDB;

import java.util.ArrayList;

import oop.beans.Aggrement;
import oop.beans.Country;
import oop.beans.Entity;
import oop.beans.Event;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;
import oop.fact.Fact;
import oop.fact.PushFact;
import oop.generatedata.GenerateCountries;
import oop.generatedata.GenerateEvents;
import oop.generatedata.GeneratePersons;
import oop.generatedata.GetData;
import oop.pushDataInDB.Collection;
import oop.pushDataInDB.PushAggrement;
import oop.pushDataInDB.PushCountries;
import oop.pushDataInDB.PushData;
import oop.pushDataInDB.PushEvents;
import oop.pushDataInDB.PushLocations;
import oop.pushDataInDB.PushOrganizations;
import oop.pushDataInDB.PushPersons;
import oop.pushDataInDB.PushTimes;



public class PushDataInDatabase {
	// gọi các phương thức để đẩy dữ liệu vào database
	public PushDataInDatabase() {

	}

	public static void save(int n, int m) {
		long start, end;
		long startread, endread;
		startread = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		GetData getData = new GetData(n);
		ArrayList<Organization> organizations = getData.getOrganizations();
		ArrayList<Time> times = getData.getTimes();
		ArrayList<Country> countrys = getData.getCountries();
		ArrayList<Event> events = getData.getEvents();
		ArrayList<Person> persons = getData.getPersons();
		ArrayList<Location> locations = getData.getLocations();
		ArrayList<Aggrement> aggrements = getData.getAggrements();
		endread = System.currentTimeMillis();
		System.out.println("read Data from file: " + (endread- startread));
		
		
		Collection coll = new Collection();
		coll.deleteCollection("Organization");
		coll.deleteCollection("Time");
		coll.deleteCollection("Country");
		coll.deleteCollection("Event");
		coll.deleteCollection("Person");
		coll.deleteCollection("Location");
		coll.deleteCollection("Agreement");
		coll.deleteCollection("Fact");
//		
		coll.createCollection("Organization");
		coll.createCollection("Time");
		coll.createCollection("Country");
		coll.createCollection("Event");
		coll.createCollection("Person");
		coll.createCollection("Location");
		coll.createCollection("Agreement");
		coll.createCollection("Fact");
		
		PushData pushData = new PushOrganizations(organizations);
		
		start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		pushData.pushData(n, "Organization");
	
		pushData = new PushTimes(times);
		pushData.pushData(n, "Time");

		pushData = new PushCountries(countrys);
		pushData.pushData(n, "Country");
		
		pushData = new PushEvents(events);
		pushData.pushData(n, "Event");
		
		pushData = new PushPersons(persons);
		pushData.pushData(n, "Person");
		
		pushData = new PushLocations(locations);
		pushData.pushData(n, "Location");
		
		pushData = new PushAggrement(aggrements);
		pushData.pushData(n, "Agreement");
		
		end = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		System.out.println("push Data into Database: " + (end- start));
		
		start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		
		PushFact fact = new PushFact("Fact", m);
		fact.pushFactIntoDatabase(organizations, times, countrys, events, persons, locations, aggrements);
		fact.gap_go(persons, persons, times);
		fact.to_chuc(persons, events, times);
		fact.ky_thoa_thuan(countrys, countrys, times);
		fact.tham_gia(persons, organizations, times);
		fact.dien_ra_tai(events, locations, times);
		fact.ung_ho(persons, aggrements, times);
		fact.phan_doi(persons, aggrements, times);
		fact.phat_bieu_tai(persons, persons, times);
		fact.cang_thang_voi(persons, persons, times);
		fact.huy_bo(persons, persons, times);
		fact.dam_phan_voi(persons, persons, times);
		end = System.currentTimeMillis(); // start lấy thời gian theo millisecond
	
		System.out.println("push Fact into Database: " + (end- start));
		
		
	}

}
