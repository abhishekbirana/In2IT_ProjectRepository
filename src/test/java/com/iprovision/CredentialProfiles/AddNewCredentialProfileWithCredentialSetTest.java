package com.iprovision.CredentialProfiles;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.CredentialProfilesPage;
import com.iprovision.pageobjectrepository.CredentialSetsPage;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;

@Listeners(com.iprovision.genericutilities.ListenersImplementationClass.class)
public class AddNewCredentialProfileWithCredentialSetTest extends BaseClass {

	@Test(priority = 1)
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
		String message = csp.getValidationMessage();
		System.out.println(message+" --- Credential Set is Created Sucessfully --- ");
		csp.selectAnyCredentialSet(driver);
		String credentialSetNameHeader = csp.getCredentialSetHeaderText();
		Assert.assertTrue(credentialSetNameHeader.contains(name));
		System.out.println(" --- Credential Set is Created Sucessfully with Name '"+credentialSetNameHeader+"' ---");
	}
	
	@Test(priority = 2)
	public void updateCredentialSet() throws Exception
	{
	
		HomePage hp = new HomePage(driver);
		hp.clickOnThreeHorizontalLine(driver);
		hp.clickOnCredentialSetsBtn(driver);
		
		CredentialSetsPage csp = new CredentialSetsPage(driver);
		csp.selectAnyCredentialSet(driver);
		
		csp.clickOnThreeHorizontalDots(driver);
		csp.clickOnEditBtn(driver);
		
		String name = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		String username = eUtil.readDataFromExcel("Add New Credential Set", 1, 2) + "1";
		String password = eUtil.readDataFromExcel("Add New Credential Set", 1, 3) + "1";
		String portNo = eUtil.readDataFromExcel("Add New Credential Set", 1, 4) + "1";
		String timeOut = eUtil.readDataFromExcel("Add New Credential Set", 1, 5) + "1";
		csp.editRequiredDetails(driver, username, password, portNo, timeOut);
		
		String message = csp.getValidationMessage();
		System.out.println(message+" --- Credential Set is Updated Sucessfully --- ");
		csp.selectAnyCredentialSet(driver);
		String credentialSetNameHeader = csp.getCredentialSetHeaderText();
		Assert.assertTrue(credentialSetNameHeader.contains(name));
		System.out.println(" --- Credential Set is Updated Sucessfully which Name is '"+credentialSetNameHeader+"' ---");
	}
	
	@Test(priority = 3)
	public void addNewCredentialProfile() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnThreeHorizontalLine(driver);
		hp.clickOnCredentialProfilesBtn(driver);
		
		CredentialProfilesPage cpp = new CredentialProfilesPage(driver);
		cpp.clickOnThreeHorizontalDots(driver);
		cpp.clickOnNewBtn(driver);

		String profileName = eUtil.readDataFromExcel("Create New Credential Profile", 1, 0);
		String description = eUtil.readDataFromExcel("Create New Credential Profile", 1, 1);
		String platform = eUtil.readDataFromExcel("Create New Credential Profile", 1, 2);
		String function = eUtil.readDataFromExcel("Create New Credential Profile", 1, 3);
		String credentialSetName = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		cpp.enterAllRequiredDetails(driver, profileName, description, platform, function, credentialSetName);
		
		String message = cpp.getValidationMessage();
		System.out.println(message+" --- Credential Profile is Created Sucessfully --- ");
		cpp.selectAnyCredentialProfile(driver);
		String credentialProfileNameHeader = cpp.getCredentialProfileHeaderText();
		Assert.assertTrue(credentialProfileNameHeader.contains(profileName));
		System.out.println(" --- Credential Profile is Created Sucessfully with Name '"+credentialProfileNameHeader+"' ---");
	}
	
	@Test(priority = 4)
	public void updateCredentialProfile() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnThreeHorizontalLine(driver);
		hp.clickOnCredentialProfilesBtn(driver);
		
		CredentialProfilesPage cpp = new CredentialProfilesPage(driver);
		cpp.selectAnyCredentialProfile(driver);
		
		cpp.clickOnThreeHorizontalDots(driver);
		cpp.clickOnEditBtn(driver);
		
		String profileName = eUtil.readDataFromExcel("Create New Credential Profile", 1, 0);
		String description = eUtil.readDataFromExcel("Create New Credential Profile", 1, 1);
		String platform = eUtil.readDataFromExcel("Create New Credential Profile", 1, 2);
		String function = eUtil.readDataFromExcel("Create New Credential Profile", 1, 3);
		String credentialSetName = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		cpp.editRequiredDetails(driver, description, platform, function, credentialSetName);
		
		String message = cpp.getValidationMessage();
		System.out.println(message+" --- Credential Profile is Updated Sucessfully --- ");
		cpp.selectAnyCredentialProfile(driver);
		String credentialProfileNameHeader = cpp.getCredentialProfileHeaderText();
		Assert.assertTrue(credentialProfileNameHeader.contains(profileName));
		System.out.println(" --- Credential Profile is Updated Sucessfully which Name is '"+credentialProfileNameHeader+"' ---");
	}
	
	@Test(priority = 5)
	public void deleteCredentialProfile() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnThreeHorizontalLine(driver);
		hp.clickOnCredentialProfilesBtn(driver);
		
		CredentialProfilesPage cpp = new CredentialProfilesPage(driver);
		cpp.selectAnyCredentialProfile(driver);
		
		cpp.clickOnThreeHorizontalDots(driver);
		cpp.clickOnDeleteBtn(driver);
		
		String message = cpp.getValidationMessage();
		
		String profileName = eUtil.readDataFromExcel("Create New Credential Profile", 1, 0);
		int randomNum = jUtil.getRandomNumber();
		eUtil.writeDataIntoExistingExcelSheet("Create New Credential Profile", 1, 0, profileName , randomNum);
		
		System.out.println(message+" --- Credential Profile is Deleted Sucessfully --- ");
		System.out.println(" --- Credential Profile is Deleted Sucessfully which Name was '"+profileName+"' ---");
	}
	
	@Test(priority = 6)
	public void deleteCredentialSet() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnThreeHorizontalLine(driver);
		hp.clickOnCredentialSetsBtn(driver);
		
		CredentialSetsPage csp = new CredentialSetsPage(driver);
		csp.selectAnyCredentialSet(driver);
		
		csp.clickOnThreeHorizontalDots(driver);
		csp.clickOnDeleteBtn(driver);
		
		String name = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		int randomNum = jUtil.getRandomNumber();
		eUtil.writeDataIntoExistingExcelSheet("Add New Credential Set", 1, 1, name , randomNum);
		
		String message = csp.getValidationMessage();
//		String name = eUtil.readDataFromExcel("Add New Credential Set", 1, 1);
		System.out.println(message+" --- Credential Profile is Deleted Sucessfully --- ");
		System.out.println(" --- Credential Set is Deleted Sucessfully which Name was '"+name+"' ---");

	}
	
}
