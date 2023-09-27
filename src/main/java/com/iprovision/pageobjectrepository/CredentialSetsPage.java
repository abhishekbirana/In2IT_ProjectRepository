package com.iprovision.pageobjectrepository;

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iprovision.genericutilities.WebDriverUtility;
/**
 * @author abhishek.birana
 */
public class CredentialSetsPage extends WebDriverUtility {

	//declaration
	
	@FindBy(xpath = "//*[local-name()='svg' and @class='feather feather-more-horizontal']")
	private WebElement threeHorizontalDots;
	
	@FindBy(xpath = "//a[text()=' New ']")
	private WebElement newBtn;
	
	@FindBy(xpath = "//a[text()=' Edit']")
	private WebElement editBtn;
	
	@FindBy(xpath = "//a[text()=' Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//select[@formcontrolname='transport_type']")
	private WebElement transportType;
	
	@FindBy(xpath = "//label[text()='Name ']//following-sibling::div[@class='col-md-7']//input")
	private WebElement nameTextField;
	
	@FindBy(xpath = "//label[text()='Username ']//following-sibling::div[@class='col-md-7']//input")
	private WebElement usernameTextField;
	
	@FindBy(xpath = "//label[text()='Password ']//following-sibling::div[@class='col-md-7']//input")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//label[text()='PORT No ']//following-sibling::div[@class='col-md-7']//input")
	private WebElement portNoTextField;
	
	@FindBy(xpath = "//label[text()='Time Out (in Seconds) ']//following-sibling::div[@class='col-md-7']//input")
	private WebElement timeOutTextField;
	
	@FindBy(xpath = "//button[text()=' Create Set ']")
	private WebElement createSetBtn;
	
	@FindBy(xpath = "//button[text()=' Update Set ']")
	private WebElement updateSetBtn;
	
	@FindBy(xpath = "//button[text()='Yes, Update it!']")
	private WebElement yesUpdateItBtn;
	
	@FindBy(xpath = "//button[text()='Yes, delete it!']")
	private WebElement yesDeleteItBtn;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'AbhishekAutomationSet')]/ancestor::div[@role='row']/descendant::input")
	private WebElement credentialSetCheckBox;
	
	@FindBy(xpath = "//label[text()='Show ']/select")
	private WebElement showDropdown;
	
	@FindBy(xpath = "//span[contains(text(),'AbhishekAutomationSet')]")
	private WebElement credentialSetText;
	
	@FindBy(xpath = "//div[@class='messageDiv']//p")
	private WebElement successfulValidationMessage;
	
	
	// initialization
	public CredentialSetsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//Business Library
	
	/**
	 * This method will click on Three Horizontal Dots
	 * @param driver
	 */
	public void clickOnThreeHorizontalDots(WebDriver driver)
	{
		threeHorizontalDots.click();
	}
	
	/**
	 * This method will click on new button
	 */
	public void clickOnNewBtn(WebDriver driver) 
	{
		jsclick(driver, newBtn);
	}
	
	/**
	 * This method will enter all required details for Add New Credential Set
	 * @param driver
	 */
	public void enterAllRequiredDetails(WebDriver driver, String transType, String name, String username, String password, String portNo, String timeOut)
	{
		handleDropdown(transportType, "1: NETCONF");
		nameTextField.sendKeys(name);
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		portNoTextField.sendKeys(portNo);
		timeOutTextField.sendKeys(timeOut);
		createSetBtn.click();
		
	}
	
	
	public void selectAnyCredentialSet(WebDriver driver)
	{
		handleDropdown(showDropdown);
		jsclick(driver, credentialSetCheckBox);
	}
	
	public void clickOnEditBtn(WebDriver driver)
	{
		jsclick(driver, editBtn);
	}
	
	public void editRequiredDetails(WebDriver driver, String username, String password, String portNo, String timeOut)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		portNoTextField.sendKeys(portNo);
		timeOutTextField.sendKeys(timeOut);
		updateSetBtn.click();
		yesUpdateItBtn.click();
		
	}
	
	public void clickOnDeleteBtn(WebDriver driver)
	{
		jsclick(driver, deleteBtn);
		jsclick(driver, yesDeleteItBtn);
	}
	
	public String getCredentialSetHeaderText()
	{
		return credentialSetText.getText();
	}
	
	public String getValidationMessage()
	{
		return successfulValidationMessage.getText();
	}
}
