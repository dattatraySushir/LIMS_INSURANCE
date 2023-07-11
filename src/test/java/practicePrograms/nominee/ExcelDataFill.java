package practicePrograms.nominee;

import org.apache.poi.ss.usermodel.Row;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class ExcelDataFill {
	public static void main(String[] args) throws Exception, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.findElement(By.name("username")).sendKeys("555", Keys.TAB, "666", Keys.ENTER);
		driver.findElement(By.xpath("//ul[@id='main-menu']/li[5]/a")).click();

		List<WebElement> nid = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[*]/td[1]"));

		List<WebElement> name = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[*]/td[3]"));

		FileInputStream fis = new FileInputStream("D:\\Java Eclipse\\Automation\\datadriven\\TestDataFill.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		Row ro = null;
		for (int i = 0; i < nid.size(); i++) {

			sh.createRow(i).createCell(0).setCellValue(nid.get(i).getText());
			FileOutputStream fos = new FileOutputStream("D:\\Java Eclipse\\Automation\\datadriven\\TestDataFill.xlsx");
			book.write(fos);
		}
		DataFormatter df = new DataFormatter();
		for (int j = 0; j < name.size(); j++) {
			ro.createCell(j).setCellValue(name.get(j).getText());
			FileOutputStream fos = new FileOutputStream("D:\\Java Eclipse\\Automation\\datadriven\\TestDataFill.xlsx");
			book.write(fos);
		}
		System.out.println("data pass");
	}
}