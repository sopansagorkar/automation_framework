package com.cybage.alm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.cybage.alm.data.Driver;
import com.cybage.alm.data.RegisterData;

public class ResgisterPage {

	public void register(Object i, Object registerData) {
		RegisterData data = (RegisterData) registerData;
		WebDriver driver = new Driver().getDriver();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys(data.getFirstName());
		driver.findElement(By.name("lastName")).sendKeys(data.getLastName());
		driver.findElement(By.name("phone")).sendKeys(data.getPhone());
		driver.findElement(By.id("userName")).sendKeys(data.getuName());
		driver.findElement(By.name("address1")).sendKeys(data.getAddress());
		driver.findElement(By.name("city")).sendKeys(data.getCity());
		driver.findElement(By.name("state")).sendKeys(data.getState());
		driver.findElement(By.name("postalCode")).sendKeys(data.getPincode());
		new Select(driver.findElement(By.name("country"))).selectByVisibleText("INDIA");
		driver.findElement(By.id("email")).sendKeys(data.getEmail());
		driver.findElement(By.name("password")).sendKeys(data.getPassWord());
		driver.findElement(By.name("confirmPassword")).sendKeys(data.getPassWord());
		driver.findElement(By.name("register")).click();
	}

}
