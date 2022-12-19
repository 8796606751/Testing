package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckPriceOfCourse 
{

	/*
	 * 1. Open browser
	 * 2. Open URL "https://courses.letskodeit.com/practice"
	 * 3. Check that price of course named "Python Programming Language" is "30" 
	 */
	ChromeDriver D;
	@BeforeClass
	public void StartBrowserAndOpenURL()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}
	
	@Test
	public void TestPriceOfCourse()
	{
		/*
		 * We want to check a price of course "Python programming language". So we have name of 
		 * course available with us. We want to find such a element which shows price of
		 * course "Python programming language"
		 * Usually XPATH is used when we need to do Relational Identification. We need to do
		 * relational identification in following cases:
		 * 1. Element which we want to identify does not have any attribute with UNIQUE value
		 * 2. Element which we want to identify has an attribute value of which always change.
		 *    For example if we have an element having only 1 attribute set named "value", so
		 *    we do not have any other attribute to identify this element. But this value
		 *    attribute's value always changes. 
		 * 3. If a data available with us does not help us in identifying control.
		 *    For example: we want to identify a "td" element showing price of course named
		 *    "Java". Now here we have name of a course as an input but this name is not set
		 *    to an element showing its price. So this data available with us is not useful to
		 *    identify required element.
		 *  
		 *  So in above cases we can not do NATIVE identification and hence we only have 1 option
		 *  to identify an element which close to the element we are interested in and then
		 *  use the relationship between that element and the element which we want to find.
		 */
		WebElement PriceElement=D.findElement(By.xpath("//table[@id='product']//td[text()='Python Programming Language']/following-sibling::td"));
		String PriceValue=PriceElement.getText();
		Assert.assertEquals(PriceValue, "30");
		
	}
}
