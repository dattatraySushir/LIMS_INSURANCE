package practicePrograms.nominee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class SystemScenarioNomineePractice extends Baseclass {
	@Test
	public void nomineeScenario() throws Throwable {
			NomineePage np = new NomineePage(driver);
			/**
		 * clicking on the nominee module.
		 */
		HomePage hp = new HomePage(driver);
		hp.clickOnNominee();
		/**
		 * clicking on the add nominee.
		 */
		np.clickOnAddNominee();
		/**
		 * Provinding the test data for the required fields and clicking on the submit
		 * button.
		 */
		int value = ju.getRandomNumber();
		String name = "Anna" + ju.getRandomNumber();
		np.fillName(ef.getDataFromExcelBasedTestId(Iconstant.excelpath,"Nominee","TC_01", "Name"));
		np.fillGender(ef.getDataFromExcelBasedTestId(Iconstant.excelpath,"Nominee","TC_02", "Gender"));
		np.fillBirthdate(ef.getDataFromExcelBasedTestId(Iconstant.excelpath,"Nominee","TC_03", "Birthdate"));
		np.fillNationalId(ef.getDataFromExcelBasedTestId(Iconstant.excelpath,"Nominee","TC_04", "NID"));
		np.fillRelationship(ef.getDataFromExcelBasedTestId(Iconstant.excelpath,"Nominee","TC_05", "Relationship"));
		np.fillPriority(ef.getDataFromExcelBasedTestId(Iconstant.excelpath,"Nominee","TC_06", "Priority"));
		np.fillPhone(ef.getDataFromExcelBasedTestId(Iconstant.excelpath,"Nominee","TC_07", "Phone"));
		// coming back to the nominee module.
		hp.clickOnNominee();
		/**
		 * For verifying whether the nominee is created must be added to the table or
		 * not.
		 */
		np.verifyNomineeName(name);
		JavaUtility.print("The nominee name is avaliable in the list :"+name);
		
		

	}

}
