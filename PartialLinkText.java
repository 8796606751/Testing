package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class PartialLinkText 
{

ChromeDriver D;
	
	@BeforeClass
	public void OpenURLAndBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_links_w3schools");
	}

	
	public void TestLink()
	{
		
		/*
		 * If a linktext of a hyperlink is constant then we can use By.linkText()
		 * BUT if text of hyperlink is varying. E.g. We have a page showing link with text 
		 * "Welcome <USerName>" then in this case if a user named "Pranoday" will login then
		 * welcome link text would be "Welcome Pranoday" but if user named "Abhijeet" will
		 * login then welcome link text would be "Welcome Abhijeet". Here entire link text
		 * is not remaining as constant. Only work Welcome is constant and rest of the part of
		 * that text is always changing. In this case if we want to identify such hyperlink
		 * using its text, we can not use By.linkText().
		 * We can use By.partialLinkText("Welcome")
		 * PartiallinkText finds the link having a particular text present in it
		 */
	
			D.switchTo().frame("iframeResult");
			/*
			 * In our page linktext of a hyperlink is not static, it changes everytime.
			 * In hyperlink text Visit word remains constant but rest of the text changes
			 * e.g. Visit Google.com
			 *      Visit facebook.com
			 *      
			 */
			//WebElement Link=D.findElement(By.linkText("Visit W3Schools.com!"));
			//Below statement will identify such a hyperlink which has "Visit" word in its link text
			WebElement Link=D.findElement(By.partialLinkText("Visit"));
			Link.click();
	 }
}
