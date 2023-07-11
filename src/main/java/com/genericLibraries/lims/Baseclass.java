package com.genericLibraries.lims;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.lims.objectRepository.HomePage;
import com.lims.objectRepository.LogOutPage;
import com.lims.objectRepository.LoginPage;
import com.lims.objectRepository.PaymentsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is going to provide all the operations of the pre condition and
 * the post condition scenarios.
 * 
 * @author Dattatray
 *
 */
@Listeners(com.genericLibraries.lims.Listners.class)
public class Baseclass {
	
	public static WebDriver driver;
	public DataBaseUtility databaseutility = new DataBaseUtility();
	public PropertiesUtility pu = new PropertiesUtility();
	public WebDriverUtility wb = new WebDriverUtility();
	public ExcelFetching ef = new ExcelFetching();
	public JavaUtility ju = new JavaUtility();

	@BeforeSuite(alwaysRun = true)
	public void dbConnectionEastablish() {
		databaseutility.connectDB();
		JavaUtility.print("DataBase Connection Eastablished");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void openBrowser() throws Throwable {
		JavaUtility.print("@Beforeclass  -->Executed");
		String BROWSER = pu.getDataFromProperties(Iconstant.propertypath, "browser");
		String URL = pu.getDataFromProperties(Iconstant.propertypath, "url");
		switch (BROWSER) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		wb.maximizeBrowser(driver);
		wb.waitForElementInDOM(driver);
		driver.get(URL);
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws Throwable {
		JavaUtility.print("@BeforeMethod  -->Executed");
		String USERNAME = pu.getDataFromProperties(Iconstant.propertypath, "username");
		String PASSWORD = pu.getDataFromProperties(Iconstant.propertypath, "password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplicatio(USERNAME, PASSWORD);
	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() {
		JavaUtility.print("@AfterMethod  -->Executed");
		LogOutPage lop = new LogOutPage(driver);
		lop.logoutApplication();
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		JavaUtility.print("@AfterMethod  -->Executed");
		driver.close();
	}

	@AfterSuite(alwaysRun = true)
	public void dbConnectionClose() {
		databaseutility.closeDB();
		JavaUtility.print("DataBase Connection Closed");
	}
}
