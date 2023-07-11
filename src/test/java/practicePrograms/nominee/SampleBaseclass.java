package practicePrograms.nominee;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleBaseclass { 
	@BeforeSuite
	public void bs() {
		System.out.println("@BeforeSuite");
	}
	@BeforeClass
	public void bc() {
		System.out.println("@BeforeClass");
	}
	@BeforeTest
	public void bt() {
		System.out.println("@BeforeTest");
	}
	@BeforeMethod
	public void bm1() {
		System.out.println("@BeforeMethod...1");
	}
	@BeforeMethod
	public void bm2() {
		System.out.println("@BeforeMethod...2");
	}
	@Test(alwaysRun = true, invocationCount = 2)
	public void tc1() {
		System.out.println("Java-->1");
	}
	@Test(priority = -1)
	public void tc2() {
		System.out.println("Java-->2");
	}@Test(dependsOnMethods = "tc1")
	public void tc3() {
		System.out.println("Java-->3");
	}
	@AfterMethod
	public void am() {
		System.out.println("@AfterMethod");
	}
	@AfterClass
	public void ac() {
		System.out.println("@AfterClass");
	}
	@AfterTest
	public void at() {
		System.out.println("@AfterTest");
	}
	@AfterSuite
	public void as() {
		System.out.println("@AfterSuite");
	}
}
