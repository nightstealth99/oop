package oop.beans;


public class Aggrement extends Entity{
	
	private String time;
	private String location;
	
	
	
	public Aggrement(String dinhDanh, String nhanHienThi, String moTa, String link, String time, String location) {
		super(dinhDanh, nhanHienThi, moTa, link);
		this.time = time;
		this.location = location;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}

}
