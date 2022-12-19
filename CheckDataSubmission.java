package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckDataSubmission 
{
	/*
	 * 1. Open browser
	 * 2. Open URL "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test"
	 * 
	 * TestCase1:
	 * 1. Enter "Pranoday" in FirstName field
	 * 2. Enter "Dingare" in LastName field
	 * 3. Click on Submit button
	 * 4. Check that values entered are seen on next page
	 */
	ChromeDriver D;
	
	@BeforeClass
	public void OpenURLAndBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test");
		/*
		 * In statement below we have set Implicit wait.When we give an instruction to
		 * a driver for finding an element by default driver expects immediate presence of an
		 * element.If a driver does not get the element immediately then it gives exception:
		 * NoSuchElementException.
		 * 
		 * By setting implicit wait we ask driver to wait for an element if it does not get
		 * it immediately
		 */
		D.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void CheckDataSubmission() throws InterruptedException
	{
		/*
		 * When we ask our driver and browser to find an element using certain attribute
		 * and if browser did not find it then it returns an exception: NoSuchElementException
		 */
		/*
		 * In this page we have following page structure:
		 * <html>
		 * 		<html>
		 * 					<input type="text" id="fname" name="fname">
				</html>
		 * </html>
		 * 
		 * Here we have a NESTED html page inside a main HTML page, and element we want to
		 * find is present inside a NESTED page.
		 * By default search for an element is done inside MAIN page. If it gets the element
		 * on a MAIN page then  we get that else we get NoSuchElementException.
		 * Element finding does not happen inside NESTED page by default.
		 * 
		 * If we have to find an element from inside a NESTED page then we need to ask
		 * our driver to switch inside a FRAME control which loads our NESTED page
		 */
		D.switchTo().frame("iframeResult");
		WebElement FirstNameField=D.findElement(By.id("fname"));
		FirstNameField.sendKeys("Pranoday");
		String TypedName=FirstNameField.getAttribute("value");
		
		WebElement LastNameField=D.findElement(By.id("lname"));
		LastNameField.sendKeys("Dingare");
		String TypedSirName=LastNameField.getAttribute("value");
		/*
		 * <input type="submit" value="Submit">
		 * If we have to use an attribute for which we do not have a method in
		 * By, then we need to use By.cssSelector()
		 * 
		 * We need to write CssSelector query:
		 * TAGNAME[ATTRIBUTENAME='ATTRIBUTEVALUE']
		 */
		/*Following statement will find such a element which has TAGNAME as "input"
		 * and value attribute is set to "Submit"
		 */
		WebElement SubmitButton=D.findElement(By.cssSelector("input[value='Submit']"));
		SubmitButton.click();
		//Pausing script for 2 seconds
		Thread.sleep(2000);
		//Following statement will find the element using class attribute
		//WebElement DivElement=D.findElement(By.className("w3-container w3-large w3-border"));
		/*
		 * org.openqa.selenium.InvalidSelectorException: Compound class names not permitted
		 * If a control has multiple values(compound values) set in a class attribute then we
		 * can not use By.className to find an element using such class attribute.
		 * If a control has single value set in a class attribute then we can use By.className
		 */
		
		WebElement DivElement=D.findElement(By.cssSelector("div[class='w3-container w3-large w3-border']"));
		/*
		 * If we want to retrieve a value of an element attribute then we will use getAttribute
		 * but if we want to retrieve text from within the element then we need to use getText
		 * 
		 * For example.
		 * <div class="w3-container w3-large w3-border" style="word-wrap:break-word">
			fname=Pranoday&amp;lname=Dingare&nbsp;</div>
			
			If we want to retreive a value of a style attribute from Div control above,
			then we will use getAttribute("style") BUT
			if we want to retrievr a text from <div></div> then we will use getText
		 */
		String DivText=DivElement.getText();
		boolean IsFirstNamePresent=DivText.contains(TypedName);
		boolean IsLastNamePresent=DivText.contains(TypedSirName);
		Assert.assertEquals(IsFirstNamePresent, true);
		Assert.assertEquals(IsLastNamePresent, true);
		/*
		 * Following control driver will try to search for inside Nested html page
		 * and as our Run button is not inside NESTED page, it will not be able to find and it
		 * will return NoSuchElementException
		 * 
		 * So we need to tell driver to come back to the MAIN page by calling
		 * D.switchTo().defaultContent();
		 * defaultContent will always take driver back to MAIN page
		 */
		D.switchTo().defaultContent();
		WebElement RunButton=D.findElement(By.id("runbtn"));
		RunButton.click();
		
	}


}
