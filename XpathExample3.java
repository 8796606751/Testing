package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XpathExample3 
{

	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test");
	}
	
	@Test
	public void CheckLastMonthSavings()
	{
		D.switchTo().frame("iframeResult");
		WebElement SavingsElement=D.findElement(By.xpath("//table//tr[last()]/td[2]"));
		String Savings=SavingsElement.getText();
		Assert.assertEquals(Savings, "$80");
	}

}
