package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CheckElementExistence 
{

	ChromeDriver D;
	@BeforeClass
	public void StartBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D=new ChromeDriver();
		D.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@Test
	public void CheckIfWeGetError()
	{
		WebElement PasswordField=D.findElement(By.name("password"));
		PasswordField.sendKeys("admin123");
		
		WebElement LoginButton=D.findElement(By.cssSelector("button[type='submit']"));
		LoginButton.click();
		
		List<WebElement>Elements=D.findElements(By.xpath("//input[@name='username']/parent::div/following-sibling::span"));
		int size=Elements.size();
		Assert.assertEquals(size, 1);
	}
	
}
