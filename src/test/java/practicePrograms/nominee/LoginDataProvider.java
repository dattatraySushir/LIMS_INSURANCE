package practicePrograms.nominee;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericLibraries.lims.Iconstant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDataProvider {

	@Test(dataProvider = "file")
	public void login(String username, String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
		
	@DataProvider(name="file")
	public Object[][] dataProvider() throws Throwable, Throwable {
		LoginWithDataProvider lwp= new LoginWithDataProvider();
		Object[][] obj=lwp.readMultipleDataFromExcel(Iconstant.dataProvider,"logincred");
		return obj;
	}
}
