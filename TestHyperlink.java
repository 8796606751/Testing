package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestHyperlink {
	
/*
 * 1. Open browser
 * 2. Open URL
 * 3. Click on SIGN IN hyperlink
 * 4. Check that Login page is opened.
 * 
 */
	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D= new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}
	@Test(priority=1)
	public void TestSignInLink()
	{
		/*
		 * Hyperlink is a control which is designed using <a></a> tag(anchor tag).
		 * Hyperlinks always have UNIQUE hyperlink text.
		 * To identify a hyperlink control we can use its text as it is always unique.
		 * By.linkText is a stratergy specially made available to be used to identify
		 * hyperlink controls using their text
		 */
		//Below statement will find an element using hyperlink text
		WebElement SignInLink=D.findElement(By.linkText("SIGN IN"));
		SignInLink.click();
		//getTitle returns a title of a page
		String PageTitle=D.getTitle();
		Assert.assertEquals(PageTitle, "Login");
		
	}
	
	@Test(priority=2)
	public void TestHomeLink()
	{
		WebElement HomeLink=D.findElement(By.linkText("HOME"));
		HomeLink.click();
		
		String PageTitle=D.getTitle();
		Assert.assertEquals(PageTitle, "Home Page");
	}
}
