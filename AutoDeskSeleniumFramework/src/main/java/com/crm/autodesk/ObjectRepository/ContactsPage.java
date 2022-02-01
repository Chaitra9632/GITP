package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage { //Step 1 create seperate class
	
	//Step 2 identify all the web elemnts
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	@FindAll({@FindBy(name = "search_text"),@FindBy(xpath = "//input[@class='txtBox']")})
	private WebElement searchtextEdt;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;
	
	//Step 3 initailise using constructor
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Sttep 4 utilization
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	public WebElement getSearchtextEdt() {
		return searchtextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//Business Library
	public void clickOnCreateContactImg()
	{
		createContactLookUpImg.click();
	}
	
	
	

}
