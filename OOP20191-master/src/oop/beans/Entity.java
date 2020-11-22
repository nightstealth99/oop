package oop.beans;


public abstract class Entity {
	
	
	private String dinhDanh;
	private String nhanHienThi;
	private String moTa;
	private String link;

	public Entity(String dinhDanh, String nhanHienThi, String moTa, String link) {
		super();
		this.dinhDanh = dinhDanh;
		this.nhanHienThi = nhanHienThi;
		this.moTa = moTa;
		this.link = link;
	}
	public String getDinhDanh() {
		return dinhDanh;
	}
	public void setDinhDanh(String dinhDanh) {
		this.dinhDanh = dinhDanh;
	}
	public String getNhanHienThi() {
		return nhanHienThi;
	}
	public void setNhanHienThi(String nhanHienThi) {
		this.nhanHienThi = nhanHienThi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	public abstract void work();
	
	public void printData() {
		System.out.println(this.dinhDanh);
		System.out.println(this.link);
		System.out.println(this.moTa);
		System.out.println(this.nhanHienThi);
	}







}
