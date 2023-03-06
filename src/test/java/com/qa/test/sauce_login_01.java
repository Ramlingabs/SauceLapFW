package com.qa.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.pages.GT_LoginPageObject;
import com.qa.setup.SetUp;
import com.qa.utility.ActionElement;

public class sauce_login_01 extends SetUp {
	@Test
	public void loginTOSauce() {

		GT_LoginPageObject sauce_login = new GT_LoginPageObject(driver);
		sauce_login.login_GT();
		
	}
	
}
