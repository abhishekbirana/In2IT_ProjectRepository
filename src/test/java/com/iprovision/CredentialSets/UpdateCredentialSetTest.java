package com.iprovision.CredentialSets;

import org.testng.annotations.Test;

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.CredentialSetsPage;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;

public class UpdateCredentialSetTest extends BaseClass {

	@Test
	public void updateCredentialSet() throws Exception
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
		
		// Step 4 : Click on Edit Button
		csp.clickOnThreeHorizontalDots(driver);
		csp.clickOnEditBtn(driver);
		
		// Step 5 : Edit the required details & Click on Update Set Button
		String name = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		String username = eUtil.readDataFromExcel("Add New Credential Set", 1, 2) + "1";
		String password = eUtil.readDataFromExcel("Add New Credential Set", 1, 3) + "1";
		String portNo = eUtil.readDataFromExcel("Add New Credential Set", 1, 4) + "1";
		String timeOut = eUtil.readDataFromExcel("Add New Credential Set", 1, 5) + "1";
		csp.editRequiredDetails(driver, username, password, portNo, timeOut);
		System.out.println(name+"--- Credential Set is Updated Sucessfully ---");
	}
}
