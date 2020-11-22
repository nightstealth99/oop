package oop.generatedata;



import java.util.ArrayList;
import java.util.List;

import oop.beans.Location;
import oop.beans.Event;
import oop.beans.Time;
import oop.beans.Aggrement;
import oop.beans.Country;
import oop.beans.Organization;
import oop.beans.Person;

public class GetData {
	private int n;
	private GenerateData generateData;
	
	public GetData(int n) {
		this.n = n;
	}
		
	public ArrayList<Aggrement> getAggrements () {
		generateData = new GenerateAggrement();
		ArrayList<Aggrement> aggrements = (ArrayList<Aggrement>) generateData.getData(n);
		return aggrements;
	}
	
	public ArrayList<Country> getCountries() {
		generateData = new GenerateCountries();
		ArrayList<Country> countries = (ArrayList<Country>) generateData.getData(n);
		return countries;
	}
	
	public ArrayList<Event> getEvents() {
		generateData = new GenerateEvents();
		@SuppressWarnings("unchecked")
		ArrayList<Event> events = (ArrayList<Event>) generateData.getData(n);
		return events;
	}
	
	public ArrayList<Location> getLocations() {
		generateData = new GenerateLocations();
		ArrayList<Location> locations = (ArrayList<Location>) generateData.getData(n);
		return locations;
	}
	
	public ArrayList<Organization> getOrganizations() {
		generateData = new GenerateOrganizations();
		ArrayList<Organization> organizations = (ArrayList<Organization>) generateData.getData(n);
		return organizations;
	}
	
	public ArrayList<Person> getPersons() {
		generateData = new GeneratePersons();
		ArrayList<Person> persons = (ArrayList<Person>) generateData.getData(n);
		return persons;
	}
	
	public ArrayList<Time> getTimes() {
		generateData = new GenerateTimes();
		ArrayList<Time> times = (ArrayList<Time>) generateData.getData(n);
		return times;
	}
}
