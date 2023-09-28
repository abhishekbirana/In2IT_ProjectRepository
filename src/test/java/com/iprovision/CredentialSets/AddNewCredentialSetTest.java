package com.iprovision.CredentialSets;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test; 

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.CredentialSetsPage;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;


public class AddNewCredentialSetTest extends BaseClass {
	
		
	@Test //(groups = "SmokeSuite")
	public void addNewCredentialSet() throws Exception
	{
		// Step 1 : Click on Launch button of iProvision.
		ProductPage pp = new ProductPage(driver);
		pp.clickOnIProvisionLaunchButton(driver);
		
		// Step 2 : Click on Credential Sets Module
		HomePage hp = new HomePage(driver);
		hp.clickOnCredentialSetsBtn(driver);
		
		// Step 3 : Click on New Button
		CredentialSetsPage csp = new CredentialSetsPage(driver);
		csp.clickOnThreeHorizontalDots(driver);
		csp.clickOnNewBtn(driver);
		
		// Step 4 : Enter all required details & Click on Create Set Button
		String transType = eUtil.readDataFromExcel("Add New Credential Set", 1, 0);
		String name = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		String username = eUtil.readDataFromExcel("Add New Credential Set", 1, 2);
		String password = eUtil.readDataFromExcel("Add New Credential Set", 1, 3);
		String portNo = eUtil.readDataFromExcel("Add New Credential Set", 1, 4);
		String timeOut = eUtil.readDataFromExcel("Add New Credential Set", 1, 5);
		csp.enterAllRequiredDetails(driver, transType, name, username, password, portNo, timeOut);
		
		// Step 5 : Validate
		System.out.println("Hiii");
		String message = csp.getValidationMessage();
		System.out.println(message+" --- Credential Set is Created Sucessfully --- ");
		csp.selectAnyCredentialSet(driver);
		String credentialSetNameHeader = csp.getCredentialSetHeaderText();
		Assert.assertTrue(credentialSetNameHeader.contains(name));
		System.out.println(" --- Credential Set is Created Sucessfully with Name '"+credentialSetNameHeader+"' ---");
		
	}

}
