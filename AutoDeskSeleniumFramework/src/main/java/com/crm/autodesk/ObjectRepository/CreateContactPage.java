package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutiltiy.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	
	//dclaration
	@FindBy(name = "lastname")
	private WebElement contactLastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement OrgNameLookUpImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "search_text")
	private WebElement orgSearchTextEdt;
	
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	
	//initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return OrgNameLookUpImg;
	}

	public WebElement getOrgSearchTextEdt() {
		return orgSearchTextEdt;
	}


	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	//business library for create contact
	public void createContact(String lastName)
	{
		contactLastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	//create contact with organization
	public void createContactWithOrg(WebDriver driver,String lastName, String orgName)
	{
		contactLastNameEdt.sendKeys(lastName);
		OrgNameLookUpImg.click();
		swithToWindow(driver, "Accounts");
		orgSearchTextEdt.sendKeys(orgName);
		orgSearchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		swithToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	
}
