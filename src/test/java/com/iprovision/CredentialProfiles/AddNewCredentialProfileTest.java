package com.iprovision.CredentialProfiles;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.CredentialProfilesPage;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;

public class AddNewCredentialProfileTest extends BaseClass {

	@Test
	public void addNewCredentialProfile() throws Exception
	{
		// Step 1 : Click on Launch button of iProvision.
		ProductPage pp = new ProductPage(driver);
		pp.clickOnIProvisionLaunchButton(driver);
		
		// Step 2 : Click on Credential Profile Module
		HomePage hp = new HomePage(driver);
		hp.clickOnCredentialProfilesBtn(driver);
		
		// Step 3 : Click on New Button
		CredentialProfilesPage cpp = new CredentialProfilesPage(driver);
		cpp.clickOnThreeHorizontalDots(driver);
		cpp.clickOnNewBtn(driver);

		// Step 4 : Enter all required details & Click on Create Set Button
		String profileName = eUtil.readDataFromExcel("Create New Credential Profile", 1, 0);
		String description = eUtil.readDataFromExcel("Create New Credential Profile", 1, 1);
		String platform = eUtil.readDataFromExcel("Create New Credential Profile", 1, 2);
		String function = eUtil.readDataFromExcel("Create New Credential Profile", 1, 3);
		String credentialSetName = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		cpp.enterAllRequiredDetails(driver, profileName, description, platform, function, credentialSetName);
		
		// Step 5 : Validate
		String message = cpp.getValidationMessage();
		System.out.println(message+" --- Credential Profile is Created Sucessfully --- ");
		cpp.selectAnyCredentialProfile(driver);
		String credentialProfileNameHeader = cpp.getCredentialProfileHeaderText();
		Assert.assertTrue(credentialProfileNameHeader.contains(profileName));
		System.out.println(" --- Credential Profile is Created Sucessfully with Name '"+credentialProfileNameHeader+"' ---");
	}
}
