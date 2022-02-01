package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPracticeTest {
	
	@Test
	public void createCustomerTest()
	{
		System.out.println("Customer created");
	}
	
	@Test(dependsOnMethods = "createCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("Customer Modified");
	}
	
	@Test
	public void deleteCustomerTest()
	{
		System.out.println("customer deleted");
	}

}
