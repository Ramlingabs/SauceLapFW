package com.qa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import com.qa.setup.SetUp;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporter extends SetUp {

	public static void initializeReporting() {
		try {
			report = new ExtentReports(repPath + "Extent_" + Utility.getTimeStamp() + ".html");
			report.loadConfig(new File(extentConfig));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void logPass(String msg) {
		try {
			test.log(LogStatus.PASS, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void logPassWithScreenShot(String msg) {
		try {
			test.log(LogStatus.PASS, test.addScreenCapture(captureScreen()) + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void logFail(String msg) {
		try {
			test.log(LogStatus.FAIL, test.addScreenCapture(captureScreen()) + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String captureScreen() {
		String path;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
			File target = new File(path);
			FileUtils.copyFile(source, target);
			path = target.getAbsolutePath();
			return path;
			
		} catch (IOException e) {
			path = "Failed to capture screenshot: " + e.getMessage();
		}
		return path;
	}

}
