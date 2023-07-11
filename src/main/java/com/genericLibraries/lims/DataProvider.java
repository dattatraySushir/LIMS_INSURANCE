package com.genericLibraries.lims;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider {

	@org.testng.annotations.DataProvider
	public Object[][] dataProviderLims() {
		Object[][] obj = new Object[1][2];
		 obj[0][0]="555";
		 obj[0][1]="666";
		 return obj;
	}
	
	@Test(dataProvider = "dataProviderLims")
	public void login(String un, String password)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(password);
		
	}
	
	
	
}
