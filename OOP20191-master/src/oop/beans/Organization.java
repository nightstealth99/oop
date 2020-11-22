package oop.beans;



public class Organization extends Entity{
	private String truSo;

	public String getTruSo() {
		return truSo;
	}

	public void setTruSo(String truSo) {
		this.truSo = truSo;
	}

	public Organization(String dinhDanh, String nhanHienThi, String moTa, String link, String truSo) {
		super(dinhDanh, nhanHienThi, moTa, link);
		this.truSo = truSo;
	}
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
	
	
}