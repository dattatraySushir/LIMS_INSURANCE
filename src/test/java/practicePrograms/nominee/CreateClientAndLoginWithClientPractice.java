package practicePrograms.nominee;

import org.testng.annotations.Test;

import com.genericLibraries.lims.Baseclass;
import com.genericLibraries.lims.Iconstant;
import com.genericLibraries.lims.JavaUtility;
import com.lims.objectRepository.CreateClientAndLoginClientPage;
import com.lims.objectRepository.HomePage;

public class CreateClientAndLoginWithClientPractice extends Baseclass {
	@Test
	public void createclient() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.clickOnClient();
		CreateClientAndLoginClientPage cl = new CreateClientAndLoginClientPage(driver);
		cl.clickOnAddClient();
		wb.waitForElementInDOM(driver);
		String clientID = cl.getClientID();
		JavaUtility.print("Client ID is: " + clientID);
		cl.fillClientPassword(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_01", "ClientPassword"));
		cl.fillClientName(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_02", "Name"));
		String nomineeID = cl.getNomineeID();
		JavaUtility.print("nomineeId is: " + nomineeID);
		cl.chooseFile(Iconstant.file);
		cl.fillGender(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_03", "Gender"));
		cl.fillBirthDate(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_04", "Birthdate"));
		cl.fillMaritalStatus(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_05", "Maritalstatus"));
		cl.fillNid(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_06", "NationalID"));
		cl.fillPhoneNo(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_07", "PhoneNO."));
		cl.fillAddress(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_08", "Address"));
		cl.fillPolicy(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_09", "PolicyID"));
		cl.fillAgentId(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_10", "AgentID"));
		cl.fillNomineeName(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_11", "Name"));
		cl.fillNomineeGender(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_12", "Gender"));
		cl.fillNomineeBirthdate(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_13", "Birthdate"));
		cl.fillNomineeID(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_14", "NationalID"));
		cl.fillRelationship(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_15", "Relationship"));
		cl.fillPriority(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_16", "Priority"));
		cl.fillNomineePhone(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Client", "TC_17", "Phone"));
		cl.cliclOnSubmitButton();
		String dt = cl.getConfirmMessage();
		JavaUtility.print(dt);
		// click on nominee
		hp.clickOnNominee();
		String clientVerification = cl.verifyClientID(clientID);
		JavaUtility.print("The client ID is verified :" + clientVerification);
		String nomineeVerification = cl.verrifyNomineeID("The nominee ID is verified :" + nomineeID);
		JavaUtility.print(nomineeVerification);

	}
}
