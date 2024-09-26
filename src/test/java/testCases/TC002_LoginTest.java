package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("*** starting TC_002_LoginTest ***");
		try {
			
		
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		//loginpage
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(p.getProperty("email"));
		lp.SetPassword(p.getProperty("password"));
				lp.ClickLogin();
				//Myaccount
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targtPage=macc.isMyAccountPageExists();
				//Assert.assertEquals(targtPage, true,"Login failed");
				Assert.assertTrue(targtPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
				
				logger.info("*** Finished TC_002_LoginTest****");
	}

}
