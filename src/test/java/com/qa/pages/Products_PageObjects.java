package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.setup.SetUp;
import com.qa.utility.ActionElement;
import com.qa.utility.Excel;
import com.qa.utility.ExtentReporter;

public class Products_PageObjects extends SetUp {

	@FindBy(xpath = "//div[@class='MuiBox-root css-0']/span[text()='Products']")
	WebElement tab_Products;

	@FindBy(xpath = "(//span[text()='Sauce API Quality'])[1]")
	WebElement button_SauceAPIquality;

	@FindBy(xpath = "(//a/button[@type='button'])[2]")
	WebElement button_demoRequest;

	@FindBy(xpath = "(//input[@id='FirstName'])[1]")
	WebElement First_name;

	@FindBy(xpath = "(//input[@id='LastName'])[1]")
	WebElement last_name;

	@FindBy(xpath = "(//input[@id='Email'])[1]")
	WebElement business_email;

	@FindBy(xpath = "(//input[@id='Company'])[1]")
	WebElement company_detail;

	@FindBy(xpath = "(//input[@name='Product_Interest__c'])[1]")
	WebElement interest_testautomation;

	@FindBy(xpath = "(//textarea[@id='How_did_you_hear_about_Sauce_Labs__c'])[1]")
	WebElement comment_howDidYouHear;

	@FindBy(xpath = "//input[@name='sauceLabsContactConsent']")
	WebElement privacy_policy_click;

	@FindBy(xpath = "(//select[@id='Country'])[1]")
	WebElement country_name;

	@FindBy(xpath = "(//input[@id='Phone'])[1]")
	WebElement phone_number;

	WebDriver driver;

	public Products_PageObjects(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	ActionElement action = new ActionElement();

	public void gotoSauceAPIquality() {
		try {

			action.mouseoverweb(tab_Products);
			action.click_Object(button_SauceAPIquality, "button_SauceAPIquality");

			ExtentReporter.logPassWithScreenShot("select_ProductFilter");
		} catch (Exception e) {

		}
	}

	public void requestDemo() {
		try {

			action.click_Object(button_demoRequest, "button_demorequest");

			ExtentReporter.logPassWithScreenShot("button_demoRequest");
		} catch (Exception e) {

		}
	}

	public void contactDetailsForm() {

		String sFirst_name = Excel.getData(TC_ID, "Firstname");
		action.set_Value(First_name, sFirst_name, "First name in form");
		String slast_name = Excel.getData(TC_ID, "Lastname");
		action.set_Value(last_name, sFirst_name, "last name in form");
		String sbusiness_email = Excel.getData(TC_ID, "BusinessEmail");
		action.set_Value(business_email, sbusiness_email, "sbusiness_email in the form");
		String scompany_detail = Excel.getData(TC_ID, "CompanyDetail");
		action.set_Value(company_detail, scompany_detail, "company_detail inthe form");
		String scountry_detail = Excel.getData(TC_ID, "countryDetil");
		action.selectByValue(country_name, scountry_detail);
		
		String sphone_number = Excel.getData(TC_ID, "PhoneNumber");
		action.set_Value(phone_number, sphone_number, "phone number on the form");
		action.click_Object(interest_testautomation, "interest automation clicking");
		String scomment_detail = Excel.getData(TC_ID, "CommentDetail");
		action.set_Value(comment_howDidYouHear, scompany_detail, "comment_detail in the form");
		action.click_Object(privacy_policy_click, "privacy policy clicked");
	}

}
