package com.crm.autodesk.genericutiltiy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtiity fLib = new FileUtiity();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtiltiy eLib = new ExcelUtiltiy();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeSuite","RegressionSuite"})
	public void dbConnection()
	{
		dLib.connectToDB();
		System.out.println("======Database connection successFul=====");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups = {"smokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable
	{                                  //chrome - suite xml file - testNG
		                               //firefox - suite xml file 
		//read the data
		String BROWSER = fLib.getProPertyKeyValue("browser");//chrome
		String URL = fLib.getProPertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();//launched
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();//launched
		}
		else
		{
			System.out.println("invalid Browser"); //executed
		}
		sdriver=driver;
		
	    wLib.waitForPageToLoad(driver);
	    wLib.maximiseWindow(driver);
	    driver.get(URL);
	    System.out.println("======Browser launched=====");
		
	}
	
	
	@BeforeMethod(groups = {"smokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable
	{
		//read the data
		String USERNAME = fLib.getProPertyKeyValue("username");
		String PASSWORD = fLib.getProPertyKeyValue("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("======Login Successfull=====");
	}
	
	@AfterMethod(groups = {"smokeSuite","RegressionSuite"})
	public void logoutOfApp()
	{
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
		System.out.println("======logout successful=====");
	}
	
	@AfterClass(groups = {"smokeSuite","RegressionSuite"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("======browser closed=====");
	}
	
	@AfterSuite(groups = {"smokeSuite","RegressionSuite"})
	public void closeDbConnection()
	{
		dLib.closeDB();
		System.out.println("======Database connection closed=====");
	}

}
