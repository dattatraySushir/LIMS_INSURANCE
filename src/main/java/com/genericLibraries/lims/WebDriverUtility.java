package com.genericLibraries.lims;


	

	import java.io.File;
import java.io.IOException;
import java.time.Duration;
	import java.util.Iterator;
	import java.util.Set;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

	/**
	 * contains all web browser related actions which includes mouse move , select , switchToWindow , wait etc
	 * @author Dattatray
	 *
	 */
	public class WebDriverUtility {
		PropertiesUtility fLib = new PropertiesUtility();
		int TIMEOUT;
		
	
		/**
		 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
		 * @param driver
		 * @throws Throwable 
		 */
		public void waitForElementInDOM(WebDriver driver) throws Throwable {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		}
		
		/**
		 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
		 * @param driver
		 * @param partailPageURL
		 * @throws Throwable 
		 */
		public void waitForPage(WebDriver driver , String partailPageURL) throws Throwable {
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
			wait.until(ExpectedConditions.urlContains(partailPageURL));
		}
		
		/**
		 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
		 * @param driver
		 * @param partailPageURL
		 * @throws Throwable 
		 */
		public void waitForElement(WebDriver driver , WebElement element) throws Throwable {
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/**
		 * 
		 * @param element
		 * @throws Throwable 
		 */
		   public void waitAndClick(WebElement element) throws Throwable
		   {

			   int count = 0;
		       while(count<TIMEOUT) {
			    	   try {
			    	       element.click();
			    	       break;
			    	   }catch(Throwable e){
			    		   Thread.sleep(1000);
			    		   count++;
			    	   }
		       }
		   }
		   /**
		    * wait for the element and type the data
		    * @param element
		    * @param data
		    * @throws InterruptedException
		    */
		   public void waitAndType(WebElement element, String data) throws InterruptedException
		   {
			   int count = 0;
		       while(count<20) {
			    	   try {
			    	       element.sendKeys(data);
			    	       break;
			    	   }catch(Throwable e){
			    		   Thread.sleep(1000);
			    		   count++;
			    	   }
		       }
		   }
		
		/**
		 *  used to Switch to Any Window based on Window Title
		 * @param driver
		 * @param partialWindowTitle
		 */
		public void swithToWindow(WebDriver driver , String partialWindowTitle) {
		       Set<String> set = driver.getWindowHandles();
		         Iterator<String> it = set.iterator();

		          while (it.hasNext()) {
				          String wID = it.next();
				          driver.switchTo().window(wID);
				          String currentWindowTitle = driver.getTitle();
				          if(currentWindowTitle.contains(partialWindowTitle)) {
				        	  System.out.println(partialWindowTitle + "Switch to Window is passed--!");
				        	  break;
				          }
			    	}
		}
		/**
		 *  used to Switch to Any Window based on Window URL
		 * @param driver
		 * @param partialWindowTitle
		 */
		public void swithToWindowBasedOnURL(WebDriver driver , String partialWindowURL) {
		       Set<String> set = driver.getWindowHandles();
		         Iterator<String> it = set.iterator();

		          while (it.hasNext()) {
				          String wID = it.next();
				          driver.switchTo().window(wID);
				          String currentWindowTitle = driver.getCurrentUrl();
				          if(currentWindowTitle.contains(partialWindowURL)) {
				        	  System.out.println(partialWindowURL + "Switch to Window is passed--!");
				        	  break;
				          }
			    	}
		}
		/**
		 * used to Switch to Alert Window & click on OK button
		 * @param driver
		 */
		public void swithToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg) {
			Alert alt = driver.switchTo().alert();
			 if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
				 System.out.println("Alert Message is verified");
			 }else {
				 System.out.println("Alert Message is not verified");
			 }
			alt.accept();
		}
		
		
		/**
		 * used to Switch to Alert Window & click on Cancel button
		 * @param driver
		 */
		public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
			Alert alt = driver.switchTo().alert();
			 if(alt.getText().equals(expectedMsg)) {
				 System.out.println("Alert Message is verified");
			 }else {
				 System.out.println("Alert Message is not verified");
			 }
			 alt.dismiss();
		}
		/**
		 * used to Switch to Frame Window based on index
		 * @param driver
		 * @param index
		 */
		public void swithToFrame(WebDriver driver , int index) {
			driver.switchTo().frame(index);
		}
		
		/**
		 * used to Switch to Frame Window based on id or name attribute
		 * @param driver
		 * @param id_name_attribute
		 */
		public void swithToFrame(WebDriver driver , String id_name_attribute) {
			driver.switchTo().frame(id_name_attribute);
		}
		
		/**
		 * used to select the value from the dropDwon  based on index
		 * @param driver
		 * @param index
		 */
		public void select(WebElement element , int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 * used to select the value from the dropDwon  based on value / option avlaible in GUI
		 * @param element
		 * @param value
		 */
		public void select(WebElement element , String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		/**
		 * used to place mouse cursor on specified element
		 * @param driver
		 * @param elemnet
		 */
		public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
		{
			Actions act = new Actions(driver);
			act.moveToElement(elemnet).perform();
		}
		
		/**
		 * 	 used to right click  on specified element

		 * @param driver
		 * @param elemnet
		 */
		
		public void rightClickOnElement(WebDriver driver , WebElement elemnet)
		{
			Actions act = new Actions(driver);
			act.contextClick(elemnet).perform();
		}
		
		/**
		 * 
		 * @param driver
		 * @param javaScript
		 */
		public void executeJavaScript(WebDriver driver , String javaScript) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeAsyncScript(javaScript, null);
		}

		   

		    
		    /**
		     * pass enter Key appertain in to Browser
		     * @param driver
		     */
		   public void passEnterKey(WebDriver driver) {
			   Actions act = new Actions(driver);
			   act.sendKeys(Keys.ENTER).perform();
		   } 
		   /**
		    * This method is use to maximise the browser
		    * @param driver
		    */
		   public void maximizeBrowser(WebDriver driver) {
			   driver.manage().window().maximize();
		   }

		   /**
		    * This method is used to provide the thread sleep for the script
		    */
		   public void sleep(int time) {
			   try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   public void refresh(WebDriver driver) {
			   driver.navigate().refresh();
		   }
		   /**
		    * This is going to take a screenshot
		    * @param driver
		    * @param name
		    * @return
		    */
		   public static String takescreenshot(WebDriver driver, String name) {
			   TakesScreenshot sh=(TakesScreenshot)Baseclass.driver;
				File source = sh.getScreenshotAs(OutputType.FILE);
				File destination= new File(".//Screenshot\\"+name+".png");
				try {
					Files.copy(source, destination);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return name;
		   }
		

	}


