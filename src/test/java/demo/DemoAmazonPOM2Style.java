package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLips.implementaions.CommonDriver;
import commonLips.implementaions.DropdownControl;
import commonLips.implementaions.ElementControl;
import designPattern.AmazonPOM2Style;

public class DemoAmazonPOM2Style {
	// 
  CommonDriver cmnDriver;
  String url = "https://www.amazon.com/";
  

  WebDriver driver;
  
  AmazonPOM2Style homePage;

	
	@BeforeClass
	public void invokeBrowser() throws Exception {
		cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.navigateToFirstUrl(url);
		
;
		driver = cmnDriver.getDriver();
		
		homePage = new AmazonPOM2Style(driver);
	}
	
	@AfterClass
	public void closeBrowser() throws Exception {
		
		cmnDriver.closeAllBrowsers();
		
	}
	
	@Test
	//getting the encapsulation , abstraction, 
	// calling the method, hidding implemetnation part to outside world
	public void searchProduct() throws Exception {
		homePage.searchProduct("Apple Watch", "Electronics");
	
	}
	


}
