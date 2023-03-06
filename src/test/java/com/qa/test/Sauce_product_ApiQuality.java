package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.GT_LoginPageObject;
import com.qa.pages.Home_Page_obj;
import com.qa.pages.Products_PageObjects;
import com.qa.setup.SetUp;

public class Sauce_product_ApiQuality extends SetUp {


	@Test
	public void removefromcart() {

		GT_LoginPageObject lp = new GT_LoginPageObject(driver);
		Home_Page_obj hp = new Home_Page_obj(driver);
		Products_PageObjects pr = new Products_PageObjects(driver);
		
		
		lp.login_GT();
		
		hp.hambergerclick();
		hp.aboutclick();
		pr.gotoSauceAPIquality();
		pr.requestDemo();
		pr.contactDetailsForm();
	}
	
}
