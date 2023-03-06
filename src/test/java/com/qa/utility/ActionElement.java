package com.qa.utility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.setup.SetUp;

public class ActionElement extends SetUp {

	public void click_Object(WebElement obj, String eleName) {
		try {
			obj.click();
			ExtentReporter.logPass(eleName + " : Clicked successfully");
		} catch (Exception e) {
			ExtentReporter.logFail(eleName + " : NOT Clicked successfully");
		}
	}

	public void isElementDisplayed(WebElement obj, String eleName) {
		try {
			obj.isDisplayed();
			ExtentReporter.logPass(eleName + " : is displayed successfully");
		} catch (Exception e) {
			ExtentReporter.logFail(eleName + " : is NOT displayed successfully");
		}
	}

	public void set_Value(WebElement obj, String value, String eleName) {
		try {
			obj.clear();
			obj.sendKeys(value);
			ExtentReporter.logPass(eleName + " : " + value + " Entered successfully");
		} catch (Exception e) {
			ExtentReporter.logFail(eleName + " : " + value + " NOT Entered successfully");
		}
	}

	public void waitUntilElementClickable(WebElement obj) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void acceptAlert(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			// No alert is present
		}

	}

	public void dismissAlert(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			// No alert is present
		}
	}

	public void mouseOver(String xPath) {
		try {
			WebElement ele = driver.findElement(By.xpath(xPath));
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}}
		public void mouseoverweb (WebElement obj) {
			try {
				
				Actions action = new Actions(driver);
				action.moveToElement(obj).perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	public void selectByValue(WebElement obj, String val) {
		try {

			Select dropdown = new Select(obj);
			dropdown.selectByVisibleText(val);
			ExtentReporter.logPass(val + " Selected successfully");
		} catch (Exception e) {
			ExtentReporter.logPass(val + " not Selected successfully");
		}
	}

}
