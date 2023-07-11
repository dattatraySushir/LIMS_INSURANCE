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
import org.testng.annotations.Test;

import com.genericLibraries.lims.Baseclass;
import com.genericLibraries.lims.Iconstant;
import com.genericLibraries.lims.JavaUtility;
import com.lims.objectRepository.HomePage;
import com.lims.objectRepository.PaymentsPage;
@Listeners(com.genericLibraries.lims.Listners.class)
public class PaymentsScenarioTest extends Baseclass {
	@Test(groups = {"Smoke", "Regression"})
	public void payments() throws Throwable {
		HomePage hp = new HomePage(driver);
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
