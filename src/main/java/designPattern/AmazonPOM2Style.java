package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLips.implementaions.DropdownControl;
import commonLips.implementaions.ElementControl;

public class AmazonPOM2Style {
	// written webelement and searh item in single class
	// second desgin pattern , define all webelement is private , initalizing the constructor and using method
	// all posssible method in this page in this class, say login page , wt method login forget password siginup, all possible method wite in same clsas.whenever that outside you using
	private WebElement searchBox;

	private WebElement searchButton;

	private WebElement searchDropdown;

	ElementControl elementContol;
	DropdownControl dropdownControl;

	public AmazonPOM2Style(WebDriver driver) {

		searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));

		searchDropdown = driver.findElement(By.id("searchDropdownBox"));

		elementContol = new ElementControl();
		dropdownControl = new DropdownControl();
	}

	public void searchProduct(String product, String category) throws Exception {
		
		elementContol.setText(searchBox, product);
		dropdownControl.selectViaVisibleText(searchDropdown, category);
		
		elementContol.clickElement(searchButton);

	}

}
