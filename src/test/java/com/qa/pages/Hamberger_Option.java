package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.setup.SetUp;
import com.qa.utility.ActionElement;

public class Hamberger_Option extends SetUp{
	

	@FindBy(xpath = "//button[contains(text(),'Open Menu')]")
	WebElement HambergerMenu_Menu;
	
	@FindBy(xpath = "//a[contains(text(),'About')]")
	WebElement about_click;
	
	
	WebDriver driver;

	public Hamberger_Option(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	ActionElement action = new ActionElement();
    
	public void Hambergermenu() {
		try {
			action.click_Object(HambergerMenu_Menu, "menu_click");
			action.click_Object(about_click, "about_option");
			action.waitUntilElementClickable(HambergerMenu_Menu);
		} catch (Exception e) {
			
		}
	}
	
	
}

