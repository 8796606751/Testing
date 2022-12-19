package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDropdownControl 
{

	ChromeDriver D;
	WebElement CarSelect;
	Select Se;
	@BeforeClass
	public void StartBrowser()
	{
			System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
			D = new ChromeDriver();
			D.get("https://courses.letskodeit.com/practice");
	}
	
	@Test(priority=1)
	public void TestDefaultSelectedValue()
	{
		/*
		 * 1. Get the default selected option from dropdown
		 * 2. Check that it is "BMW"
		 * 
		 * <select id="carselect" name="cars"> 
		 * 		<option value="bmw">BMW</option> 
		 * 		<option value="benz">Benz</option> 
		 * 		<option value="honda">Honda</option> 
		 *  </select>
		 */
	
		 CarSelect=D.findElement(By.id("carselect"));
		 Se=new Select(CarSelect);
	
		 /*
		  * getFirstSelectedOption() function returns option tag for currently selected option 
		  * element.
		  * so if Benz option is selected then we will get <option value="benz">Benz</option>
		  * if BMW is selected then we will get <option value="bmw">BMW</option>
		  * if Honda is selected then we will get <option value="honda">Honda</option>    
		  */
		 WebElement SelectedOption=Se.getFirstSelectedOption();
		 String SelectedOptionText=SelectedOption.getText();
		 Assert.assertEquals(SelectedOptionText, "BMW");
	}
	
	@Test(priority=2)
	public void SelectEachValueAndTestIt() throws InterruptedException
	{
		/*
		 * We can select options in dropdown using following 3 ways:
		 * 1. By Index: We can ask to select option based on its index. Index starts with 0
		 * 2. By.Value: We can ask to select option based on its value attribute
		 * For example if I want to select Benz option then I will use its value attribute "benz"
		 * like below:
		 * Se.selectByValue("benz")
		 * 3. By.visibleText:
		 * We can tell which option to select using its visible text
		 */
		Se.selectByIndex(2);
		Thread.sleep(3000);
		Se.selectByValue("benz");
		Thread.sleep(3000);
		Se.selectByVisibleText("Honda");
	}
	
	public void CheckAllOptions()
	{
		/*
		* We want to check that Dropdown control contains following 3 options:
		* BMW
		* Benz
		* Honda
		*/
		
		List<String>ExpectedCarNames=new ArrayList<String>();
		ExpectedCarNames.add("BMW");
		ExpectedCarNames.add("Benz");
		ExpectedCarNames.add("Honda");
		/*
		 * Following statement will return a list of all Option tags from our Select control
		 * AllOptions= <option value="bmw">BMW</option>
		 *   		   <option value="maruti">Maruti</option>
		 *             <option value="honda">Honda</option>
		 */
		List<WebElement>AllOptions=Se.getOptions();
		for(WebElement Option:AllOptions)
		{
			String OptionText=Option.getText();
			boolean IsElementExistsInList=ExpectedCarNames.contains(OptionText);
			Assert.assertEquals(IsElementExistsInList, true);
		}	
		
	}
}
