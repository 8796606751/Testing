package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class VesitTestCase 
{

	ChromeDriver D;

	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		D.get("https://vesit.ves.ac.in/");
		
	}

	@Test
	public void SelectDropdownOption()
	{
		WebElement ClosePopup=D.findElement(By.id("closepop"));
		ClosePopup.click();
		WebElement KnowYourCollege=D.findElement(By.id("navbarDropdown"));
		KnowYourCollege.click();
		
		WebElement GalaryLink=D.findElement(By.linkText("Gallery"));
		GalaryLink.click();
	}
}
