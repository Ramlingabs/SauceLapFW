package com.qa.setup;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.qa.utility.ExtentReporter;
import com.qa.utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class SetUp {

	public static String repPath = "./Reports/";
	public String screenshotPath = "./Screenshots";
	public static String extentConfig = "C:\\WorkSpace\\Others\\ETC\\src\\test\\java\\resources\\extent-config.xml";
	public String chromeDriverPath = Utility.getConfigValue("chromeDriverPath");
	public static String TC_ID;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeSuite
	public void init() {
		ExtentReporter.initializeReporting();
	}

	@BeforeClass
	public void setup() throws Exception {
		try {
			TC_ID = this.getClass().getSimpleName();
			test = report.startTest(TC_ID);
			System.out.println("Running test : " + TC_ID);
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.get(Utility.getConfigValue("URL"));
			driver.manage().window().maximize();
			
			try 
			{
			    Alert alert = driver.switchTo().alert();
			    alert.accept();
			} catch (NoAlertPresentException e) 
			{
			    // No alert is present
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		report.endTest(test);
		driver.quit();
	}

	@AfterSuite
	public void flush() {
		report.flush();
		// report.close();
	}

}
