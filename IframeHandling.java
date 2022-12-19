package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframeHandling 
{

	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test");

	}
	
	@Test
	public void TestDataSubmission()
	{
		/*
		 * Following statement will give error NoSuchElementException.
		 * By default driver always looks for elements on MAIN page.Our element is inside
		 * NESTED page. hence it gives NoSuchElement exception.
		 * 
		 *  Now if we want driver to find an element inside NESTED page then we need to
		 *  tell driver to switch to the NESTED page.
		 *  
		 *  We can use D.switchTo.iFrame() to tell driver, to leave MAIN page and switch inside 
		 *  an iframe control which loads a NESTED page.
		 *  Once driver enters into an Iframe then it will be able to find elements
		 *  in NESTED page
		 */
		D.switchTo().frame("iframeResult");
		WebElement FirstNameField=D.findElement(By.id("fname"));
		FirstNameField.sendKeys("Pranoday");
		String FirstName=FirstNameField.getAttribute("value");
		
		WebElement LastNameField=D.findElement(By.id("lname"));
		LastNameField.sendKeys("Dingare");
		String LastName=LastNameField.getAttribute("value");
		
		WebElement SubmitButton=D.findElement(By.cssSelector("input[type='submit']"));
		SubmitButton.click();
		/*
		 * If a class attribute of an element has COMPOUND(MULTIPLE) value set then
		 * we can not use By.className() to find an element using class attribute.
		 * If we try to find an element using COMPUND class with By.className then we
		 * get error : org.openqa.selenium.InvalidSelectorException: Compound class names not permitted
		 * 
		 * In such case we can find element using class attribute through By.cssSelector 
		 */
		//WebElement DivElement=D.findElement(By.className("w3-container w3-large w3-border"));
		WebElement DivElement=D.findElement(By.cssSelector("div[class='w3-container w3-large w3-border']"));
		/*
		 * Following statement will retrive text from within Div element
		 */
		String DivText=DivElement.getText();
		boolean IsFirstNamePresent=DivText.contains(FirstName);
		boolean IsLastNamePresent=DivText.contains(LastName);
		
		Assert.assertEquals(IsFirstNamePresent, true);
		Assert.assertEquals(IsLastNamePresent, true);
		/*
		 * Our Run button is not inside NESTED page but it is inside MAIN page.
		 * So before finding Run button we need to bring driver back to the MAIN page
		 * Using D.switchTo().defaultContent(); we can bring our driver back to MAIN page
		 */
		D.switchTo().defaultContent();
		WebElement RunButton=D.findElement(By.id("runbtn"));
		RunButton.click();
	}
}
