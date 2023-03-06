package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.GT_LoginPageObject;
import com.qa.setup.SetUp;

public class Nop_com_login_001 extends SetUp {

	@Test
	public void login() {

		GT_LoginPageObject gtLogin = new GT_LoginPageObject(driver);
		gtLogin.login_GT();

	}

}
