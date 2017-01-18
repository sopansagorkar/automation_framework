package com.cybage.alm.test;

import java.io.IOException;

import org.testng.ITest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.cybage.alm.data.LoginData;
import com.cybage.alm.data.RegisterData;
import com.cybage.alm.pages.LoginPage;
import com.cybage.alm.pages.ResgisterPage;
import com.cybage.alm.utilities.Base;
import com.cybage.alm.utilities.DataProviders;

@Guice
public class TestSuite2 extends Base implements ITest {

	@Test(dataProvider = "loginData", priority = 1, dataProviderClass = DataProviders.class)
	public void loginTest(LoginData loginData) throws Exception {
		LoginPage loginPage = new LoginPage();
		System.out.println("Test case with "+loginData.getUserName()+" and "+loginData.getPassword());
		loginPage.signin(loginData);
	}

	@Test(dataProvider = "registerData", priority = 2, dataProviderClass = DataProviders.class,enabled=false)
	public void registerTest(RegisterData registerData) throws Exception {
		ResgisterPage resgisterPage = new ResgisterPage();
		resgisterPage.register(registerData);
	}

	@AfterSuite
	public void teadDown() throws IOException {
		//SeleniumUtils.Zipped();
	}

	public String getTestName() {
		
		return null;
	}
}
