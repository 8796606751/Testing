package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckConfrimationMessage 
{

	/*
	 * Pre-requisite: 
	 * 1. Open browser
	 * 2. Open URL
	 * 
	 * Testcase:
	 * 1. Enter "Pranoday" in name field
	 * 2. Click on Confirm button
	 * 3. Read the message from confirmation box
	 * 4. Check that entered name is present in confirmation message
	 */
	
	ChromeDriver D;
	@BeforeClass
	public void OpenBrowserAndURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}
	
	@Test
	public void CheckConfirmationMessage()
	{
		WebElement NameField=D.findElement(By.id("name"));
		NameField.sendKeys("Monika");
		
		String TypedName=NameField.getAttribute("value");
		
		WebElement ConfirmButton=D.findElement(By.id("confirmbtn"));
		ConfirmButton.click();
		Alert Al=D.switchTo().alert();
		String ConfirmMessage=Al.getText();
		boolean IsNamePresent=ConfirmMessage.contains(TypedName);
		Assert.assertEquals(IsNamePresent, true);
		//Following statement clicks on Cancel button of alert box
		Al.dismiss();
	}
}
