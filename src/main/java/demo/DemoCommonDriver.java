package demo;

import org.openqa.selenium.WebDriver;

import commonLips.implementaions.CommonDriver;
import commonLips.implementaions.DropdownControl;
import commonLips.implementaions.ElementControl;
import commonLips.implementaions.MouseControl;
import commonLips.implementaions.ScreenshotControl;
// single page everythings
public class DemoCommonDriver {
	public static void main(String[] args) {
		
		try {
			
			CommonDriver cmnDriver = new CommonDriver("chrome"); //initialize common driver
			cmnDriver.setPageLoadTimeout(30);
			cmnDriver.setElementDetectionTimeout(10);
		
			cmnDriver.navigateToFirstUrl("http://demo.guru99.com/v4"); //get a driver instance
			
			
			ElementControl elementcontolControl;
			DropdownControl dropdownControl;
			MouseControl mouseControl;
			ScreenshotControl screenShot;
			
			WebDriver driver;
			
			driver = cmnDriver.getDriver();
			
			elementcontolControl = new ElementControl();  //pass it wherever you want
			dropdownControl = new DropdownControl();
			mouseControl = new MouseControl(driver);
			
			
			screenShot = new ScreenshotControl(driver);
			
			screenShot.saveAndCaptureScreenshot("C:/Users/Manoj Adhikari/Documents/workspace-spring-tool-suite-4-4.4.2.RELEASE/modularFrameWorkSaurabTutorial/screenshots/test.jpeg");
			

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
