package oop.fact;

import oop.beans.Entity;
import oop.beans.Time;

public class Fact<T,V> {

	private T subject;
	private String quanhe;
	private V object;
	private Entity time;
	
	public  Fact(T t, String quanhe, V v, Time time) {
		super();
		this.subject = t;
		this.quanhe = quanhe;
		this.object = v;
		this.time = time;
	}

	public T getSubject() {
		return subject;
	}

	public void setSubject(T subject) {
		this.subject = subject;
	}

	public String getQuanhe() {
		return quanhe;
	}

	public void setQuanhe(String quanhe) {
		this.quanhe = quanhe;
	}

	public V getObject() {
		return object;
	}

	public void setObject(V object) {
		this.object = object;
	}

	public Entity getTime() {
		return time;
	}

	public void setTime(Entity time) {
		this.time = time;
	}



}
