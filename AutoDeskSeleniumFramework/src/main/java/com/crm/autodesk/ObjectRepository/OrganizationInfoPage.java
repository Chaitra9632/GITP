package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryInfo;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeInfo;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

	//business library to get orgnization info
	public String getOrgInfo()
	{
		return(orgHeaderText.getText());
	}
	
	//business library 
	public String getIndustryName()
	{
		return(industryInfo.getText());
	}
	
	//business library
	public String getTypeName()
	{
		return(typeInfo.getText());
	}

	
}
