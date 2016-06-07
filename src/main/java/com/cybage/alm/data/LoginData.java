package com.cybage.alm.data;

import org.apache.poi.ss.usermodel.Row;

public class LoginData {

	public String userName;
	public String password;

	public LoginData(String userName, String passowrd) {
		super();
		this.userName = userName;
		this.password = passowrd;
	}
	public LoginData buildLoginData(Row row) {
		LoginData ld = new LoginData();
		ld.setUserName(row.getCell(0).toString().trim());
		ld.setPassword(row.getCell(1).toString().trim());
		return ld;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
