package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExplicitWait 
{
	ChromeDriver D;

	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test
	public void DoLogin() throws InterruptedException
	{
		WebElement UserNameField=D.findElement(By.name("username"));
		UserNameField.sendKeys("Admin");
		
		WebElement PasswordField=D.findElement(By.name("password"));
		PasswordField.sendKeys("admin123");
		
		WebElement LoginButton=D.findElement(By.cssSelector("button[type='submit']"));
		/*
		 * We need to ask script to wait here until a button gets enabled.
		 * We can use Thread.sleep(5000) but here if a button gets enabled within 2 secs
		 * then we will waste 3 secs of our execution time because script will pause for
		 * 5 secs even if it is not required to wait for entire 5 secs
		 */
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(D,Duration.ofSeconds(20));
		/*
		 * Following statement will ask driver to wait until a given condition gets satisfied.
		 * wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		 * 
		 * Following statement defines maximum time a driver will wait for a condition to be
		 * satisfied. While waiting for a condition to be satisfied dirver will keep
		 * checking for a condition after certain interval.And as soon as a condition is
		 * found satisfied script will move ahead. 
		 * If a condion is not found satisfied even if driver has waited for an entire timeout
		 * period then driver gives TimeOutException
		 * WebDriverWait wait=new WebDriverWait(D,Duration.ofSeconds(20));
		 * 
		 */
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		LoginButton.click();
		
	}
}
