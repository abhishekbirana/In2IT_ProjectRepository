package com.iprovision.pageobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iprovision.genericutilities.WebDriverUtility;

public class CredentialProfilesPage extends WebDriverUtility {

	
	//declaration
	
	@FindBy(xpath = "//*[local-name()='svg' and @class='feather feather-more-horizontal']")
	private WebElement threeHorizontalDots;
	
	@FindBy(xpath = "//a[text()=' New ']")
	private WebElement newBtn;
	
	@FindBy(xpath = "//a[text()=' Edit']")
	private WebElement editBtn;
	
	@FindBy(xpath = "//a[text()=' Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//input[@formcontrolname='profile_name']")
	private WebElement profileNameTxtFld;
	
	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	private WebElement descriptionTxtFld;
	
	@FindBy(xpath = "//select[@formcontrolname='transporttype']")
	private WebElement connectionTypeDropdown;
	
	@FindBy(xpath = "//select[@formcontrolname='credentialset']")
	private WebElement credentialSetDropdown;
	
	@FindBy(xpath = "//button[text()=' Create Profile ']")
	private WebElement createProfileBtn;
	
	@FindBy(xpath = "//label[text()='Show ']/select")
	private WebElement showDropdown;
	
	@FindBy(xpath = "//span[contains(text(),'AbhishekAutomationProfile')]/ancestor::div[@role='row']/descendant::input")
	private WebElement credentialProfileCheckBox;
	
	@FindBy(xpath = "//button[text()=' Update Profile ']")
	private WebElement updateProfileBtn;
	
	@FindBy(xpath = "//button[text()='Yes, update it!']")
	private WebElement yesUpdateItBtn;
	
	@FindBy(xpath = "//button[text()='Yes, delete it!']")
	private WebElement yesDeleteItBtn;
	
	@FindBy(xpath = "//span[contains(text(),'AbhishekAutomationProfile')]")
	private WebElement credentialProfileText;
	
	@FindBy(xpath = "//div[@class='messageDiv']//p")
	private WebElement successfulValidationMessage;
	
	
	
	// initialization
	public CredentialProfilesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
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
	 * This method will enter all required details for Create New Credential Profile
	 * @param driver
	 * @param profileName
	 * @param description
	 * @param platform
	 * @param function
	 * @param credentialSet
	 */
	public void enterAllRequiredDetails(WebDriver driver, String profileName, String description, String connectionType, String credentialSet)
	{
		profileNameTxtFld.sendKeys(profileName);
		descriptionTxtFld.sendKeys(description);
		handleDropdown(connectionTypeDropdown, "1: 1");
		handleDropdown(credentialSet, credentialSetDropdown);
		createProfileBtn.click();
	}
	
	public void selectAnyCredentialProfile(WebDriver driver)
	{
		handleDropdown(showDropdown);
		jsclick(driver, credentialProfileCheckBox);
	}
	
	public void clickOnEditBtn(WebDriver driver)
	{
		jsclick(driver, editBtn);
	}
	
	public void editRequiredDetails(WebDriver driver, String description, String connectionType, String credentialSetName)
	{
		descriptionTxtFld.sendKeys(description);
		handleDropdown(connectionTypeDropdown, "1: 1");
		handleDropdown(credentialSetName, credentialSetDropdown);
		updateProfileBtn.click();
		yesUpdateItBtn.click();
		
	}
	
	public void clickOnDeleteBtn(WebDriver driver)
	{
		jsclick(driver, deleteBtn);
		jsclick(driver, yesDeleteItBtn);
	}
	
	public String getCredentialProfileHeaderText()
	{
		return credentialProfileText.getText();
	}
	
	public String getValidationMessage()
	{
		return successfulValidationMessage.getText();
	}
	
}
