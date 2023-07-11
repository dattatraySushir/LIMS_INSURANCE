package com.genericLibraries.lims;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		int count=0;
		if(count<3) {
			count++;
			return true;
		} 
		return false;
	}

	
}
