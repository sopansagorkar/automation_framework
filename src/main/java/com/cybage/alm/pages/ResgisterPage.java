package com.cybage.alm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.cybage.alm.data.RegisterData;
import com.cybage.alm.utilities.Base;

public class ResgisterPage extends Base{

	public static void register(RegisterData registerData) {
		setup();
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys(registerData.getFirstName());
		driver.findElement(By.name("lastName")).sendKeys(registerData.getLastName());
		driver.findElement(By.name("phone")).sendKeys(registerData.getPhone());
		driver.findElement(By.id("userName")).sendKeys(registerData.getuName());
		driver.findElement(By.name("address1")).sendKeys(registerData.getAddress());
		driver.findElement(By.name("city")).sendKeys(registerData.getCity());
		driver.findElement(By.name("state")).sendKeys(registerData.getState());
		driver.findElement(By.name("postalCode")).sendKeys(registerData.getPincode());
		new Select(driver.findElement(By.name("country"))).selectByVisibleText(registerData.getCountry());
		driver.findElement(By.id("email")).sendKeys(registerData.getEmail());
		driver.findElement(By.name("password")).sendKeys(registerData.getPassWord());
		driver.findElement(By.name("confirmPassword")).sendKeys(registerData.getPassWord());
		driver.findElement(By.name("register")).click();
		driver.quit();
	}

}
