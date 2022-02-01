package com.crm.autodesk.genericutiltiy;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener{
	
	ExtentReports report = new ExtentReports();
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
	//capture the method Name
	String methodName = result.getMethod().getMethodName();
	
	//capture the current date
	String CurrentDate = new JavaUtility().getSystemDateWithFormate();
	
	//concatenate for screenshot name
	String screenShotName = methodName+"_"+CurrentDate;
	String screenshotPath = null;
	try {
		screenshotPath = new WebDriverUtility().takeScreenshot(BaseClass.sdriver, screenShotName);
	} catch (Throwable e) {
		e.printStackTrace();
	}
	
	test.log(Status.FAIL, methodName+" is failed");
	test.log(Status.FAIL, result.getThrowable());
	test.addScreenCaptureFromPath(screenshotPath);
	
		
	}

	public void onTestSkipped(ITestResult result) {
	
		test.log(Status.SKIP, result.getMethod().getMethodName()+"is skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		//basic configuration
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/extentReport"+new JavaUtility().getSystemDateWithFormate());
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setDocumentTitle("AutoDesk Automation Report");
		htmlReport.config().setReportName("Extent Report");
		
		//attaching the report to project
		
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("URL", "http://localhost:8888");
		report.setSystemInfo("Browser", "Chrome");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	

}
