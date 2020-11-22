package oop.beans;



public class Person extends Entity{
	private String chucVu;
	private String quocTich;
	
	public Person(String dinhDanh, String nhanHienThi, String moTa, String link, String chucVu, String quocTich) {
		super(dinhDanh, nhanHienThi, moTa, link);
		this.chucVu = chucVu;
		this.quocTich = quocTich;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
	  
}
