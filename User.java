package net.javaguides.usermanagement.model;

public class User {
	private String fname;
	private String lname;
	private String dob;
	private static  String city;
	private static int mobilenumber;
	public void User(String fname, String lname, String dob, String city, int mobilenumber) {
		this.fname = fname;
		this.lname = lname;
		this.dob =  dob ;
		this.city = city;
		User.mobilenumber = mobilenumber;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getdob() {
		return dob;
	}
	public void setdob(String dob) {
		this.dob = dob;
	}
	public static String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public static int getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(int mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
}
