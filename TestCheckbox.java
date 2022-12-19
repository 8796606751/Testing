package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * Pre-requisite:
 *  Open Browser
 *  Open URL "https://courses.letskodeit.com/practice"
 * 
 * Test Case 1:
 * 
 * 1 Click on BMW checkbox
 * 2. Confirm that it gets checked
 * 
 * TestCase 2:
 * 1. Click on BMW checkbox again
 * 2. Confirm that it gets Unchecked
 */
public class TestCheckbox {

	ChromeDriver D;
	@BeforeClass
	public void OpenBrowserAndURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D=new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}
	
	@Test(priority=1)
	public void CheckIfCheckboxGetsChecked() throws InterruptedException
	{
		//Following instruction will identify and return BMW checkbox
		WebElement BMWCheckbox=D.findElement(By.id("bmwcheck"));
		//Following instruction will click on BMW checkbox
		BMWCheckbox.click();
		/*
		 * isSelected() function returns selection state of a control.
		 * If a conrol is SELECTED/CHECKED then this function returns boolean true
		 * If a control is UNSELECTED/UNCHECKED then this function return boolean false
		 */
		boolean IsSelected=BMWCheckbox.isSelected();
		/*
		 * After clicking on a checkbox we want a Checkbox control to be Selected.
		 * So our expected result is:
		 * IsSelected variable should hold value true
		 */
		/*
		 * Following statement will compare value of IsSelected variable to true and if
		 * comparison passes then TestNG will mark Testcase as PASSED(GREEN) else
		 * TestNG will mark Testcase as FAILED(RED) 
		 */
		Assert.assertEquals(IsSelected, true);
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void CheckIfCheckboxGetsUnchecked()
	{
		WebElement BMWCheckbox=D.findElement(By.id("bmwcheck"));
		BMWCheckbox.click();
		/*
		 * After the execution of 1st Testcase we have BMW checkbox checked.
		 * So in this test when we will click on it again we are expecting a checkbox to be
		 * Unchecked
		 */
		boolean IsCheckboxSelected=BMWCheckbox.isSelected();
		Assert.assertEquals(IsCheckboxSelected, false);
		
	}
}
