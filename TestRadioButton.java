package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRadioButton {

	/*
	 * Pre-requisite:
	 * 1. Open browser
	 * 2. Open URL
	 * 
	 *  Testcase 1:
	 *  1. Identify BMW radio control
	 *  2. Click on that
	 *  3. Check that it is SELECTED
	 */
	
	
	ChromeDriver D;
	@BeforeClass
	public void OpenBrowserAndURL()
	{
	
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D=new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}

	@Test(priority=1)
	public void TestRadioIsSelected()
	{
		//Following statement will find radio control and return it
		WebElement BMWRadio=D.findElement(By.id("bmwradio"));
		BMWRadio.click();
		boolean IsRadioButtonSelected=BMWRadio.isSelected();
		/*
		 * After clicking on a radio control it should get selected and hence variable
		 * IsRadioButtonSelected should have value true
		 */
	   Assert.assertEquals(IsRadioButtonSelected, true);
	}
	
	@Test(priority=2)
	public void TestIfSingleRadioIsSelected()
	{
		WebElement BenzRadio=D.findElement(By.id("benzradio"));
		BenzRadio.click();
		boolean IsBenzRadioSelected=BenzRadio.isSelected();
		
		WebElement BMWRadio=D.findElement(By.id("bmwradio"));
		boolean IsBMWSelected=BMWRadio.isSelected();
		
		Assert.assertEquals(IsBenzRadioSelected, true);
		Assert.assertEquals(IsBMWSelected, false);
	}
}
