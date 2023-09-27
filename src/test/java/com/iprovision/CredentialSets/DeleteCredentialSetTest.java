package com.iprovision.CredentialSets;

import org.testng.annotations.Test;

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.CredentialSetsPage;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;

public class DeleteCredentialSetTest extends BaseClass {

	@Test
	public void deleteNewCredentialSet() throws Exception
	{
		// Step 1 : Click on Launch button of iProvision.
		ProductPage pp = new ProductPage(driver);
		pp.clickOnIProvisionLaunchButton(driver);
		
		// Step 2 : Click on Credential Sets Module
		HomePage hp = new HomePage(driver);
		hp.clickOnCredentialSetsBtn(driver);
		
		// Step 3 : Select any Credential Set from Credential Sets List
		CredentialSetsPage csp = new CredentialSetsPage(driver);
		csp.selectAnyCredentialSet(driver);
		
		// Step 4 : Click on Delete Button
		csp.clickOnThreeHorizontalDots(driver);
		csp.clickOnDeleteBtn(driver);
		String name = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		System.out.println(name+"--- Credential Set is Deleted Sucessfully ---");
		
	}
}
