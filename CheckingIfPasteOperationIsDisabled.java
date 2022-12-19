package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckingIfPasteOperationIsDisabled 
{

	/* Title: Check that paste opetation is disabled on Password field
	 * Pre-requisites:
	 * 1. Open browser
	 * 2. Open URL "https://opensource-demo.orangehrmlive.com/"
	 * 3. Enter "Pranoday" in UserName field
	 * 4. Press Ctrl+a to do Select All
	 * 5. Press Ctrl+c to copy selected value
	 * 6. Park on Password field
	 * 7. Press Ctrl+v to paste copied value
	 * Check that Password field should remain blank
	 */
	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void TestIfPasteOperationIsDisabledOnPasswordField()
	{
		WebElement UserNameField=D.findElement(By.id("txtUsername"));
		UserNameField.sendKeys("Pranoday");
		
		/*
		 * We want to select a value entered in UserName field using Ctrl+a
		 * Following 3 events we need to perform to do Ctrl+a
		 * 1. Press & hold Ctrl key
		 * 2. Type letter 'a'
		 * 3. Release Ctrl key
		 */
		/*
		 * To perform Ctrl+a we need to build a chain of 3 events
		 * 1. Press Ctrl key ->   Act.keyDown()
		 * 2. Type letter 'a' -> sendKeys('a')
		 * 3. Release Ctrl key
		 */
		Actions Act=new Actions(D);
		/*
		 * Following statement builds a chain of 3 events and perform it.
		 * Events from a chain gets performed from LEFT to RIGHT
		 */
		Act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		/*
		 * To do a Ctrl+c we need to build a CHAIN of following events
		 * 1. Press & Hold Ctrl key
		 * 2. Type letter 'c'
		 * 3. Release Ctrl key
		 * 
		 * 
		 */
		Act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		WebElement PasswordField=D.findElement(By.id("txtPassword"));
		//Below line will click on Password field and take the cursor to it
		PasswordField.click();
		/*
		 * To do a Ctrl+v we need to build a CHAIN of following events:
		 * 1. Press&Hold Ctrl key
		 * 2. Type letter 'v'
		 * 3. Release Ctrl key
		 */
		Act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		String PastedValue=PasswordField.getAttribute("value");
		Assert.assertEquals(PastedValue, "");
		
	}
}
