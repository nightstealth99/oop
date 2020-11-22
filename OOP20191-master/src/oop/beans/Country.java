package oop.beans;


public class Country extends Entity {
private String dienTich;
	
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}

	public Country(String dinhDanh, String nhanHienThi, String moTa, String link, String dienTich) {
		super(dinhDanh, nhanHienThi, moTa, link);
		this.dienTich = dienTich;
	}
	public String getDienTich() {
		return dienTich;
	}

	public void setDienTich(String dienTich) {
		this.dienTich = dienTich;
	}
}
