package com.cybage.alm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cybage.alm.data.LoginData;
import com.cybage.alm.utilities.Base;

public class LoginPage extends Base{

	public void signin(LoginData data) {
		setup();
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys(data.getUserName());
		driver.findElement(By.name("password")).sendKeys(data.getPassword());
		driver.findElement(By.name("login")).click();
		WebElement element=driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"));
		String strng = element.getText();
		Assert.assertEquals("SIGN-OFF", strng);
		driver.quit();
	}
}
