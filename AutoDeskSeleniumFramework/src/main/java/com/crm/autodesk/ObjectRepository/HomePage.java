package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutiltiy.WebDriverUtility;

public class HomePage extends WebDriverUtility{ //Step 1: create a seperate class for home page
	
	//Step2 : Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText = "Email")
	private WebElement emailLnk;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicketsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	//Step 3 Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Step 4 Utilization
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getTroubleTicketsLnk() {
		return troubleTicketsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//Business Library to click on organizations
	public void clickOnOrganizationsLink()
	{
		organizationsLnk.click();
	}
	
	//Business Library to click on contacts
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	//Business library for logout
	public void logout(WebDriver driver)
	{
		mouseOverOnElemnet(driver,administratorImg);
		signOutLnk.click();
	}
}

