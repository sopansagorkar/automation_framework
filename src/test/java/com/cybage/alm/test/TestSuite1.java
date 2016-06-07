package com.cybage.alm.test;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.cybage.alm.data.LoginData;
import com.cybage.alm.data.RegisterData;
import com.cybage.alm.pages.LoginPage;
import com.cybage.alm.pages.ResgisterPage;
import com.cybage.alm.utilities.Base;
import com.cybage.alm.utilities.DataProviders;

@Guice
public class TestSuite1 extends Base{

	@Test(dataProvider = "loginData", priority = 2, dataProviderClass = DataProviders.class)
	public void loginTest(LoginData loginData) {
		LoginPage.signin(loginData);
	}

	@Test(dataProvider = "registerData", priority = 1, dataProviderClass = DataProviders.class)
	public void registerTest(RegisterData registerData) {
		ResgisterPage.register(registerData);
	}
}

