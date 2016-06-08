package com.cybage.alm.utilities;

import org.testng.annotations.DataProvider;

import com.cybage.alm.data.LoginData;
import com.cybage.alm.data.RegisterData;

public class DataProviders extends Links {

	public int result;

	@DataProvider(name = "loginData")
	public Object[][] loginDataProvider() {
		LoginData[][] data = LoginData.getLoginData(excelPath, loginSheet);
		return data;
	}

	@DataProvider(name = "registerData")
	public Object[][] registerDataProvider() {
		Object[][] data = RegisterData.getRegisterData(excelPath, registerSheet);
		return data;
	}

}
