package com.mercuryTravel.test;

import java.util.Properties;

import org.graalvm.compiler.asm.aarch64.AArch64Assembler.ExtendType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mercuryTravel.pages.HomePage;

import commonLips.implementaions.CommonDriver;
import commonLips.implementaions.ScreenshotControl;
import commonLips.utils.ConfigReader;

public class BaseTests {

	CommonDriver cmnDriver;
	WebDriver driver;
	HomePage homePage;
	ScreenshotControl screenshot;

	String testExecutionStartTime;// makes unique screenshot name
	String currentWorkingDirectory;

	Properties configProperties;

	ExtentHtmlReporter htmlReporter; //create extent report 
	ExtentReports extentReport; // attach extent report
	ExtentTest extentTest; // create extent test

	@BeforeSuite
	public void preSetup() throws Exception {
		intitializeTestExecutionStartTime();

		initializeCurrentWorkingDirectory();

		initializeConfigProperty();

		initializeHtlmReport();
	}

	private void initializeHtlmReport() {
		
		String htmlReportFile = String.format("%s/reports/mercuryTravelReport_%s.html", currentWorkingDirectory,
				testExecutionStartTime);
		htmlReporter = new ExtentHtmlReporter(htmlReportFile);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
	}

	private void initializeConfigProperty() throws Exception {
		String filename = String.format("%s/config/config.properties", currentWorkingDirectory);
		configProperties = ConfigReader.readPropeties(filename);
	}

	@BeforeClass
	public void setup() throws Exception {
		extentTest = extentReport.createTest("setup : Invoking browser");


		invokeBrowser();

		initializePages();

	}

	@AfterClass
	public void cleanup() throws Exception {
		
		extentTest = extentReport.createTest("Clean up : Closing browser");
		cmnDriver.closeAllBrowsers();
	}

	// check result fail
	@AfterMethod

	public void afterMehtod(ITestResult result) throws Exception {

		String testMethodName = result.getName();

		String filename = String.format("%s/screenshots/%s_%s.jpeg", currentWorkingDirectory, testMethodName,
				testExecutionStartTime);

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, testMethodName); //it says report fail
			screenshot.saveAndCaptureScreenshot(filename);
			
			extentTest.addScreenCaptureFromPath(filename); //screen shot attached on report

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, testMethodName);
		} else {
			extentTest.log(Status.SKIP, testMethodName);
			
		}

	}
	
	@AfterSuite
	public void postCleanup() {
		extentReport.flush();
	}

	private void initializePages() {
		homePage = new HomePage(driver);
		screenshot = new ScreenshotControl(driver);
	}

	private void invokeBrowser() throws Exception {
		String browserType = configProperties.getProperty("browserType");
		cmnDriver = new CommonDriver(browserType);

		int pageloadTimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout"));
		cmnDriver.setPageLoadTimeout(pageloadTimeout);

		int elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		String baseUrl = configProperties.getProperty("baseUrl");
		cmnDriver.navigateToFirstUrl(baseUrl);

		driver = cmnDriver.getDriver();

	}

	private void initializeCurrentWorkingDirectory() {
		currentWorkingDirectory = System.getProperty("user.dir");

	}

	private void intitializeTestExecutionStartTime() {
		testExecutionStartTime = String.valueOf(System.currentTimeMillis());

	}

//	CommonDriver cmnDriver;
//	WebDriver driver;
//	HomePage homePage;
//	ScreenshotControl screenshot;
//
//	String testExecutionStartTime;
//	String currentWorkingDirectory;
//
//	Properties configProperties;
//
//	ExtentHtmlReporter htmlReporter;
//	ExtentReports extentReport;
//	ExtentTest extentTest;
//
//	@BeforeSuite
//	public void preSetup() throws Exception {
//
//		initializeTestExecutionStartTime();
//
//		initializeCurentWorkingDirectory();
//
//		initializeConfigProperty();
//
//		initializeHtlmReport();
//	}
//
//	private void initializeHtlmReport() {
//
//		String htmlReportFile = String.format("%s/reports/mercuryTravelReport_%s.html", currentWorkingDirectory,
//				testExecutionStartTime);
//		htmlReporter = new ExtentHtmlReporter(htmlReportFile);
//
//		extentReport = new ExtentReports();
//		extentReport.attachReporter(htmlReporter);
//
//	}
//
//	@BeforeClass(enabled=true)
//	public void setup() throws Exception {
//
//		extentTest = extentReport.createTest("Setup : Invoking browser");
//
//		invokeBrowser();
//
//		initializePages();
//
//	}
//	
//	//For Selenium Grid Only
//	@Parameters("browserType")
//	@BeforeClass(enabled=false)
//	public void setup(String browserType) throws Exception {
//
//	//	extentTest = extentReport.createTest("Setup : Invoking browser");
//
//		invokeBrowser(browserType);
//
//		initializePages();
//
//	}
//
//	@AfterClass
//	public void cleanup() throws Exception {
//
//		extentTest = extentReport.createTest("Clean up : Closing Browser");
//		cmnDriver.closeAllBrowsers();
//	}
//
//	@AfterMethod
//	public void afterAMethod(ITestResult result) throws Exception {
//
//		String testMethodName = result.getName();
//
//		String filename = String.format("%s/screenshots/%s_%s.jpeg", currentWorkingDirectory, testMethodName,
//				testExecutionStartTime);
//
//		if (result.getStatus() == ITestResult.FAILURE) {
//			extentTest.log(Status.FAIL, testMethodName);
//
//			screenshot.saveAndCaptureScreenshot(filename);
//
//			extentTest.addScreenCaptureFromPath(filename);
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			extentTest.log(Status.PASS, testMethodName);
//		} else {
//			extentTest.log(Status.SKIP, testMethodName);
//		}
//	}
//
//	@AfterSuite
//	public void postCleanup() {
//		extentReport.flush();
//	}
//
//	private void initializeConfigProperty() throws Exception {
//
//		String filename = String.format("%s/config/config.properties", currentWorkingDirectory);
//		configProperties = ConfigReader.readProperties(filename);
//
//	}
//
//	private void initializePages() {
//		homePage = new HomePage(driver);
//		screenshot = new ScreenshotControl(driver);
//
//	}
//
//	private void invokeBrowser() throws Exception {
//		String browserType = configProperties.getProperty("browserType");
//		cmnDriver = new CommonDriver(browserType);
//
//		int pageloadTimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout"));
//		cmnDriver.setPageLoadTimeout(pageloadTimeout);
//
//		int elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
//		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
//
//		String baseUrl = configProperties.getProperty("baseUrl");
//		cmnDriver.navigateToFirstUrl(baseUrl);
//
//		driver = cmnDriver.getDriver();
//
//	}
//	
//	//For Selenium Grid only
//	private void invokeBrowser(String browserType) throws Exception {
//		cmnDriver = new CommonDriver(browserType);
//
//		int pageloadTimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout"));
//		cmnDriver.setPageLoadTimeout(pageloadTimeout);
//
//		int elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
//		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
//
//		String baseUrl = configProperties.getProperty("baseUrl");
//		cmnDriver.navigateToFirstUrl(baseUrl);
//
//		driver = cmnDriver.getDriver();
//
//	}
//
//	private void initializeCurentWorkingDirectory() {
//		currentWorkingDirectory = System.getProperty("user.dir");
//
//	}
//
//	private void initializeTestExecutionStartTime() {
//		testExecutionStartTime = String.valueOf(System.currentTimeMillis());
//
//	}
//

}
