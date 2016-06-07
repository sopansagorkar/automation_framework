package com.cybage.alm.utilities;

import org.testng.annotations.DataProvider;

import com.cybage.alm.data.LoginData;
import com.cybage.alm.data.RegisterData;

public class DataProviders {

	public int result;

	@DataProvider(name = "loginData")
	public Object[][] loginDataProvider() {
		LoginData[][] data = LoginData.getLoginData(
				"D:\\Mars Workspace\\automation_framework_ALMQA\\src\\test\\resources\\loginData.xlsx", "Sheet1");
		return data;
	}

	@DataProvider(name = "registerData")
	public Object[][] registerDataProvider() {
		Object[][] data = RegisterData.getRegisterData(
				"D:\\Mars Workspace\\automation_framework_ALMQA\\src\\test\\resources\\registerData.xlsx", "Sheet1");
		return data;
	}

}
