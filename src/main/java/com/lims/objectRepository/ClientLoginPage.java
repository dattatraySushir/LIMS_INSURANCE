package com.lims.objectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class provides the elements for the Client login page 
 * @author Dattatray
 *
 */
public class ClientLoginPage {
	@FindBy(name = "username")
	private WebElement usernameEditTxt;
	@FindBy(name = "password")
	private WebElement passwordEditTxt;
	@FindBy(xpath = "//button[text()='login']")
	private WebElement loginButton;

	public ClientLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to provide the login functionality with the help of javaScriptExecutor.
	 * @param driver
	 * @param userName
	 * @param passWord
	 */
	public void javaScriptLogin(WebDriver driver, String userName, String passWord) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=arguments[1]", usernameEditTxt, userName, passwordEditTxt, passWord);
	}
/**
 * This method is used to login to the application
 * @param username
 * @param password
 */
	public void loginToApplicatio(String username, String password) {
		usernameEditTxt.sendKeys(username);
		passwordEditTxt.sendKeys(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginButton.click();
	}

}
