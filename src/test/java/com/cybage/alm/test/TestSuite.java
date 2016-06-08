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
public class TestSuite extends Base {

	@Test(dataProvider = "loginData", priority = 1, dataProviderClass = DataProviders.class)
	public void loginTest(LoginData loginData) {
		LoginPage loginPage = new LoginPage();
		loginPage.signin(loginData);
	}

	@Test(dataProvider = "registerData", priority = 2, dataProviderClass = DataProviders.class)
	public void registerTest(RegisterData registerData) {
		ResgisterPage resgisterPage = new ResgisterPage();
		resgisterPage.register(registerData);
	}
}
