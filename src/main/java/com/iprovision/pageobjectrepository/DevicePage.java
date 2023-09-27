package com.iprovision.pageobjectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iprovision.genericutilities.WebDriverUtility;

/**
 * @author abhishek.birana
 */
public class DevicePage extends WebDriverUtility {

	//declaration
	
		@FindBy(xpath = "//*[local-name()='svg' and @class='feather feather-more-horizontal']")
		private WebElement threeHorizontalDots;
		
		@FindBy(xpath = "//a[text()=' New Device ']")
		private WebElement newDeviceBtn;
		
		@FindBy(xpath = "//a[text()=' Edit']")
		private WebElement editBtn;
		
		@FindBy(xpath = "//a[text()=' Delete']")
		private WebElement deleteBtn;
		
		@FindBy(xpath = "//span[text()='Add Single ']")
		private WebElement addSingleBtn;
		
		@FindBy(xpath = "//span[text()='Bulk Upload ']")
		private WebElement bulkUploadBtn;
		
		@FindBy(xpath = "//a[text()=' Next ']")
		private WebElement nextBtn1;
		
		@FindBy(xpath = "//label[text()='Tenant Group']/..//ul[@class='dataList ng-star-inserted']")
		private List<WebElement> tenantGroupList;
		
		@FindBy(xpath = "//label[text()='Tenant']/..//ul[@class='dataList ng-star-inserted']")
		private List<WebElement> tenantList;
		
		@FindBy(xpath = "//label[text()='Site']/..//ul[@class='dataList ng-star-inserted']")
		private List<WebElement> siteList;
		
		@FindBy(xpath = "//select[@formcontrolname='domain_id']")
		private WebElement domainDropdown;
		
		@FindBy(xpath = "//select[@formcontrolname='data_device_type_id']")
		private WebElement deviceTypeDropdown;
		
		@FindBy(xpath = "//select[@formcontrolname='device_role_id']")
		private WebElement deviceRoleDropdown;
		
		@FindBy(xpath = "//input[@formcontrolname='management_ip_address']")
		private WebElement managementIPAddressTextField;
		
		@FindBy(xpath = "//select[@formcontrolname='management_ip_interface']")
		private WebElement managementIPInterfaceDropdown;
		
		@FindBy(xpath = "//input[@formcontrolname='name']")
		private WebElement nameTextField;
		
		@FindBy(xpath = "//textarea[@formcontrolname='description']")
		private WebElement descriptionTextField;
		
		@FindBy(xpath = "//select[@formcontrolname='credential_profile']")
		private WebElement credentialProfileDropdown;
		
		@FindBy(xpath = "//a[text()=' Save ']")
		private WebElement saveBtn;
		
		@FindBy(xpath = "//a[text()='Clear Info']")
		private WebElement clearInfoBtn;
		
		@FindBy(xpath = "//a[text()=' Next ']")
		private WebElement nextBtn2;
		
		
		
		// initialization
		public DevicePage(WebDriver driver)
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
			newDeviceBtn.click();
		}
		
		/**
		 * This method will click on Add Single
		 */
		public void clickOnAddSingleBtn(WebDriver driver) 
		{
			addSingleBtn.click();
		}
		
		public void clickOnNextBtn1()
		{
			nextBtn1.click();
		}
		
		public void clickOnNextBtn2()
		{
			nextBtn2.click();
		}
		
		/**
		 * This method will enter all required details for Add New Device
		 * @param driver
		 */
		public void enterAllRequiredDetails(WebDriver driver, String tenantGroup, String tenant, String site, String domain, String deviceType, String deviceRole, String managementIpAddress, String managementIpInterface, String name, String description, String credentialProfile)
		{
			handleDropdownList(driver, tenantGroupList, tenantGroup);
			for (WebElement webElement : tenantGroupList) {
				System.out.println(webElement);
			}
			handleDropdownList(driver, tenantList, tenant);
			handleDropdownList(driver, siteList, site);
			handleDropdown(domain, domainDropdown);
			handleDropdown(deviceType, deviceTypeDropdown);
			handleDropdown(deviceRole, deviceRoleDropdown);
			managementIPAddressTextField.sendKeys(managementIpAddress);
			handleDropdown(managementIpInterface, managementIPInterfaceDropdown);
			nameTextField.sendKeys(name);
			descriptionTextField.sendKeys(description);
			handleDropdown(credentialProfile, credentialProfileDropdown);
			
		}
		
		
//		public void selectAnyCredentialSet(WebDriver driver)
//		{
//			handleDropdown("100", showDropdown);
//			credentialSetCheckBox.click();
//		}
//		
//		
//		
//		public void editRequiredDetails(WebDriver driver, String username, String password, String portNo, String timeOut)
//		{
//			usernameTextField.sendKeys(username);
//			passwordTextField.sendKeys(password);
//			portNoTextField.sendKeys(portNo);
//			timeOutTextField.sendKeys(timeOut);
//			updateSetBtn.click();
//			yesUpdateItBtn.click();
//			
//		}
//		
//		public void clickOnDeleteBtn()
//		{
//			deleteBtn.click();
//			yesDeleteItBtn.click();
//		}
}
