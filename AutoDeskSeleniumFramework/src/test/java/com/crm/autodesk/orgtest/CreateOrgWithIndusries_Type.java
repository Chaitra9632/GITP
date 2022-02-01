package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutiltiy.BaseClass;
import com.crm.autodesk.genericutiltiy.ExcelUtiltiy;
import com.crm.autodesk.genericutiltiy.FileUtiity;
import com.crm.autodesk.genericutiltiy.JavaUtility;
import com.crm.autodesk.genericutiltiy.WebDriverUtility;

public class CreateOrgWithIndusries_Type extends BaseClass {
	
	    @Test(groups = "RegressionSuite")
		public void createOrgWithIndustriesTest() throws Throwable {
	        
	      //getRanDom Num
	      int ranDomNum = jLib.getRanDomNumber();
	        
		  //read test data from Excel File
	      String orgNAme  = eLib.getDataFromExcel("org", 4, 2) + ranDomNum;
	      String industries  = eLib.getDataFromExcel("org", 4, 3) ;
	      String type  =eLib.getDataFromExcel("org", 4, 4) ;
	                   
          // step 2 : navigate to O;ation module
          HomePage hp = new HomePage(driver);
          hp.clickOnOrganizationsLink();
          
          // step 3 : click on "create Organization" Button
          OrganizationsPage op = new OrganizationsPage(driver);
          op.clickOnCreateOrg();
          
          // step 4 : enter all the details & create new Organization with industries & type
         CreateOrganizationPage cop = new CreateOrganizationPage(driver);
         cop.createOrgWithIndustryType(orgNAme, industries, type);
           
         // step 5 : verify Organization name in header of the msg
         OrganizationInfoPage oip = new OrganizationInfoPage(driver);
         String actSuc_msg = oip.getOrgInfo();
        
         //SoftAssert sa = new SoftAssert();
         //sa.assertTrue(actSuc_msg.contains("abc"));
        
         String actIndsutirs = oip.getIndustryName();
         
         System.out.println(actIndsutirs);
         //sa.assertTrue(actIndsutirs.equals("ind"));
       
         
         String actType = oip.getTypeName();
         System.out.println(actType);
         Assert.assertTrue(actType.equals(type));
         
         //sa.assertAll();
        
    
	}

}
