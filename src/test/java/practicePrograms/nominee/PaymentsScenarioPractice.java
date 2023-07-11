package practicePrograms.nominee;

import org.testng.annotations.Test;

import com.genericLibraries.lims.Baseclass;
import com.genericLibraries.lims.ExcelFetching;
import com.genericLibraries.lims.Iconstant;
import com.lims.objectRepository.HomePage;
import com.lims.objectRepository.PaymentsPage;

public class PaymentsScenarioPractice extends Baseclass{
	@Test
	public void payments() throws Throwable {
		HomePage hp = new HomePage(driver);
		 PaymentsPage pp = new PaymentsPage(driver);
		 
		hp.clickOnPayments();
		pp.clickOnAddPayments();
		String payreceipt=pp.getReceiptNo();
		System.out.println("The receipt no. is: " + payreceipt);
		String clinetid = "235136";
		pp.fillClientId(clinetid);
		pp.fillMonth(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_01", "Month"));
		pp.fillAmount(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_02", "Amount"));
		pp.fillDue(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_03", "Due"));
		pp.fillFine(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_04", "Fine"));
		pp.fillAgent(ef.getDataFromExcelBasedTestId(Iconstant.excelpath, "Payments", "TC_05", "AgentID"));
		pp.clickOnSubmit();
		boolean paymentmsg = pp.getPaymentsMessage();
		if (paymentmsg) {

			System.out.println("The payment message must be show: " + paymentmsg);
		} else {
			System.out.println("The payment message is not showing");
		}
		hp.clickOnPayments();
		/**
		 * For verifying the payment receipt
		 */
		
		pp.verifyPaymentReceiptNo(payreceipt);
	

	}
}
