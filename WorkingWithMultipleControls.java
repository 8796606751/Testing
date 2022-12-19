package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WorkingWithMultipleControls 
{

	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D=new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}

	/*
	 * Find all checkboxes.
	 * Click on them one by one
	 * Check that each of them gets selected
	 */
	@Test(priority=1)
	public void CheckIfCheckboxesGetSelected() throws InterruptedException
	{
		/*
		WebElement BMWChk=D.findElement(By.id("bmwcheck"));
		WebElement BenzChk=D.findElement(By.id("benzcheck"));
		*/
		/*
		 * D.findElements return MULTIPLE elements.
		 * If we want to find single element we use D.findElement() with UNIQUE property.
		 * BUT when we want to find MULTIPLE elements we use D.findElements with COMMON property
		 */
		/*AllCheckboxes contains all the 3 checvkboxes
		 * AllCheckboxes=<input id="bmwcheck" value="bmw" name="cars" type="checkbox">
		 * 				  <input id="benzcheck" value="benz" name="cars" type="checkbox">
		 * 			     <input id="hondacheck" value="honda" name="cars" type="checkbox">  
		 */
		/*
		 * In following statement, we are applying to attributes in CSS query.
		 * TAGNAME[ATTRIBUTENAME1='ATTRIBUTEVALUE1'][ATTRIBUTENAME2='ATTRIBUTEVALUE2']
		 */
		List<WebElement>AllCheckboxes=D.findElements(By.cssSelector("input[type='checkbox'][name='cars']"));
		System.out.println(AllCheckboxes.size());
		for(WebElement Checkbox:AllCheckboxes)
		{
			Checkbox.click();
			Thread.sleep(2000);
			boolean IsCheckboxChecked=Checkbox.isSelected();
			Assert.assertEquals(IsCheckboxChecked, true);
		}
	
		
	
	}

	@Test(priority=2)
	public void CheckIfCheckboxesGetDeselected() throws InterruptedException
	{
		List<WebElement>AllCheckboxes=D.findElements(By.cssSelector("input[type='checkbox'][name='cars']"));
		for(WebElement Checkbox:AllCheckboxes)
		{
			Checkbox.click();
			Thread.sleep(2000);
			boolean IsCheckboxChecked=Checkbox.isSelected();
			Assert.assertEquals(IsCheckboxChecked, false);
		}
	}
}
