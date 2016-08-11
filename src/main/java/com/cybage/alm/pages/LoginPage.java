package com.cybage.alm.pages;

import org.openqa.selenium.By;
import com.cybage.alm.data.LoginData;
import com.cybage.alm.utilities.Base;
import com.cybage.alm.utilities.Links;

public class LoginPage extends Base {

	public void signin(LoginData data) throws Exception {
		setup();
		driver.get(Links.appURL);
		driver.findElement(objmap.getLocator("login_page_userName")).sendKeys(data.getUserName());
		driver.findElement(objmap.getLocator("login_page_password")).sendKeys(data.getPassword());
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//input[@value='Log in']"));
		/*Assert.assertEquals("SIGN-OFF",
				driver.findElement(
						By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"))
				.getText());*/
		quit();
	}
}
