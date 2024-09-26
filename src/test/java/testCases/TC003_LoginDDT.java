package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProvider1;

/*Data is valid  - login success - testpass -logout
 * data is valid  -- login failed  - testfail
 * Data is invalid - login success - test fail  - logout
 * Data is invalid -- login failed  - test pass
 */

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider1.class,groups="Datadriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
logger.info("**** starting TC_003_LoginDDT *****");
		//homepage
try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		//loginpage
		LoginPage lp=new LoginPage(driver);
				lp.SetEmail(email);
				lp.SetPassword(pwd);
				lp.ClickLogin();
				//Myaccount
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targtPage=macc.isMyAccountPageExists();
				if(exp.equalsIgnoreCase("valid"))
				{
					if(targtPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(true);
						
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targtPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
}
catch(Exception e)
{
	Assert.fail();
}
				logger.info("**** finishing TC_003_LoginDDT *****");
	}

}
