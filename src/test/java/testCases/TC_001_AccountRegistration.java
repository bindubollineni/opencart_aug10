package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{


	@Test(groups= {"Master","Regression"})
	
	public void test_RegisterAccount() throws InterruptedException
	{
		logger.info("test_RegisterAccount is started");

		try
		{
			logger.info("Clicked MyAccount");

			JavascriptExecutor js = (JavascriptExecutor)driver;

			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("Clicked MyAccount");
			hp.clickRegister();
			logger.info("Clicked Register");

			RegisterAccountPage rp = new RegisterAccountPage(driver);

			rp.setFirstName(randomString().toUpperCase());
			rp.setLastName(randomString().toUpperCase());
			rp.setEmail(randomString()+"@gmail.com");
			rp.setTelephone(randomNumber()); String password =randomAlphaNumberic();
			rp.setPassword(password);
			rp.setConfirmPassword(password);

			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");


			rp.setPrivacyPolicy(); 
			rp.clickContinue(); 
			logger.info("Clicked Continue Button");

			String actual_Msg = rp.getConfirmationMsg(); 
			System.out.println(actual_Msg);
			AssertJUnit.assertEquals(actual_Msg,
					"Congratulations! Your new account has been successfully created!");
			logger.info("Validated Confirmation Message once the registrations is done");

		} 
		catch(Exception e)
		{ 
			Assert.fail();
			logger.error("Test Failed");

		}


	}







}
