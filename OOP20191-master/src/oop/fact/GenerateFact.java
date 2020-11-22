package oop.fact;

import java.util.ArrayList;
import java.util.Random;

import oop.beans.Aggrement;
import oop.beans.Country;
import oop.beans.Entity;
import oop.beans.Event;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;


public class GenerateFact<T,V> {
	private int so_quan_he; // số quan hệ sẽ sinh của mỗi phương thức quan hệ

	public <T,V> GenerateFact(int so_quan_he) {
		this.so_quan_he = so_quan_he;
	}

	public  ArrayList<Fact> generateFact(ArrayList<T> a, ArrayList<V> b, ArrayList<Time> c, String quanhe) {
		Random rd = new Random();
		ArrayList<Fact> fact  = new ArrayList<Fact>();
		int n = a.size();
		for (int i = 0; i< so_quan_he; i++) {
			int randomS = rd.nextInt(n);
			int randomO = rd.nextInt(n);
			int randomT = rd.nextInt(n);
			Fact<T, V> tmp = new Fact<T, V>(a.get(randomS), quanhe, b.get(randomO), c.get(randomT));
			fact.add(tmp);
		}
		return fact;
		
	}

	public int getSo_quan_he() {
		return so_quan_he;
	}

	public void setSo_quan_he(int so_quan_he) {
		this.so_quan_he = so_quan_he;
	}

	
}
