package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {
	
	@Test(retryAnalyzer = com.crm.autodesk.genericutiltiy.RetryAnalyserImpl.class)
	public void retryAnalyserDemoTest()
	{
		System.out.println("RetryAnalyser");
		Assert.fail();
	}

}
