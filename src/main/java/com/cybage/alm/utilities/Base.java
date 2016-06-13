package com.cybage.alm.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public static ObjectMap objmap;
	public static void setup() {
		driver = new FirefoxDriver();
		objmap=new ObjectMap(Links.propFilePath);
	}

	public static void quit() {
		driver.close();
	}

}
