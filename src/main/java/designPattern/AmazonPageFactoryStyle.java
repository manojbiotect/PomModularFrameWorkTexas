package designPattern;
// this is only good example of page factory..its only related demo....no need to see pom 1 and 2.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLips.implementaions.DropdownControl;
import commonLips.implementaions.ElementControl;
//not throwing excepiont Stale Element Reference Exception: if your element is change from webelement and search for element and proceed

public class AmazonPageFactoryStyle {
	
	@CacheLookup
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@CacheLookup
	@FindBy(xpath="//input[@value='Go']")
	private WebElement searchButton;
    
	@CacheLookup
	@FindBy(id="searchDropdownBox")
	private WebElement searchDropdown;
	
	@FindBy(xpath="//div[@class='sg-col-inner']")
	private WebElement result;

	ElementControl elementContol;
	DropdownControl dropdownControl;

	public AmazonPageFactoryStyle(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

		elementContol = new ElementControl();
		dropdownControl = new DropdownControl();
	}

	public void searchProduct(String product, String category) throws Exception {
		
		elementContol.setText(searchBox, product);
		dropdownControl.selectViaVisibleText(searchDropdown, category);
		
		elementContol.clickElement(searchButton);
		
		System.out.println(elementContol.getText(result));

	}

}
