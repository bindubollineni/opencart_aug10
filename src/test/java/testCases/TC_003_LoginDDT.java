package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)

	public void testLoginDDT(String email,String password,String result)
	{

		logger.info("TC_003_LoginDDT Started");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked My Account");

			hp.ClickLogin();

			logger.info("Clicked Login");

			LoginPage lp = new LoginPage(driver);

			lp.sendLoginEmail(email);
			logger.info("Email id is entered");

			lp.sendLoginPassword(password);

			logger.info("Password is entered");

			lp.clickLoginBtn();
			logger.info("Clicked Login Button");

			MyAccountPage ap = new MyAccountPage(driver);

			boolean status = ap.isMyAccountPageExists();
			System.out.println(status);
		//	Assert.assertEquals(ap.getTitle(), "My Account");


			if(result.equals("Passed"))
			{
				if(status==true)
				{
					ap.clickLogout();
					AssertJUnit.assertTrue(true);
				}
				else
				{
					Assert.fail();
				}
			}
			else	if(result.equals("Failed"))
			{
				if(status==true)
				{
					ap.clickLogout();

					AssertJUnit.assertTrue(false);
				}
				else
				{
					AssertJUnit.assertTrue(true);
				}
			}
		} 
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("TC_003_LoginDDT is finished");
	}



}
