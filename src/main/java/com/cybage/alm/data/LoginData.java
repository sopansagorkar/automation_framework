package com.cybage.alm.data;

public class LoginData {

	public String userName;
	public String passowrd;

	public LoginData(String userName, String passowrd) {
		super();
		this.userName = userName;
		this.passowrd = passowrd;
	}

	public LoginData() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

}
