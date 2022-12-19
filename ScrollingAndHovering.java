package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollingAndHovering 
{

	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
	
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}
	
	@Test
	public void TestHovering()
	{
		WebElement HoverButton=D.findElement(By.id("mousehover"));
		
		/*
		 * Selenium does not have any function for page scrolling.
		 * JavaScript does have a function called "scrollIntoView()".
		 * We can inject a JavaScript function inside our web page and get that
		 * function executed inside a browser
		 * 
		 * executeScript() function injects a javascript code inside a page and
		 * gets it executed there.
		 * 
		 * Following statement calls executeScript() functions with 2 arguments:
		 * 1. scrollIntoView() function which we want to insert in browser and get it executed there
		 * 2.We want to send a HoverButton inside to call the scrollIntoView function
		 * so by mentioning HoverButton as a 2nd argument to executeScript() function we
		 * are sending it inside a javascript and we are accessing it while calling
		 * the function using arguments array
		 * Following statement will scroll the page until button get TOP aligned
		 */
		D.executeScript("arguments[0].scrollIntoView()", HoverButton);
		//Following statement will scroll the page until an element gets aligned to bottom of the page
		//D.executeScript("arguments[0].scrollIntoView(false)", HoverButton);
		Actions Act= new Actions(D);
		/*
		 * Following statement will move mouse pointer to HoverButton element
		 */
		Act.moveToElement(HoverButton).perform();
		
	}
}
