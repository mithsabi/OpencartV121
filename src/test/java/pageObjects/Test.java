package pageObjects;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://tutorialsninja.com/demo/");
driver.manage().window().maximize();

driver.findElement(By.xpath("//a[@title='My Account']")).click();
driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("rag.sailakshmi@gmail.com");
driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Murali@123");
driver.findElement(By.xpath("//input[@value='Login']")).click();
driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
//driver.quit();
System.out.println("test passed");

	}

}
