package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.GT_LoginPageObject;
import com.qa.setup.SetUp;
import com.qa.utility.Excel;
import com.qa.utility.ExtentReporter;

public class PTC_002 extends SetUp {

	


	@Test
	public void method1() {
		GT_LoginPageObject gtLogin = new GT_LoginPageObject(driver);

		
		gtLogin.login_GT();
		System.out.println();
		
	}
}
