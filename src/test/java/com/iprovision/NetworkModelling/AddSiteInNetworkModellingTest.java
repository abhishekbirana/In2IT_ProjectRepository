package com.iprovision.NetworkModelling;

import org.testng.annotations.Test;

import com.iprovision.genericutilities.BaseClass;
import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.ProductPage;
import com.iprovision.pageobjectrepository.SitesPage;

public class AddSiteInNetworkModellingTest extends BaseClass {


	@Test
	public void addNewSite() throws Exception
	{
		ProductPage pp = new ProductPage(driver);
		pp.clickOnIProvisionLaunchButton(driver);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnNetworkModellingBtn(driver);
		hp.clickOnSitesBtn(driver);
		
		SitesPage sp = new SitesPage(driver);
		sp.clickOnThreeHorizontalDots(driver);
		sp.clickOnAddSingleSite(driver);
		
		System.out.println("addNewSite Completed");
		
	}

}
