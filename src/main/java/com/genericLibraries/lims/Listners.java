package com.genericLibraries.lims;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class Listners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String name=result.getTestName();
		Reporter.log(name+" Test execution Started ");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name=result.getTestName();
		Reporter.log(name+" Test succefully executed ");
			
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name=result.getTestName();
		TakesScreenshot sh=(TakesScreenshot)Baseclass.driver;
		File source = sh.getScreenshotAs(OutputType.FILE);
		File destination= new File(".//Screenshot\\"+name+".png");
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name=result.getTestName();
		Reporter.log(name+" Test Skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		String name=context.getName();
		Reporter.log(name+" Test Suite execution Started ");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		String name=context.getName();
		Reporter.log(name+" Suite finished");
		
	}

	
}
