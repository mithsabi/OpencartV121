package pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	/*By lnkMyaccount=By.xpath("//span[normalize-space()='My Account']");
	By lnkRegister=By.xpath("//a[normalize-space()='Register']");	*/	
	public HomePage(WebDriver driver)
	{
		//
		//this.driver=driver;
		super(driver);
		
	}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	@FindBy(linkText="Login")
	WebElement linkLogin;
	
	public void  clickMyAccount()
	{
		lnkMyaccount.click();
	}
	public void  clickRegister()
	{
		lnkRegister.click();
	
	}
	public void  clickLogin()
	{
		linkLogin.click();
	
	}
}
