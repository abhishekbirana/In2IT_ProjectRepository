package com.iprovision.CredentialProfiles;

import org.testng.annotations.Test;

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.CredentialProfilesPage;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;

public class DeleteCredentialProfileTest extends BaseClass {

	@Test
	public void deleteNewCredentialProfile() throws Exception
	{
		// Step 1 : Click on Launch button of iProvision.
		ProductPage pp = new ProductPage(driver);
		pp.clickOnIProvisionLaunchButton(driver);
		
		// Step 2 : Click on Credential Profile Module
		HomePage hp = new HomePage(driver);
		hp.clickOnCredentialProfilesBtn(driver);
		
		// Step 3 : Select any Credential Profile from Credential Profiles List
		CredentialProfilesPage csp = new CredentialProfilesPage(driver);
		csp.selectAnyCredentialProfile(driver);
		
		// Step 4 : Click on Delete Button
		csp.clickOnThreeHorizontalDots(driver);
		csp.clickOnDeleteBtn(driver);
		String name = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		System.out.println(name+"--- Credential Set is Deleted Sucessfully ---");
		
	}
}
