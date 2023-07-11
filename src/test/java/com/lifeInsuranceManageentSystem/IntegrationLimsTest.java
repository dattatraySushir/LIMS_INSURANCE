package com.lifeInsuranceManageentSystem;

import org.testng.annotations.Test;

import com.genericLibraries.lims.Baseclass;
import com.genericLibraries.lims.Iconstant;
import com.genericLibraries.lims.JavaUtility;
import com.lims.objectRepository.CreateClientAndLoginClientPage;
import com.lims.objectRepository.HomePage;
import com.lims.objectRepository.PaymentsPage;

public class IntegrationLimsTest extends Baseclass {
	@Test
	public void limsIntegration() throws Throwable {
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
		hp.clickOnPayments();
		PaymentsPage pp = new PaymentsPage(driver);
		hp.clickOnPayments();
		pp.clickOnAddPayments();
		String payreceipt = pp.getReceiptNo();
		JavaUtility.print("The receipt no. is: " + payreceipt);
		String clinetid = "235136";
		pp.fillClientId(clinetid);
		pp.fillMonth(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_01", "Month"));
		pp.fillAmount(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_02", "Amount"));
		pp.fillDue(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_03", "Due"));
		pp.fillFine(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_04", "Fine"));
		pp.fillAgent(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_05", "AgentID"));
		pp.clickOnSubmit();
		boolean paymentmsg = pp.getPaymentsMessage();
		JavaUtility.print("The payment message must be show: " + paymentmsg);
		hp.clickOnPayments();
		/**
		 * For verifying the payment receipt
		 */
		pp.verifyPaymentReceiptNo(payreceipt);
	}
}
