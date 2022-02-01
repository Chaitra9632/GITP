package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutiltiy.BaseClass;
import com.crm.autodesk.genericutiltiy.ExcelUtiltiy;
import com.crm.autodesk.genericutiltiy.FileUtiity;
import com.crm.autodesk.genericutiltiy.JavaUtility;
import com.crm.autodesk.genericutiltiy.WebDriverUtility;

@Listeners(com.crm.autodesk.genericutiltiy.ListnerImplementation.class)
public class CreateOrgTest extends BaseClass {
		
	@Test//(groups = "smokeSuite")//, retryAnalyzer = com.crm.autodesk.genericutiltiy.RetryAnalyserImpl.class)
	public void createOrgTest() throws Throwable
	{
	
		//SoftAssert sa = new SoftAssert();
		
	  //getRanDom Num
	  int ranDomNum = jLib.getRanDomNumber();
	        
      //read test data from Excel File
	  String orgNAme  =  eLib.getDataFromExcel("org", 1, 2)+ ranDomNum;
	        
	      
      // step 2 : navigate to Organization module
       HomePage hp = new HomePage(driver);
       hp.clickOnOrganizationsLink();
       
       
       
      // step 3 : click on "create Organization" Button
       OrganizationsPage op = new OrganizationsPage(driver);
       op.clickOnCreateOrg();
       Assert.fail();
       
       
      // step 4 : enter all the details & create new Organization
      CreateOrganizationPage cop = new CreateOrganizationPage(driver);
      cop.createOrg(orgNAme);
       
       
      // step 5 : verify Organization name in header of the msg
      OrganizationInfoPage oip = new OrganizationInfoPage(driver);
      String ActMsg = oip.getOrgInfo();
      
      //sa.assertAll();

      
	}

      

}
