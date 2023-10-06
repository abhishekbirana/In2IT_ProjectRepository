package com.iprovision.CredentialProfiles;

import org.testng.annotations.Test;

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.CredentialProfilesPage;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;

public class UpdateCredentialProfileTest extends BaseClass {

	@Test
	public void updateCredentialProfile() throws Exception
	{
		// Step 1 : Click on Launch button of iProvision.
//		ProductPage pp = new ProductPage(driver);
//		pp.clickOnIProvisionLaunchButton(driver);
		
		// Step 2 : Click on Credential Profile Module
		HomePage hp = new HomePage(driver);
		hp.clickOnCredentialProfilesBtn(driver);
		
		// Step 3 : Select any Credential Set from Credential Sets List
		CredentialProfilesPage cpp = new CredentialProfilesPage(driver);
		cpp.selectAnyCredentialProfile(driver);
		
		// Step 4 : Click on Edit Button
		cpp.clickOnThreeHorizontalDots(driver);
		cpp.clickOnEditBtn(driver);
		
		// Step 5 : Edit the required details & Click on Update Profile Button
		String description = eUtil.readDataFromExcel("Create New Credential Profile", 1, 1);
		String connectionType = eUtil.readDataFromExcel("Create New Credential Profile", 1, 2);
		String credentialSetName = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		cpp.editRequiredDetails(driver, description, connectionType, credentialSetName);
		
	}
}
