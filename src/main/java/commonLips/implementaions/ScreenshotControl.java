package commonLips.implementaions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLips.contracts.IScreenshots;

public class ScreenshotControl implements IScreenshots {

	private WebDriver driver;

	public ScreenshotControl(WebDriver driver) {
		this.driver = driver;
	}

	public void saveAndCaptureScreenshot(String filename) throws Exception {

		filename = filename.trim();
//temp file first and move to physical file 
		File imgFile, tmpFile;

		imgFile = new File(filename);
//check file present or not .if not then take screenshot
		if (imgFile.exists()) {
			throw new Exception("File already exists..");
		}

		TakesScreenshot camera;

		camera = (TakesScreenshot) driver;

		tmpFile = camera.getScreenshotAs(OutputType.FILE);

		FileUtils.moveFile(tmpFile, imgFile);
	}

}
