package com.lims.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class is going to provide the elements for the payments page and
 * operations.
 * 
 * @author Lenovo
 *
 */
public class PaymentsPage {

	@FindBy(xpath = "//a[.='Add Payment']")
	private WebElement addPayment;
	@FindBy(xpath = "//div[@class='col-md-12']/form/input[@name='recipt_no']")
	private WebElement receiptNo;
	@FindBy(xpath = "//div[@class='col-md-12']/form/input[@name='client_id']")
	private WebElement clientId;
	@FindBy(name = "amount")
	private WebElement amountFill;
	@FindBy(xpath = "//div[@class='col-md-12']/form/input[@name='month']")
	private WebElement monthFill;
	@FindBy(name = "due")
	private WebElement dueFill;
	@FindBy(name = "fine")
	private WebElement fineFill;
	@FindBy(name = "agent_id")
	private WebElement agentIDFill;
	@FindBy(css = "input[type='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//div[@class='col-md-12' and contains(.,'New Payment ADDED')]")
	private WebElement paymentsMsg;
	@FindBy(xpath = "//table[@class='table']/tbody/tr[*]/td[1]")
	private List<WebElement> paymentReceiptno;

	public PaymentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is going to click on add payments
	 */
	public void clickOnAddPayments() {
		addPayment.click();
	}

	/**
	 * This method is going to get the receipt no.
	 * 
	 * @return
	 */
	public String getReceiptNo() {
		String receipt = receiptNo.getAttribute("value");
		return receipt;
	}

	/**
	 * This method is going to fill the client id.
	 * 
	 * @param clientid
	 */
	public void fillClientId(String clientid) {
		clientId.sendKeys(clientid);
	}

	/**
	 * This method is going to fill the amount.
	 * 
	 * @param amount
	 */
	public void fillAmount(String amount) {
		amountFill.sendKeys(amount);
	}

	/**
	 * This method is going to fill the month.
	 * 
	 * @param month
	 */
	public void fillMonth(String month) {
		monthFill.sendKeys(month);
	}

	/**
	 * This method is going to full the due.
	 * 
	 * @param due
	 */
	public void fillDue(String due) {
		dueFill.sendKeys(due);
	}

	/**
	 * This method is going to fill the fine.
	 * 
	 * @param fineamount
	 */
	public void fillFine(String fineamount) {
		fineFill.sendKeys(fineamount);
	}

	/**
	 * This method is going to fill the agent ID
	 * 
	 * @param agentID
	 */
	public void fillAgent(String agentID) {
		agentIDFill.sendKeys(agentID);
	}

	/**
	 * This method is going to click on submit button.
	 */
	public void clickOnSubmit() {
		submitButton.click();
	}

	/**
	 * This method is going to get the payments message
	 * 
	 * @return
	 */
	public boolean getPaymentsMessage() {
		paymentsMsg.isDisplayed();
		return paymentsMsg != null;

	}

	/** 
	 * This method is going to verify the payment receipt no.
	 * 
	 * @param payreceipt
	 * @return
	 */
	public String verifyPaymentReceiptNo(String payreceipt) {
		for (WebElement i : paymentReceiptno) {
			String data3 = i.getText();
			if (data3.equals(payreceipt)) {
				System.out.println("The payment receipt no. is present " + payreceipt);
			}
		}
		return payreceipt;
	}

}
