package com.pom.utilities;

import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportdemo {
	
	static ExtentReports extent;
	public static ExtentReports Getreports()
	{
		String reports=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reports);
		reporter.config().setReportName("Web automation results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent= new  ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","mustafa");
		return extent;

	}

}
