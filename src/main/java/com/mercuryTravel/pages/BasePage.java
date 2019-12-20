package com.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;

import commonLips.implementaions.ElementControl;
import commonLips.implementaions.MouseControl;

public class BasePage {

	MouseControl mouseControl;
	ElementControl elementControl;

	public BasePage(WebDriver driver) {

		mouseControl = new MouseControl(driver);

		elementControl = new ElementControl();

	}

}
