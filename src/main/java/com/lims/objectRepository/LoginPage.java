package com.lims.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class is used to provide the elements for the login page 
 * @author Dattatray
 *
 */
public class LoginPage {

	@FindBy(name = "username")private WebElement usernameEditTxt;
	@FindBy (name = "password")private WebElement passwordEditTxt;
	@FindBy (xpath = "//button[.='login']")private WebElement loginButton;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method is used to login to the application
	 * @param username
	 * @param password
	 */
	public void loginToApplicatio(String username, String password) {
		usernameEditTxt.sendKeys(username);
		passwordEditTxt.sendKeys(password);
		loginButton.click();
	}
	
	
}