package com.iprovision.Device;

import org.testng.annotations.Test;

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.DevicePage;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;

public class AddNewDeviceTest extends BaseClass {

	@Test
	public void addNewDevice() throws Exception
	{
		
		// Step 1 : Click on Launch button of iProvision.
		ProductPage pp = new ProductPage(driver);
		pp.clickOnIProvisionLaunchButton(driver);
		
		// Step 2 : Click on Device Module
		HomePage hp = new HomePage(driver);
		hp.clickOnDeviceBtn(driver);
		
		// Step 3 : Click on New Button
		DevicePage dp = new DevicePage(driver);
		dp.clickOnThreeHorizontalDots(driver);
		dp.clickOnNewBtn(driver);
		
		// Step 4 : Add New Device - Select Method
		dp.clickOnAddSingleBtn(driver);
		dp.clickOnNextBtn1();
		
		// Step 5 : Enter all required details
		String tenantGroup = eUtil.readDataFromExcel("Add New Device", 1, 0);
		String tenant = eUtil.readDataFromExcel("Add New Device", 1, 1);
		String site = eUtil.readDataFromExcel("Add New Device", 1, 2);
		String domain = eUtil.readDataFromExcel("Add New Device", 1, 3);
		String deviceType = eUtil.readDataFromExcel("Add New Device", 1, 4);
		String deviceRole = eUtil.readDataFromExcel("Add New Device", 1, 5);
		String managementIpAddress = eUtil.readDataFromExcel("Add New Device", 1, 6);
		String managementIpInterface = eUtil.readDataFromExcel("Add New Device", 1, 7);
		String name = eUtil.readDataFromExcel("Add New Device", 1, 8);
		String description = eUtil.readDataFromExcel("Add New Device", 1, 9);
		String credentialProfile = eUtil.readDataFromExcel("Create New Credential Profile", 1, 0);
		dp.enterAllRequiredDetails(driver, tenantGroup, tenant, site, domain, deviceType, deviceRole, managementIpAddress, managementIpInterface, name, description, credentialProfile);
		dp.clickOnNextBtn2();
		
		// Step 6 : 
	}
}
