package com.lifeInsuranceManageentSystem;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.genericLibraries.lims.Baseclass;
import com.genericLibraries.lims.ExcelFetching;
import com.genericLibraries.lims.Iconstant;
import com.genericLibraries.lims.JavaUtility;
import com.genericLibraries.lims.PropertiesUtility;
import com.genericLibraries.lims.WebDriverUtility;
import com.lims.objectRepository.CreateClientAndLoginClientPage;
import com.lims.objectRepository.HomePage;
import com.lims.objectRepository.LogOutPage;
import com.lims.objectRepository.LoginPage;
import com.lims.objectRepository.NomineePage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Dattatray The below method is an end to end scenario for the Nominee
 *         module. Whereas it will use for adding the nominee in the nominee
 *         module.
 *
 */
@Listeners(com.genericLibraries.lims.Listners.class)

public class SystemScenarioNomineeTest extends Baseclass {
	@Test(groups = "Regression")
	public void nomineeScenario() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.clickOnClient();
		CreateClientAndLoginClientPage cl = new CreateClientAndLoginClientPage(driver);
		cl.clickOnAddClient();
		wb.waitForElementInDOM(driver);
		String clientID = cl.getClientID();
		JavaUtility.print("Client ID is: " + clientID);
		cl.fillClientPassword(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_01", "ClientPassword"));
		cl.fillClientName(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_02", "Name"));
		
		cl.chooseFile(Iconstant.file);
		cl.fillGender(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_03", "Gender"));
		cl.fillBirthDate(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_04", "Birthdate"));
		cl.fillMaritalStatus(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_05", "Maritalstatus"));
		cl.fillNid(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_06", "NationalID"));
		cl.fillPhoneNo(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_07", "PhoneNO."));
		cl.fillAddress(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_08", "Address"));
		cl.fillPolicy(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_09", "Policy ID"));
		cl.fillAgentId(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_10", "AgentID"));
		cl.fillNomineeName(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_11", "Name"));
		cl.fillNomineeGender(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_12", "Gender"));
		cl.fillNomineeBirthdate(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_13", "Birthdate"));
		cl.fillNomineeID(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_14", "NationalID"));
		cl.fillRelationship(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_15", "Relationship"));
		cl.fillPriority(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_16", "Priority"));
		cl.fillNomineePhone(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_17", "Phone"));
		String nomineeID = cl.getNomineeID();
		JavaUtility.print("nomineeId is: " + nomineeID);
		cl.cliclOnSubmitButton();
		String dt = cl.getConfirmMessage();
		JavaUtility.print(dt);
		hp.clickOnClient();
		wb.refresh(driver);
		String clientVerification = cl.verifyClientID(clientID);
		JavaUtility.print(clientVerification);
		hp.clickOnNominee();
		wb.refresh(driver);
		String nomineeVerification = cl.verrifyNomineeID( nomineeID);
		JavaUtility.print(nomineeVerification);
		NomineePage np= new NomineePage(driver);
		/**
		 * clicking on the add nominee.
		 */
		np.clickOnAddNominee();
		/**
		 * Provinding the test data for the required fields and clicking on the submit
		 * button.
		 */
		//String noID=np.getNomineeid();
		String name="james"+ju.getRandomNumber();
		//System.out.println(noID);
		np.fillClientId(clientID);
		np.fillName(name);
		np.fillGender(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Nominee", "TC_02", "Gender"));
		np.fillBirthdate(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Nominee", "TC_03", "Birthdate"));
		np.fillNationalId(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Nominee", "TC_04", "NID"));
		np.fillRelationship(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Nominee", "TC_05", "Relationship"));
		np.fillPriority(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Nominee", "TC_06", "Priority"));
		np.fillPhone(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Nominee", "TC_07", "Phone"));
		np.clickOnSubmit();
		
		// coming back to the nominee module.
		hp.clickOnNominee();
		wb.refresh(driver);
		/**
		 * For verifying whether the nominee is created must be added to the table or
		 * not.
		 */
		np.verifyNomineeName(nomineeID);

	}

}
