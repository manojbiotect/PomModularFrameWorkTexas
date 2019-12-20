package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLips.implementaions.CommonDriver;
import commonLips.implementaions.DropdownControl;
import commonLips.implementaions.ElementControl;
import designPattern.AmazonPOM1Style;

public class DemoAmazonPOM1Style {
	// 
  CommonDriver cmnDriver;
  String url = "https://www.amazon.com/";
  
  ElementControl elementContol;
  DropdownControl dropdownControl;
  WebDriver driver;
  
  AmazonPOM1Style homePage;

	
	@BeforeClass
	public void invokeBrowser() throws Exception {
		cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.navigateToFirstUrl(url);
		
		elementContol = new ElementControl();
		dropdownControl = new DropdownControl();
		driver = cmnDriver.getDriver();
		
		homePage = new AmazonPOM1Style(driver);
	}
	
	@AfterClass
	public void closeBrowser() throws Exception {
		
		cmnDriver.closeAllBrowsers();
		
	}
	
	@Test
	public void searchProduct() throws Exception {
		
		elementContol.setText(homePage.searchBox, "Apple Watch");
		dropdownControl.selectViaVisibleText(homePage.searchDropdown, "Electronics");	
		elementContol.clickElement(homePage.searchButton);
	}
	


}
