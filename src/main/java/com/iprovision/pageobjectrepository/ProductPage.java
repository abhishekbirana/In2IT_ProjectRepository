package com.iprovision.pageobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iprovision.genericutilities.WebDriverUtility;
/**
 * @author abhishek.birana
 */
public class ProductPage extends WebDriverUtility {

	
	@FindBy(xpath = "//h4[text()='iProvision']/../../../div[2]/div[2]/button")
	private WebElement iProvisionLaunchBtn;
	
	@FindBy(xpath = "//h4[text()='iProcess']/../../../div[2]/div[2]/button")
	private WebElement iProcessLaunchBtn;
	
	@FindBy(xpath = "//span[text()='Abhishek Birana']")
	private WebElement abhishekBiranaBtn;
	
	@FindBy(xpath = "//span[@class='signout']")
	private WebElement signOutBtn;
	
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will click on Launch Button of iProvision
	 * @param driver
	 */
	public void clickOnIProvisionLaunchButton(WebDriver driver)
	{
		iProvisionLaunchBtn.click();
	}
	/**
	 * This method will click on Launch Button of iProvision
	 * @param driver
	 */
	public void clickOnIProcessLaunchButton(WebDriver driver)
	{
		iProcessLaunchBtn.click();
	}
	
	
	/**
	 * This method will perform sign out operation
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver)
	{
		jsclick(driver, abhishekBiranaBtn);
		signOutBtn.click();
	}
	
}
