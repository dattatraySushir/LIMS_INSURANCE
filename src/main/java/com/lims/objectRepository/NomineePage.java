package com.lims.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class is used to provide the elements for the Nominee page and also
 * performs some operations.
 * 
 * @author Dattatray
 *
 */
public class NomineePage {
	@FindBy(xpath = "//a[text()='Add Nominee']")
	private WebElement addNominee;
	@FindBy(name = "client_id")
	private WebElement clientid;
	@FindBy(name = "nominee_id")private WebElement nomineeid;
	@FindBy(name = "name")
	private WebElement nameTxt;
	@FindBy(name = "sex")
	private WebElement gender;
	@FindBy(name = "birth_date")
	private WebElement birthdate;
	@FindBy(name = "nid")
	private WebElement nationalid;
	@FindBy(name = "relationship")
	private WebElement relationship;
	@FindBy(name = "priority")
	private WebElement priority;
	@FindBy(name = "phone")
	private WebElement phone;
	@FindBy(xpath = "//div[@class='col-md-12']/form/input[@type='submit']")private WebElement submit;
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[1]")private List<WebElement> nomineeID;

	public NomineePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * This method is used to click on Add Nominee
 */
	public void clickOnAddNominee() {
		addNominee.click();
	}
/**
 * This method is used to fill the client Id
 * @param clientID
 */
	public void fillClientId(String clientID) {
		clientid.sendKeys(clientID);
	}
	/**
	 * This method is used to fill the name.
	 * @param name
	 */

	public void fillName(String name) {
		nameTxt.sendKeys(name);
	}
	/**
	 * This method is used to fill the gender.
	 * @param gender
	 */

	public void fillGender(String genDer) {
		gender.sendKeys(genDer);
	}
/**
 * This method is used to fill the birthdate
 * @param birthDate
 */
	public void fillBirthdate(String birthDate) {
		birthdate.sendKeys(birthDate);
	}
	/**
	 * This method is used to fill the NationalId
	 * @param nid
	 */

	public void fillNationalId(String nid) {
		nationalid.sendKeys(nid);
	}
	/**
	 * This method is used to fill the relationship.
	 * @param relationShip
	 */

	public void fillRelationship(String relationShip) {
		relationship.sendKeys(relationShip);

	}
/**
 * This method is used to fill the priority
 * @param prioRity
 */
	public void fillPriority(String prioRity) {
		priority.sendKeys(prioRity);
	}
/**
 * This method is used to fill the phone no.
 * @param Phone
 */
	public void fillPhone(String Phone) {
		phone.sendKeys(Phone);
	}
	public String getNomineeid() {
		return nomineeid.getAttribute("value");
	}
	boolean flag= false;
	public String verifyNomineeName(String nid) {
		for (WebElement i :nomineeID) {
			String data = i.getText();
			if (data.contains(nid)) {			
				System.out.println("The provided nominee id is present " + nid);
				flag=true;
				break;
			}	
		}
		if(!flag) {
			System.out.println("The provided nominee id is not present "+nid);
		}
		return nid;
	}
	public void clickOnSubmit() {
		submit.click();
	}
}
