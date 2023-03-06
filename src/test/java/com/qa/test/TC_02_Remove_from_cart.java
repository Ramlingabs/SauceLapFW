package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.GT_LoginPageObject;
import com.qa.pages.Home_Page_obj;
import com.qa.setup.SetUp;

public class TC_02_Remove_from_cart extends SetUp {

	@Test
	public void removefromcart() {

		GT_LoginPageObject lp = new GT_LoginPageObject(driver);
		Home_Page_obj hp = new Home_Page_obj(driver);
				
		lp.login_GT();
		hp.setFilter();
		hp.addToItem();
		hp.removeToitem();
	}
	
}