package com.qa.pages;

import org.openqa.selenium.WebDriver;

import com.qa.setup.SetUp;
import com.qa.utility.ActionElement;

public class Orange_HRM_LoginPageObject extends SetUp {
	
	public String input_usrname="//input[@name='username']";
	public String input_pasward="//input[@name='password']";
	public String button_login="//button[@type='submit']";
	
	WebDriver driver;
	
	public Orange_HRM_LoginPageObject(WebDriver driver2) {
		this.driver=driver2;
	}
	
	ActionElement action=new ActionElement();
	
	public void Orange_HRM_Login() {
		
		
	}

}
