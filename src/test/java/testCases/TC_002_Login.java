package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass{
	@Test(groups= {"Master","Sanity"})
	public void testLoginPage()
	{
		logger.info("TC_002_Login Started");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked MyAccount");
		
		hp.ClickLogin();
		logger.info("Clicked Login Btn");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.sendLoginEmail(rb.getString("email"));
		logger.info("Input Email id to Login");
		
		lp.sendLoginPassword(rb.getString("password"));
		logger.info("Input password to Login");
		
		lp.clickLoginBtn();
		logger.info("Clicked Login Button");
		
		MyAccountPage ap = new MyAccountPage(driver);
		
		AssertJUnit.assertEquals(ap.getTitle(), "My Account");
		logger.info("Title Validated");
		
		ap.clickLogout();
		
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.error("TC_002_Login Failed");
			
		}
		
		logger.info("TC_002_Login Finished");
		
	}

}
