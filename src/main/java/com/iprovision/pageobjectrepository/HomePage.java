package com.iprovision.pageobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iprovision.genericutilities.WebDriverUtility;



/**
 * @author abhishek.birana
 */
public class HomePage extends WebDriverUtility{

	// declaration
	
	@FindBy(xpath = "//*[local-name()='svg' and @class='feather feather-menu']")
	private WebElement threeHorizontalLine;
	
	@FindBy(xpath = "//div[text()='Credentials Sets']")
	private WebElement credentialSetsBtn;
	
	@FindBy(xpath = "//div[text()='Credentials Profiles']")
	private WebElement credentialProfilesBtn;
	
	@FindBy(xpath = "//div[text()='Device']")
	private WebElement deviceBtn;
	
	@FindBy(xpath = "//div[text()='Network Modelling']")
	private WebElement networkModellingBtn;
	
	@FindBy(xpath = "//div[text()='Sites']")
	private WebElement sitesBtn;
	
	


	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	//Business Library
	/**
	 * This method will click on Credential Sets Button
	 * @throws InterruptedException 
	 */
	public void clickOnCredentialSetsBtn(WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(5000);
		switchToWindow(driver, "iProvision");
		credentialSetsBtn.click();
	}
	
	/**
	 * This method will click on Credential Profile Button
	 * @throws InterruptedException 
	 */
	public void clickOnCredentialProfilesBtn(WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(5000);
		switchToWindow(driver, "iProvision");
		credentialProfilesBtn.click();
	}
	
	/**
	 * This method will click on Device Button
	 * @throws InterruptedException 
	 */
	public void clickOnDeviceBtn(WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(5000);
		switchToWindow(driver, "iProvision");
		deviceBtn.click();
	}
	
	
	
	
	public void goBackToParentTab(WebDriver driver, String parentId)
	{
		driver.close();
		switchToParentTab(driver, parentId);
	}
	
	
	public void clickOnThreeHorizontalLine(WebDriver driver)
	{
		threeHorizontalLine.click();
	}
	
	
	public void clickOnNetworkModellingBtn(WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(5000);
		switchToWindow(driver, "iProvision");
		networkModellingBtn.click();
	}
	
	public void clickOnSitesBtn(WebDriver driver)
	{
		sitesBtn.click();
	}
	
	
	
	
	

}
