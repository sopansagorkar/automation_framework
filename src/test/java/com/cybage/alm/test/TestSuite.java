package com.cybage.alm.test;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.cybage.alm.pages.LoginPage;
import com.cybage.alm.pages.ResgisterPage;
import com.cybage.alm.utilities.DataProviders;

@Guice
public class TestSuite {

	@Test(dataProvider = "loginData", priority = 2, dataProviderClass = DataProviders.class)
	public void loginTest(Object i, Object loginData) {
		new LoginPage().signin(i, loginData);
	}

	@Test(dataProvider = "registerData", priority = 1, dataProviderClass = DataProviders.class)
	public void registerTest(Object i, Object registerData) {
		new ResgisterPage().register(i, registerData);
	}
}
