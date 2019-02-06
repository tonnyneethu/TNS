package com.searchpageobjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.searchutility.BrowserFactory;
import com.searchutility.ConfigDataprovider;
import com.searchutility.ExcelDataprovider;
import com.searchutility.Helper;

public class Searchbase {

	public WebDriver driver;
	public ExcelDataprovider searchexl;
	public ConfigDataprovider sconfig;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void searchsuite() {
		searchexl = new ExcelDataprovider();
		sconfig = new ConfigDataprovider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/DirectLine_TestReport.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, sconfig.getBrowser(), sconfig.getDataURL());
	}

	@AfterClass()
	public void teardown() {
		BrowserFactory.quitbrowser(driver);
	}

	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			//Helper.captureScreenshot(driver);

			 logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			 logger.pass("TestPassed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			//Helper.captureScreenshot(driver);
		}

		report.flush();

	}

}
