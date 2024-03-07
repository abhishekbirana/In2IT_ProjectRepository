package com.iprovision.genericutilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.iprovision.pageobjectrepository.HomePage;
import com.iprovision.pageobjectrepository.LoginPage;
import com.iprovision.pageobjectrepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

/**
 * This class consists of all Basic Configuration Annotations
 * @author abhishek.birana
 *
 */
public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	
	public WebDriver driver = null;
	public static WebDriver sDriver;
	
	
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println(" =====> Database Connection Successful <===== ");
	}
	
//	@Parameters("browser")   //-->It is used in case of parallel execution.
	@BeforeTest   //-->It is used in case of parallel execution. executed before the test block present in testng.xml file
//	@BeforeClass(alwaysRun = true)  //(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
            //option.addArguments("--remote-allow-origins=*");
            option.addArguments("--incognito");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
			
			System.out.println("=====> "+BROWSER+" Browser launch successful <===== ");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--remote-allow-origins=*");
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(option);
			
			System.out.println("=====> "+BROWSER+" Browser launch successful <===== ");
		}
		
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			System.out.println("=====> "+BROWSER+" Browser launch successful <===== ");
		}
		
		else if(BROWSER.equalsIgnoreCase("Opera"))
		{
			WebDriverManager.operadriver().setup();
			System.out.println("=====> "+BROWSER+" Browser launch successful <===== ");
		}
		
		else
		{
			System.out.println("Invalid Browser Name in property file");
		}
		
		sDriver=driver; // take screen shot
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	@BeforeClass
//	@BeforeMethod(alwaysRun = true)  //(groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
	    String USERID = pUtil.readDatafromPropertyFile("userid");
	    String PASSWORD = pUtil.readDatafromPropertyFile("password");
	    
	    LoginPage lp = new LoginPage(driver);
	    lp.loginToApp(USERID, PASSWORD);
	    
	    System.out.println(" =====> Login is Successful <===== ");
	    
	    String parentId = driver.getWindowHandle();
		eUtil.writeParentIdIntoExistingExcelSheet("WindowsTabsId", 1, 0, parentId);
	}
	

	@AfterClass
//	@AfterMethod(alwaysRun = true)	//(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig() throws Exception
	{
		ProductPage pp = new ProductPage(driver);
		HomePage hp = new HomePage(driver);
		String parentId = eUtil.readDataFromExcel("WindowsTabsId", 1, 0);
		hp.goBackToParentTab(driver , parentId);
		pp.logOutOfApp(driver);
		System.out.println(" =====> Logout is Successful <===== ");
		
	}
	
	@AfterTest   //-->It is used in case of parallel execution. executed after the test block present in testng.xml file
//	@AfterClass(alwaysRun = true)		//(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		System.out.println(" =====> browser closed Successfully <===== ");
		
		
	}
	
	@AfterSuite(alwaysRun = true)		//(groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig() throws IOException
	{
		
//		SendMailWithAttachment smwa = new SendMailWithAttachment();
//		smwa.sendingEmail("abhishek.birana@in2ittech.com","sagar.mehra@in2ittech.com","This email sent using JavaMailer API from Automation Testing!!!","Testing Report by Abhishek Birana");
		System.out.println(" =====> Database closed Successfully <===== ");
	}
	
	
	
	

	
}
