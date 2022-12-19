package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckAlertMessage 
{

	/*
	 * Pre-requisite:
	 * 1. Open Browser
	 * 2. Open URL "https://courses.letskodeit.com/practice"
	 * 
	 * Test Case1:
	 * 1. Find a Textbox element
	 * 2. Enter "Pranoday" in that textbox
	 * 3. Retrieve entered name and keep it in a variable
	 * 4. Find Alert button
	 * 5. Click on it
	 * 6. Read a message shown by an alert box and keep it in some other variable
	 * 7.Check that a message read from a alert box contains name we had entered.
	 */
	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D=new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}
	
	@Test
	public void TestAlertMessage()
	{
		WebElement NameField=D.findElement(By.id("name"));
		//Following statement will type "Pranoday" in Textbox
		NameField.sendKeys("Pranoday");
		
		/*
		 * Hello ,share this practice page and share your knowledge
		 * Hello Prakash,share this practice page and share your knowledge
		 *  
		 * How to get a data typed inside a TextBox control???
		 * <input id="name" name="enter-name" class="inputs" placeholder="Enter Your Name" type="text" value="Akanksha">
		 * When we type any data inside a textbox control, then that data gets set to a
		 * attribute called "value".
		 * So if we want to retrieve a type text from a textbox control then we can get it
		 * by retrieving value of "value" attribute.
		 * So we will call NameField.getAttribute("value") to retrieve a typed text from it
		 */
		//Following statement will return typed text "Pranoday"
		String TypedName=NameField.getAttribute("value");
		WebElement AlertBtn=D.findElement(By.id("alertbtn"));
		AlertBtn.click();
		
		/*
		 * Usually elements we work on like TextBox,button control etc. are part of a html
		 * page of an application. So we can instruct to find these elements, once we get those
		 * elements we can work on them.
		 * BUT alert boxes are NOT part of html page of an application.
		 *  
		 */
		/*
		 * Following statement asks driver to leave working on a html page and switch
		 * working to a Alert box.This instruction switches working to an Alert box
		 * and returns that box to us.Once we get the box we save it in a variable of type Alert.
		 * 
		 */
		Alert Al=D.switchTo().alert();
		//Following instruction will return a text from a Alert box
		//AlertMessage=Hello Pranoday, share this practice page and share your knowledge
		String AlertMessage=Al.getText();
		/*
		 * Following statement will check if AlertMessage contains TypedName.
		 * If AlertMessage contains TypedName then it will return boolean true ELSE it will
		 * return boolean false.
		 * 
		 */
		boolean IsNamePresent=AlertMessage.contains(TypedName);
		Assert.assertEquals(IsNamePresent, true);
		//Following statement closes the Alert box by clicking on Ok button
		Al.accept();
	}
}
