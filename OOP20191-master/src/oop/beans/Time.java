package oop.beans;


public class Time extends Entity{
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Time(String dinhDanh, String nhanHienThi, String moTa, String link, String time) {
		super(dinhDanh, nhanHienThi, moTa, link);
		this.time = time;
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
	}
	

}
