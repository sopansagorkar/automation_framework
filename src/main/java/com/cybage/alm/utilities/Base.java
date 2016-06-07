package com.cybage.alm.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;

	public static void setup() {
		// initialize driver
		driver=new FirefoxDriver();
		// launch browser

		// OpenExcel -- call this method in Excel class

	}

	public static void quit() {

		// quit driver
		// Close excel
	}

}
