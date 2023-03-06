package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.GT_LoginPageObject;
import com.qa.pages.Home_Page_obj;
import com.qa.setup.SetUp;

public class TC_01_CheckAll_Items_Displayed extends SetUp {
	
	
	@Test
	public void CheckAll_Items_Displayed() {

		GT_LoginPageObject sauce_login = new GT_LoginPageObject(driver);
		Home_Page_obj hp = new Home_Page_obj(driver);
		sauce_login.login_GT();
		hp.CheckAllItems();
		
		
	}
	

}
