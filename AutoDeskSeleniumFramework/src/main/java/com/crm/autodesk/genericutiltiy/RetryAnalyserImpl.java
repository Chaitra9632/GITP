package com.crm.autodesk.genericutiltiy;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for iREtryAnalyser 
 * @author Chaitra M
 *
 */
public class RetryAnalyserImpl implements IRetryAnalyzer{
	
	int count=0;
	
	int retrycount = 2;

	public boolean retry(ITestResult result) {

		while(count<retrycount)
		{
			count++;
			return true;
		}
		
		return false;
	}
	

}
