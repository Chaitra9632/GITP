package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsInfopage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutiltiy.BaseClass;
import com.crm.autodesk.genericutiltiy.ExcelUtiltiy;
import com.crm.autodesk.genericutiltiy.FileUtiity;
import com.crm.autodesk.genericutiltiy.JavaUtility;
import com.crm.autodesk.genericutiltiy.WebDriverUtility;

@Listeners(com.crm.autodesk.genericutiltiy.ListnerImplementation.class)
public class CreateContactWithOrgTest extends BaseClass{
	
	    @Test(groups = "RegressionSuite")
		public void createContactWithOrgTest() throws Throwable {
		
	        //getRanDom Num
	        int ranDomNum = jLib.getRanDomNumber();
	        
			//read test data from Excel Fil
	       String lastName  = eLib.getDataFromExcel("contact", 4, 2) + ranDomNum;
	       String orgName  = eLib.getDataFromExcel("contact", 4, 3)  + ranDomNum;

      
        // step 2 : navigate to Organization module
      
       HomePage hp = new HomePage(driver);
       hp.clickOnOrganizationsLink();
      
      
        OrganizationsPage op = new OrganizationsPage(driver);
        op.clickOnCreateOrg();
        
      // step 3 : click on "create Organization" Button
       CreateOrganizationPage cop = new CreateOrganizationPage(driver);
       cop.createOrg(orgName);

       
        //wait for Element to be active 
      wLib.waitForElemnetToBeClickAble(driver, driver.findElement(By.className("dvHeaderText")));
        
      // step 5 : navigate to contact module
       hp.clickOnContactsLink();  
        
        // step 6 : click on "create Contact" Button
      ContactsPage cp = new ContactsPage(driver);
      cp.clickOnCreateContactImg();
      
      CreateContactPage ccp = new CreateContactPage(driver);
      ccp.createContactWithOrg(driver, lastName, orgName);
      Assert.fail();
       
      //verification
       ContactsInfopage cip = new ContactsInfopage(driver);
      
        

        
  
	}

}
