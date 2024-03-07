package com.iprovision.pageobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SitesPage {

	
	@FindBy(xpath = "//*[local-name()='svg' and @class='feather feather-more-horizontal']")
	private WebElement threeHorizontalDots;
	
	@FindBy(xpath = "//a[text()=' Add Single Site']")
	private WebElement addSingleSiteBtn;
	
	
	public SitesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnThreeHorizontalDots(WebDriver driver)
	{
		threeHorizontalDots.click();
	}
	
	public void clickOnAddSingleSite(WebDriver driver)
	{
		addSingleSiteBtn.click();
	}
	
}
