package oop.beans;



public class Location extends Entity{
	private String country;
	
	public Location(String dinhDanh, String nhanHienThi, String moTa, String link, String country) {
		super(dinhDanh, nhanHienThi, moTa, link);
		
		this.country = country;
	}	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
}
