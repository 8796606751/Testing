package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RobotClass 
{

	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_html_file_upload_button");

	}

	@Test
	public void TestUploadFile() throws AWTException, InterruptedException
	{
		D.switchTo().frame("iframeResult");
		WebElement FileUploadButton=D.findElement(By.id("myFile"));
		//FileUploadButton.click();
		//D.executeScript("arguments[0].focus().trigger('click');", FileUploadButton);
		Actions Act=new Actions(D);
		Act.moveToElement(FileUploadButton, 50, 10).click().perform();		
		Thread.sleep(3000);
		/*
		 * If we want to work on NATIVE window then we can not use Selenium methods.
		 */
		Robot R = new Robot();
		//D:\pd.txt and then enter
		R.keyPress(KeyEvent.VK_SHIFT);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_D);
		Thread.sleep(1000);
		R.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_SHIFT);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_SEMICOLON);
		Thread.sleep(1000);
		R.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_BACK_SLASH);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_P);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_D);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_PERIOD); // it is '.'
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_T);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_X);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_T);
		Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_ENTER);
	}
	
}
