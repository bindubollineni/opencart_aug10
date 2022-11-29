package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_005_TestMenuItems extends BaseClass {

	@Test
	public void testMenuItems()
	{
		logger.info("TC_005_TestMenuItems Started");
		
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.click_Desktop();
		logger.info("Clicked Desktop link ");
		List<String> expected_Desktop = new ArrayList<String>();
		expected_Desktop.add("PC (0)");
		expected_Desktop.add("Mac (1)");
		expected_Desktop.add("Show All Desktops");

		/*
		 * hp.testDesktopMenuItems(expected_Desktop);
		 * logger.info("Validated Desktop all Sub Menu Items ");
		 */	
		testMenuItems(hp.desktopList(),expected_Desktop);
		logger.info("Validated Desktop all Sub Menu Items ");
		hp.click_ShowAllDesktop();
		
		logger.info("Clicked Show All Desktop");
		}
		catch(Exception e)
		{
			logger.info("TC_005_TestMenuItems Failed ");
			
			Assert.fail();
		}
		
		
		logger.info("TC_005_TestMenuItems Finished");
		
	}
}
