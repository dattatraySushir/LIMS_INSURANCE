package com.lims.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class provides the Module of the home page 
 * @author Dattatray
 *
 */
public class HomePage {
	
	@FindBy(xpath = "//ul[@id='main-menu']/li[6]/a/i")
	private WebElement paymentsModule;
	@FindBy(xpath = "//ul[@id='main-menu']/li[2]/a")
	private WebElement clientModule;
	@FindBy(xpath = "//ul[@id='main-menu']/li[5]/a")
	private WebElement nomineeModule;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to get the payments module
	 * @return {@link WebElement}
	 */
	public WebElement getPaymentsModule() {
		return paymentsModule;
	}
	/**
	 * This method is used to click on payments module
	 * @return {@link WebElement}
	 */
	public void clickOnPayments() {
		paymentsModule.click();
	}
	/**
	 * This method is used to click on Clients module
	 * @return {@link WebElement}
	 */
	public void clickOnClient() {
		clientModule.click();
	}
	/**
	 * This method is used to click on Nominee module
	 * @return {@link WebElement}
	 */
	public void clickOnNominee() {
		nomineeModule.click();
	}
}
