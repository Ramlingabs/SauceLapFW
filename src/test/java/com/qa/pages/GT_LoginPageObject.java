package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.setup.SetUp;
import com.qa.utility.ActionElement;
import com.qa.utility.Excel;

public class GT_LoginPageObject extends SetUp {

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement input_Email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement input_Password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement button_Login;

	WebDriver driver;

	public GT_LoginPageObject(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	ActionElement action = new ActionElement();

	public void login_GT() {
		System.out.println(driver);

		String un = Excel.getData(TC_ID, "Username");
		String pw = Excel.getData(TC_ID, "Password");
		// action.click_Object(Link_Login, "Login link");
		action.set_Value(input_Email, un, "User name");
		action.set_Value(input_Password, pw, "Password");
		action.click_Object(button_Login, "Login button");
		
		try {
			new ActionElement().acceptAlert(driver);
		}catch (Exception e) {
			
		}
		/*
		 * action.set_Value(driver.findElement(By.xpath(input_Email)), un, "User name");
		 * action.set_Value(driver.findElement(By.xpath(input_pwd)), pw, "Password");
		 * 
		 * action.click_Object(driver.findElement(By.xpath(button_Login)), "Login");
		 * 
		 * action.waitUntilElementClickable(driver.findElement(By.xpath(tab_dashboard)))
		 * ; if (driver.findElement(By.xpath(tab_dashboard)).isDisplayed())
		 * ExtentReporter.logPassWithScreenShot("Login to application is successful");
		 * else ExtentReporter.logFail("Login was not successful");
		 */
	}

}
