package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass (groups= {"Master","Regression","Sanity"})
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();

		} 
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Master","Regression","Sanity"})
	public void tearDown() 
	{ 
		driver.quit(); 
	}

	public String randomString()
	{
		String randomEmail = RandomStringUtils.randomAlphabetic(6);
		return randomEmail;
	}

	public String randomNumber()
	{
		String randomNumber = RandomStringUtils.randomNumeric(6);
		return randomNumber;
	}

	public String randomAlphaNumberic()
	{
		String st = RandomStringUtils.randomAlphanumeric(4);

		String num = RandomStringUtils.randomNumeric(3);
		return (st+"@"+num);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";
		System.out.println(System.getProperty("user.dir"));
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

	public void validatePageIsLoaded(String actual,String expected)
	{
		try
		{
			Assert.assertEquals(actual, expected);
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}

	}

	public void testMenuItems( List<WebElement> actual,List<String> expected)
	{
		for(WebElement sl : actual)
			for(int i=0;i<expected.size();i++)
			{
				if(sl.getText().equals(expected.get(i))) 
				{
					Assert.assertTrue(true, "Menu items Matched");   
				}
			}
	
	}

}
