package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.GT_LoginPageObject;

import com.qa.setup.SetUp;

public class About_Detail extends SetUp{
	@Test
	public void AboutDetail() {
		
		GT_LoginPageObject lp = new GT_LoginPageObject(driver);
		lp.login_GT();


	}

}
