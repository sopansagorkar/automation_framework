package com.cybage.alm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cybage.alm.data.Driver;
import com.cybage.alm.data.LoginData;

public class LoginPage {

	public void signin(Object i, Object loginData) {
		WebDriver driver = new Driver().getDriver();
		LoginData data = (LoginData) loginData;

		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys(data.getUserName());
		driver.findElement(By.name("password")).sendKeys(data.getPassowrd());
		driver.findElement(By.name("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")));
		driver.quit();
	}
}
