package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XpathExample2 {
/*
 * 1. Open browser
 * 2. Open URL "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro"
 * 3. Find an element showing country of "Island trading" company
 * 4. Get the text from that element
 * 5. Check that it is "UK"
 */
	
	ChromeDriver D;
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");

	}
	
	@Test
	public void TestCountryName()
	{
		D.switchTo().frame("iframeResult");
		/*
		 * //table//td[text()='Island Trading']/following-sibling::td[2]
		*/
		
		 WebElement CountryElement=D.findElement(By.xpath("//table//td[text()='Island Trading']/following-sibling::td[2]"));
		 String CountryName=CountryElement.getText();
		 Assert.assertEquals(CountryName, "UK");
	}
}
