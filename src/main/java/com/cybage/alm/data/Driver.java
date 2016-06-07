package com.cybage.alm.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	WebDriver driver;

	public WebDriver getDriver() {
		driver = new FirefoxDriver();
		return driver;
	}

	public void close() {
		driver.close();
	}

}
