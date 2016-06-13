package com.cybage.alm.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.cybage.alm.data.LoginData;
import com.cybage.alm.utilities.Base;
import com.cybage.alm.utilities.Links;
import com.cybage.alm.utilities.SeleniumUtils;

public class LoginPage extends Base {

	public void signin(LoginData data) throws Exception {
		setup();
		driver.get(Links.appURL);
		driver.findElement(objmap.getLocator("login_page_userName")).sendKeys(data.getUserName());
		driver.findElement(objmap.getLocator("login_page_password")).sendKeys(data.getPassword());
		driver.findElement(By.name("login")).click();
		SeleniumUtils.takeScreenShots();
		Assert.assertEquals("SIGN-ON",
				driver.findElement(
						By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"))
				.getText());
		quit();
	}
}
