package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_004_ValidateHomePageFooterLinks extends BaseClass
{

	@Test(groups= {"Master"})
	public void ValidateHomePageFooterLinks()
	{
		logger.info("TC_004_ValidateHomePageFooterLinks Started");
		try
		{

			HomePage hp = new HomePage(driver);
			
			validatePageIsLoaded(hp.validatelinkAboutUs(),"About Us");
			logger.info("About Us link Verified");
			
			validatePageIsLoaded(hp.validatelinkDeliveryInformation(),"Delivery Information");
			logger.info("Delivery Information link Verified");

			validatePageIsLoaded(hp.validatelinkPrivacyPolicy(),"Privacy Policy");
			logger.info("Privacy Policy link Verified");

			validatePageIsLoaded(hp.validatelinkTermsConditions(),"Terms & Conditions");
			logger.info("Terms &Conditions link Verified");

			validatePageIsLoaded(hp.validatelinkContactUs(),"Contact Us");
			logger.info("ContactUs link Verified");

			validatePageIsLoaded(hp.validatelinkReturns(),"Product Returns");
			logger.info("Product Returns link Verified");

			validatePageIsLoaded(hp.validatelinkSiteMap(),"Site Map");
			logger.info("SiteMap link Verified");

			validatePageIsLoaded(hp.validatelinkBrands(),"Find Your Favorite Brand");
			logger.info("Brands link Verified");

			validatePageIsLoaded(hp.validatelinkGiftCertificates(),"Purchase a Gift Certificate");
			logger.info("GiftCertificates link Verified");

			validatePageIsLoaded(hp.validatelinkAffiliate(),"Affiliate Program");
			logger.info("Affliate link Verified");

			validatePageIsLoaded(hp.validatelinkSpecials(),"Special Offers");
			logger.info("Specials Offers link Verified");

			validatePageIsLoaded(hp.validatelinkMyAccount(),"Account Login");
			logger.info("Account Login link Verified");

			validatePageIsLoaded(hp.validatelinkOrderHistory(),"Account Login");
			logger.info("Order History link Verified");

			validatePageIsLoaded(hp.validatelinkWishList(),"Account Login");
			logger.info("WishList link Verified");

			validatePageIsLoaded(hp.validatelinkNewsletter(),"Account Login");
			logger.info("NewsLetter link Verified");

		}
		catch(Exception e)
		{
			Assert.fail();
		}


	}




}
