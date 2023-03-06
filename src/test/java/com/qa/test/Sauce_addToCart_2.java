package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.GT_LoginPageObject;
import com.qa.pages.Home_Page_obj;
import com.qa.setup.SetUp;

public class Sauce_addToCart_2 extends SetUp {
	
	
	@Test
	public void loginTOSauce() {

		GT_LoginPageObject sauce_login = new GT_LoginPageObject(driver);
		sauce_login.login_GT();
		
		Home_Page_obj elem_click=new Home_Page_obj(driver);
		
	}
	

}
