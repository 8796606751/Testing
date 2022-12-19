package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

/*  Testscript steps:
 * 1. Open browser
 * 2. Open URL : https://courses.letskodeit.com/practice
 * 3. Find Hide button
 * 4. Click on Hide button
 * 5. Find TextBox element
 * 6. Get the display state of textbox element
 * 7. Textbox should not be displayed on page
 */
public class TestShowHiddenFunctionality 
{
	ChromeDriver D;
	@BeforeClass
	public void OpenBrowserAndURL()
	{
		System.out.println("I am in Before Class");
		/*
		 * This function handles pre-requisite:
		 * 1. Open browser
		 * 2. Open URL 
		 */
		/*
		 * Following statement sets a variable named "webdriver.chrome.driver" to path
		 * of chromedriver.exe
		 */
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		/*
		 * Following constructor does below things:
		 * 1. It retrieves path of chromedriver set to a variable "webdriver.chrome.driver"
		 * 2. It starts the chromedriver.exe
		 * 3. Once chromedriver.exe starts, it opens a browser
		 */
		D = new ChromeDriver();
		//Following statement opens an URL in browser
		D.get("https://courses.letskodeit.com/practice");
	}
	
	@Test(priority=1)
	public void TestHideButtonFunctionality()
	{
	
		System.out.println("I am in Hide button testcase");
		/*
		 * When we want to identify an element using its attribute we have to choose an
		 * attribute which is:
		 * 	1. Unique
		 *  2. Does not change
		 *  
		 *  If we want to use:
		 *  "id" attribute 		->> 				then we need to use By.id() function
		 *  "class" attribute 	->>					then we need to use By.className() function	
		 *  "name" attribute    ->>					then we need to use By.name() function
		 *  "tagName"           ->>					then we need to use By.tagName() function
		 */
		/*   Following instruction is to find an element using its "id" attribute and return it.
		 *   We are storing that returned element in HideButton variable
		 */
		/*
		 * Selenium has implemented different set of functions to work on individual
		 * elements. These functions are implemented in a class called "WebElement"
		 */
		/*
		 * int Result=Addition(10,20)
		 */
		WebElement HideButton=D.findElement(By.id("hide-textbox"));
		//Following statement will click on HideButton
		HideButton.click();
		/*   Following instruction is to find an element using its "name" attribute and return it.
		 *   We are storing that returned element in HideButton variable
		 */
		WebElement TextBox=D.findElement(By.name("show-hide"));
		
		/*
		 * Following statement will return boolean true if a TextBox is shown on the page
		 * else it will return boolean false
		 */
		boolean IsTextboxShown=TextBox.isDisplayed();
		/*
		 * After clicking on Hide button we are expecting TextBox to be hidden
		 *  
		 */
		/*
		 * In below statement we are comparing value of variable "IsTextboxShown" with our
		 * expected behaviour "false" 
		 */
		Assert.assertEquals(IsTextboxShown, false);
	}

	/*
	 * 1. Find Show button
	 * 2. Click on Show button
	 * 3. Find Textbox
	 * 4. Retrieve display state of TextBox
	 * 5. Compare it with true
	 */
	
	@Test(priority=2)
	public void TestShowButtonFunctionality()
	{
		System.out.println("I am in Show button testcase");
		WebElement ShowButton=D.findElement(By.id("show-textbox"));
		ShowButton.click();
		WebElement TextBox=D.findElement(By.name("show-hide"));
		boolean DisplayStateOfTextBox=TextBox.isDisplayed();
		Assert.assertEquals(DisplayStateOfTextBox, true);
	}
}
