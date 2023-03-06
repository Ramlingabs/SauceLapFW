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

public class Home_Page_obj extends SetUp {

	@FindBy(xpath = "//button[contains(text(),'Add to cart')][1]")
	WebElement element_click;

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement HambergerMenu_Menu;

	@FindBy(xpath = "//div[@class='bm-menu']")
	WebElement Panel_Menu;

	@FindBy(xpath = "//button[text()='Close Menu']")
	WebElement button_CloseMenu;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement select_ProductFilter;

	@FindBy(xpath = "//button[contains(text(),'Add to cart')]")
	WebElement element_click1;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement element_remove;

	
	
	WebDriver driver;

	public Home_Page_obj(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	ActionElement action = new ActionElement();

//	public void ele_click() {

	// action.click_Object(element_click, "ele click");

//	}

	public void CheckAllItems() {
		try {
			action.click_Object(HambergerMenu_Menu, "HambergerMenu_Menu");
			action.waitUntilElementClickable(button_CloseMenu);
			action.isElementDisplayed(Panel_Menu, "Panel_Menu");
			ExtentReporter.logPassWithScreenShot("Hamberger menu panel");
			action.click_Object(button_CloseMenu, "button_CloseMenu");
			action.waitUntilElementClickable(HambergerMenu_Menu);
			ExtentReporter.logPassWithScreenShot("Hamberger menu closed");
			action.click_Object(element_click1, "onec-e clicked");
		} catch (Exception e) {

		}
	}

	public void addToItem() {
		try {
			action.click_Object(element_click1, "onec-e clicked");
			action.waitUntilElementClickable(element_click1);
		} catch (Exception e) {
			
		}
	}
	public void removeToitem() {
		try {
		action.click_Object(element_remove, "removed");
		ExtentReporter.logPassWithScreenShot("element_remove");
	}catch(Exception e) {
		
	}
	}
	public void setFilter() {
		try {

			String FilterVal = Excel.getData(TC_ID, "FilterValue");
			action.selectByValue(select_ProductFilter, FilterVal);
			ExtentReporter.logPassWithScreenShot("select_ProductFilter");
		} catch (Exception e) {

		}
	}

}
