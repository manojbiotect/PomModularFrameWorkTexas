package commonLips.implementaions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLips.contracts.IDropdown;

public class DropdownControl implements IDropdown {

	private Select getDropdown(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {

		getDropdown(element).selectByVisibleText(visibleText);
	}

	public void selectViaValue(WebElement element, String value) throws Exception {
		getDropdown(element).selectByValue(value);

	}

	public void selectViaIndex(WebElement element, int index) throws Exception {
		getDropdown(element).selectByIndex(index);
	}

	public boolean isMultiple(WebElement element) throws Exception {

		return getDropdown(element).isMultiple();
	}

	public List<WebElement> getAllOptions(WebElement element) throws Exception {

		return getDropdown(element).getAllSelectedOptions();
	}

	public List<WebElement> getAllSelectedOptions(WebElement element) throws Exception {

		return getDropdown(element).getAllSelectedOptions();
	}

	public WebElement getFirstSectedOption(WebElement element) throws Exception {

		return getDropdown(element).getFirstSelectedOption();
	}

}
