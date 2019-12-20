package commonLips.implementaions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLips.contracts.IMouseControl;

public class MouseControl implements IMouseControl {

	private WebDriver driver;

	public MouseControl(WebDriver driver) {
		this.driver = driver;
	}

	private Actions getMouseControl() {
		Actions action = new Actions(driver);
		return action;
	}

	public void dragAndDrop(WebElement source, WebElement target) throws Exception {

		getMouseControl().dragAndDrop(source, target).build().perform();
	}

	public void moveToElement(WebElement element) throws Exception {

		getMouseControl().moveToElement(element).build().perform();

	}

	public void rightClick(WebElement element) throws Exception {

		getMouseControl().contextClick().build().perform();

	}

	public void doubleClick(WebElement element) throws Exception {

		getMouseControl().doubleClick().build().perform();

	}

	public void moveToElementAndClick(WebElement element) throws Exception {

		getMouseControl().moveToElement(element).click().build().perform();

	}

}
