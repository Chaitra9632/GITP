package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsInfopage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericutiltiy.BaseClass;
import com.crm.autodesk.genericutiltiy.ExcelUtiltiy;
import com.crm.autodesk.genericutiltiy.FileUtiity;
import com.crm.autodesk.genericutiltiy.JavaUtility;
import com.crm.autodesk.genericutiltiy.WebDriverUtility;
/**
 * 
 * @author Chaitra
 *
 */
public class CreateContactTest extends BaseClass{
	    
	    @Test(groups = "smokeSuite")
		public void createContactTest() throws Throwable {

	        //getRanDom Num
			int ranDomNum = jLib.getRanDomNumber();
	        
			//read test data from Excel File
            String lastName = eLib.getDataFromExcel("contact", 1, 2);
	            
      // step 2 : navigate to contact module
       HomePage hp = new HomePage(driver);
       hp.clickOnContactsLink();
       Reporter.log("Click on contacts", true); 
        
      // step 3 : click on "create Contact" Button
      ContactsPage cp = new ContactsPage(driver);
      cp.clickOnCreateContactImg();
       
       
      // step 4 : enter all the details & create new Contact
       CreateContactPage ccp = new CreateContactPage(driver);
       ccp.createContact(lastName);
       Reporter.log("create contact with mandatory details", true);
        
        
      // step 5 : verify Contact name in header of the msg
        ContactsInfopage cip = new ContactsInfopage(driver);
        String actcontactMsg = cip.getcontactIngo();
        Reporter.log("contact info captured");
        Assert.fail();
        
        Assert.assertTrue(actcontactMsg.contains(lastName));
        Reporter.log("test script passed");
       
        	
        
	}

}
