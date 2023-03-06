package com.qa.utility;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNG_Engine {

	@Test
	public void TestGun() {
		List<String> mySuiteClasses = Excel.listExecutableOfTestClasses();
		XmlSuite suite = new XmlSuite();
		suite.setName("tmpSuite");
		
		XmlTest test = new XmlTest(suite);
		test.setName("tmpTest");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		String tcid, classPath;
		for(int i = 0; i<=mySuiteClasses.size()-1;i++) {
			tcid = mySuiteClasses.get(i);
			classPath = Utility.getConfigValue("testClassPackageName")+"."+tcid;
			classes.add(new XmlClass(classPath));
		}
		
		test.setXmlClasses(classes);
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}
}
