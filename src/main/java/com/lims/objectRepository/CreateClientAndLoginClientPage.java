package com.lims.objectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * This class provides the elements of the creation of clients and client page elements also
 * @author Dattatray
 *
 */
public class CreateClientAndLoginClientPage {
	@FindBy(xpath = "//div[@class='col-md-12']/h1/button/a")
	private WebElement addclient;
	@FindBy(xpath = "//input[@name='client_id' and @type='text']")
	private WebElement fetchclientId;
	@FindBy(name = "client_password")
	private WebElement clientPassword;
	@FindBy(name = "name")
	private WebElement clientname;
	@FindBy(xpath = "//div[@class='col-md-12']/form/input[@name='nominee_id']")
	private WebElement fetchnomineeId;
	@FindBy(css = "input[type='file']")
	private WebElement choosefile;
	@FindBy(name = "sex")
	private WebElement clientGender;
	@FindBy(name = "birth_date")
	private WebElement clientbirthdate;
	@FindBy(name = "maritial_status")
	private WebElement clientmaritalstatus;
	@FindBy(name = "nid")
	private WebElement clientnid;
	@FindBy(name = "phone")
	private WebElement clientphone;
	@FindBy(name = "address")
	private WebElement clientaddress;
	@FindBy(name = "policy_id")
	private WebElement clientpolicy;
	@FindBy(name = "agent_id")
	private WebElement agentid;
	@FindBy(name = "nominee_name")
	private WebElement nomineename;
	@FindBy(name = "nominee_sex")
	private WebElement nomineeGender;
	@FindBy(name = "nominee_birth_date")
	private WebElement nomineebirthdate;
	@FindBy(name = "nominee_nid")
	private WebElement nomineenid;
	@FindBy(name = "nominee_relationship")
	private WebElement relationship;
	@FindBy(name = "priority")
	private WebElement priority;
	@FindBy(name = "nominee_phone")
	private WebElement nomineephone;
	@FindBy(css = "input[type='submit']")private WebElement submit;
	@FindBy(tagName = "div")
	private WebElement fetchmesssageAttribute;
	@FindBy(xpath = "//table[@class='table']/tbody/tr/following-sibling::tr/td[1]")
	private List<WebElement> clientdata;
	@FindBy(xpath = "//table[@class='table']/tbody/tr[*]/td[1]")
	private List<WebElement> nomineedata;

	public CreateClientAndLoginClientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * This method is used to click on add client.
 */
	public void clickOnAddClient() {
		addclient.click();
	}
	/**
	 * This method is used to get clientID.
	 */
	public String getClientID() {
		return fetchclientId.getAttribute("value");
	}
	/**
	 * This method is used to fill client password.
	 */
	public void fillClientPassword(String password) {
		clientPassword.sendKeys(password);
	}
	/**
	 * This method is used to fill client name.
	 */
	public void fillClientName(String name) {
		clientname.sendKeys(name);
	}
	/**
	 * This method is used to get nominee Id.
	 */
	public String getNomineeID() {
		return fetchnomineeId.getAttribute("value");
	}
	/**
	 * This method is used to Choose the file Path.
	 */
	public void chooseFile(String path) {
		choosefile.sendKeys(path);
	}
	/**
	 * This method is used to fill client Gender.
	 */
	public void fillGender(String gender) {
		clientGender.sendKeys(gender);
	}
	/**
	 * This method is used to fill client birthdate.
	 */
	public void fillBirthDate(String birthdate) {
		clientbirthdate.sendKeys(birthdate);
	}
	/**
	 * This method is used to fill client marital status.
	 */
	public void fillMaritalStatus(String status) {
		clientmaritalstatus.sendKeys(status);
	}
	/**
	 * This method is used to fill client NationalID.
	 */
	public void fillNid(String nid) {
		clientnid.sendKeys(nid);
	}
	/**
	 * This method is used to fill client Phone.
	 */
	public void fillPhoneNo(String phone) {
		clientphone.sendKeys(phone);
	}
	/**
	 * This method is used to fill client address.
	 */
	public void fillAddress(String address) {
		clientaddress.sendKeys(address);
	}
	/**
	 * This method is used to fill policy.
	 */
	public void fillPolicy(String policy) {
		clientpolicy.sendKeys(policy);
	}
	/**
	 * This method is used to fill agent.
	 */
	public void fillAgentId(String agentId) {
		agentid.sendKeys(agentId);
	}
	/**
	 * This method is used to fill Nominee name.
	 */
	public void fillNomineeName(String Nname) {
		nomineename.sendKeys(Nname);
	}
	/**
	 * This method is used to fill Nominee gender.
	 */
	public void fillNomineeGender(String Ngender) {
		nomineeGender.sendKeys(Ngender);
	}
	/**
	 * This method is used to fill Nominee birthdate.
	 */
	public void fillNomineeBirthdate(String NBirthdate) {
		nomineebirthdate.sendKeys(NBirthdate);
	}
	/**
	 * This method is used to fill Nominee National ID.
	 */
	public void fillNomineeID(String Nnid) {
		nomineenid.sendKeys(Nnid);
	}
	/**
	 * This method is used to fill Nominee relationship.
	 */
	public void fillRelationship(String relatioShip) {
		relationship.sendKeys(relatioShip);
	}
	/**
	 * This method is used to fill Nominee priority.
	 */
	public void fillPriority(String prioRity) {
		priority.sendKeys(prioRity);
	}
	/**
	 * This method is used to fill Nominee phoneNo.
	 */
	public void fillNomineePhone(String Nphone) {
		nomineephone.sendKeys(Nphone);
	}
	public void cliclOnSubmitButton() {
		submit.click();
	}
	/**
	 * This method is used to Get the confirmation message .
	 */
	public String getConfirmMessage() {
		return fetchmesssageAttribute.getAttribute("textContent");
	}
	/**
	 * This method is used to verify the client Id is present in list or not
	 */
	boolean flag=false;
	public String verifyClientID(String clientID) {
		for (WebElement i : clientdata) {
			String data1 = i.getText();
			//Assert.assertTrue();
			if (data1.equals(clientID)) {
				System.out.println("The Client present in the list " + clientID);
				flag=true;
				break;
			}
		}
		if(!flag) {
			System.out.println("The client id is not present in the list "+clientID);
		}
		return clientID;
	}
	/**
	 * This method is used to veriy the nominee ID present in the list or not
	 */
	public String verrifyNomineeID(String nomineeID) {
		for (WebElement i :nomineedata ) {
			String data2 = i.getText();
			if (data2.equals(nomineeID)) {
				System.out.println("The nominee is present " + nomineeID);
				flag=true;
				break;
			}	
	}
		if(!flag) {
			System.out.println("The nominee id is not present in the list "+nomineeID);
		}
		return nomineeID;
		
	}
	
}
