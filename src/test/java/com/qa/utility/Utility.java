package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Utility {
	public static Properties props;
	public static String propertyFilePath = "./src/test/java/resources/Configuration.properties";
	static String str = "Key not found";

	public static String getConfigValue(String key) {

		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(propertyFilePath);
			prop = new Properties();
			prop.load(fis);
			str = prop.getProperty(key);
			fis.close();
			return str;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
		}

		return str;
	}

	public static String getTimeStamp() {
		Date date = new Date();
		String ts = date.toString();
		ts = ts.replaceAll(" ", "_");
		ts = ts.replaceAll(":", "_");
		return ts;

	}

}
