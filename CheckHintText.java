package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckHintText 
{

	/*
	  Pre-requisite:
	 * 1. Open browser
	 * 2.Open URL "https://courses.letskodeit.com/practice"
	 * 
	 * TestCase 1:
	 * 3. Retrieve the hint text from control
	 * 4. Check that it is "Enter Your Name"
	 */
	ChromeDriver D;
	@BeforeClass
	public void OpenBrowserAndEnterURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D=new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}
	
	@Test
	public void CheckHintText()
	{
		/*
		 * Hintext to a TextBox/Edit control is set by using "placeholder" attribute.
		 * So when we want to check Hinttext then we want to actually verify the value
		 * of placeholder attribute.
		 * So we will retrieve the value of placeholder attribute of a textbox element
		 * and then we will check that retrieved value is "Enter Your Name"
		 */
		WebElement NameField=D.findElement(By.id("name"));
		/*
		 * We want to retrieve a value of "placeholder" attribute from textbox element.
		 * getAttribute() is a function which accepts name of a attribute as its argument
		 * and returns value of it.
		 * getAttribute("placeholder") will return value of "placeholder" attribute
		 */
		String HintText=NameField.getAttribute("placeholder");
		/*
		 * Once we get actual Hinttext from a control, we will compare it with expected
		 * hinttext
		 */
		 Assert.assertEquals(HintText, "Enter Your Name");
	}
}
