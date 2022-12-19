package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestEnableDisableFunctionality {

	/*
	 * Pre-requisites:
	 * 1. Open browser
	 * 2. Open URL "https://courses.letskodeit.com/practice"
	 * 
	 * Test steps Testcase 1:
	 * 1. Find disable button
	 * 2. Click on disable button
	 * 3. Find Textbox
	 * 4. Check if Textbox is disabled
	 * 
	 * Test steps Testcase 2:
	 * 1. Find Enable button
	 * 2. Click on Enable button
	 * 3. Find Textbox
	 * 4. Check if Textbox is enabled 
	 * 
	 */
	ChromeDriver D;
	/*
	 * When TestNG runs test class it 1st calls a method annotated with @BeforeClass
	 */
	@BeforeClass
	public void OpenBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		/*Following constructor reads property "webdriver.chrome.driver"and starts
		 * chromedriver.exe process.
		 * ChromeDriver starts chrome browser
		*/
		D=new ChromeDriver();
		//Following instruction opens the URL in browser
		D.get("https://courses.letskodeit.com/practice");
	}

	/*
	 * When we have multiple @Test methods be default TestNG calls them in alphabetical order of 
	 * their name.
	 * If we do not want methods to be called in alphabetical order and want to specify
	 * order of their execution, we can specify priority.
	 * 
	 * A methods having less priority number gets called beforea method having grater priority
	 * number
	 * 
	 * For example:
	 * If we have 2 @Test methods having priority 1 and priority 2 then they will be called in
	 * order below:
	 * 1.@Test with priority 1
	 * 2.@Test with priority 2
	 * 
	 * 
	 */
	@Test(priority=1)
	public void TestDisableButton()
	{
		/*
			<input id="disabled-button" class="btn-style class2" value="Disable" onclick="disableElement()" type="submit">
			Preference for creating an identification should always be given to "id" attribute
		*/
		/*
		 * Following method will ask driver to find an element having "id" attribute
		 * set to "disabled-button".Driver will translate this instruction in the language
		 * browser understands and will send this instructionto browser.
		 * 
		 * Then browser will find the required element on the page and will return it to driver.
		 * Driver will return the element to script.
		 * 
		 * WebElement is a class implemented in Selenium jars. It represents element on a
		 * web page.
		 * WebElement class contains methods like click,sendKeys etc. which will allow us to
		 * perform required interactions on a control
		 */
		WebElement DisabledButton=D.findElement(By.id("disabled-button"));
		/*Following statement calls a click method with the reference of a variable having
		 * disable button stored.It will click on Disabled button
		 *  
		 */
		DisabledButton.click();
		//Following instruction will find the element and will return it.
		//TextBox variable has Textbox from our page.
		WebElement TextBox=D.findElement(By.id("enabled-example-input"));
		/*
		 * isEnabled method returns enable state of a control.
		 * If a control is in ENABLED state it returns boolean true
		 * If a control is in DISABLED state it returns boolean false
		 */
		boolean IsControlEnabled=TextBox.isEnabled();
		/*
		 * We have ACTUAL state of a button stored in IsControlEnabled variable.
		 * EXPECTED RESULT of a test case is to have boolean false in IsControlEnabled variable  
		 */
		/*
		 * Following step compares value in variable IsControlEnabled with false.
		 * If  IsControlEnabled variable has value boolean false then TestNG will
		 * mark this test case PASSED(Green).
		 * 
		 * If  IsControlEnabled variable has value boolean true then comparison
		 * will fail and TestNG will mark this test case FAILED(Red).
		 */
		Assert.assertEquals(IsControlEnabled, false);
	}
	@Test(priority=2)
	public void TestEnableButton()
	{
		WebElement EnableButton=D.findElement(By.id("enabled-button"));
		EnableButton.click();
		
		WebElement TextBox=D.findElement(By.id("enabled-example-input"));
		boolean IsTextBoxEnabled= TextBox.isEnabled();
		/*
		 * Now we are expecting TextBox to be enable.
		 * 
		 */
		/*
		 * We have ACTUAL state of a button stored in IsTextBoxEnabled variable.
		 * EXPECTED RESULT of a test case is to have boolean true in IsTextBoxEnabled variable  
		 */
		
		/*
		 * Following step compares value in variable IsTextBoxEnabled with true.
		 * If  IsTextBoxEnabled variable has value boolean true then TestNG will
		 * mark this test case PASSED(Green).
		 * 
		 * If  IsTextBoxEnabled variable has value boolean false then comparison
		 * will fail and TestNG will mark this test case FAILED(Red).
		 */
		Assert.assertEquals(IsTextBoxEnabled, true);
	}
}
