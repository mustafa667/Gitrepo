package com.pom.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.LongSerializationPolicy;
import com.pom.base.Testbase;

public class Listeners extends Testbase implements ITestListener  {
	ExtentReports extent=ExtentReportdemo.Getreports();
	ExtentTest test;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, "Test is failed");
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	 test=extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test is passed");
		
	}

}
