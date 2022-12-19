package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckLoginWithInvalidCredentials {

	ChromeDriver D;
	@BeforeClass
	public void OpenBrowserAndEnterURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D=new ChromeDriver();
		D.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void TestLoginWithValidData()
	{
		WebElement UserNameField=D.findElement(By.name("username"));
		UserNameField.sendKeys("");
		
		WebElement PasswordField=D.findElement(By.name("password"));
		PasswordField.sendKeys("admin123");
		
		WebElement LoginButton=D.findElement(By.cssSelector("button[type='submit']"));
		LoginButton.click();
		
		String PageURL=D.getCurrentUrl();
		Assert.assertEquals(PageURL, "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
	}

}
