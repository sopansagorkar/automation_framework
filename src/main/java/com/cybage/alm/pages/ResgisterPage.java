package com.cybage.alm.pages;

import org.openqa.selenium.support.ui.Select;
import com.cybage.alm.data.RegisterData;
import com.cybage.alm.utilities.Base;
import com.cybage.alm.utilities.Links;

public class ResgisterPage extends Base {

	public void register(RegisterData registerData) throws Exception {
		setup();
		driver.get(Links.appURL);
		driver.findElement(objmap.getLocator("register_page_linktext")).click();
		driver.findElement(objmap.getLocator("register_page_firstName")).sendKeys(registerData.getFirstName());
		driver.findElement(objmap.getLocator("register_page_lastName")).sendKeys(registerData.getLastName());
		driver.findElement(objmap.getLocator("register_page_phone")).sendKeys(registerData.getPhone());
		driver.findElement(objmap.getLocator("register_page_id")).sendKeys(registerData.getuName());
		driver.findElement(objmap.getLocator("register_page_address")).sendKeys(registerData.getAddress());
		driver.findElement(objmap.getLocator("register_page_city")).sendKeys(registerData.getCity());
		driver.findElement(objmap.getLocator("register_page_state")).sendKeys(registerData.getState());
		driver.findElement(objmap.getLocator("register_page_postalCode")).sendKeys(registerData.getPincode());
		Select select = new Select(driver.findElement(objmap.getLocator("register_page_country")));
		select.selectByVisibleText(registerData.getCountry());
		driver.findElement(objmap.getLocator("register_page_email")).sendKeys(registerData.getEmail());
		driver.findElement(objmap.getLocator("register_page_password")).sendKeys(registerData.getPassWord());
		driver.findElement(objmap.getLocator("register_page_cPassword")).sendKeys(registerData.getPassWord());
		driver.findElement(objmap.getLocator("register_page_register")).click();
		quit();
	}

}
