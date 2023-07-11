package com.lims.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is used to provide the elements for the logout page
 * @author Lenovo
 *
 */
public class LogOutPage {
	@FindBy(xpath = "//div[@class='header-right']/a/i")private WebElement logout;
	
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to click on the logout button.
	 */
	public void logoutApplication() {
		logout.click();
	}

}
