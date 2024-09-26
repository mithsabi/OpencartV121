package testCases;

//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccoutRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("****** Starting TC001_AccountRegistrationTest ****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("* clicked on my account link *");
		hp.clickRegister();
		logger.info("* clicked on register link * ");
		
		AccoutRegistrationPage repage=new AccoutRegistrationPage(driver);
		logger.info("* providing customer details * ");
		repage.SetFirstName(randomeString().toUpperCase());
		repage.SetLastName(randomeString().toUpperCase());
		repage.SetEmail(randomeString()+"@gmail.com");
		repage.SetTelephone(randomeNumber());
		String password=randomeAlphaNumeric();
		repage.SetPassword(password);
		repage.SetConfirmPassword(password);
		repage.SetPrivatePolicy();
		repage.ClickContinue();
		
		logger.info("*validating expected message * ");
		String confmsg=repage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg,"Your Account Has Been Created!!!");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("****** finished TC001_AccountRegistrationTest *****");
	}
	
	}


