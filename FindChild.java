package VibrantMindsSeleniumBatch37_38_39.SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindChild {

	ChromeDriver D;
	@BeforeClass
	public void StartBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\VibrantMinds37_38_39\\chromedriver.exe");
		D= new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
	}

	@Test
	public void ClickOnCheckbox()
	{
		/*
		 * Following statement searches for an element on entire page. And it gets radio control
		 * before the checkbox and hence it returns checkbox and clicks on it.
		 * 
		 * To avoid this situation we will ask driver to search for an element inside
		 * another element instead of searching entire page.
		 * When we can findElement using D object , it searches for an element on entire
		 * page. But if we want element finding to be done only inside another control
		 * then we have to 1st find that parent control and then call findElement with the
		 * reference of parent control instead of driver
		 */
		//WebElement HondaChk=D.findElement(By.cssSelector("input[value='honda']"));
		WebElement DivElement=D.findElement(By.id("checkbox-example-div"));
		//Following statement will find checkbox element inside DivElement and not on entire page
		WebElement HondaChk=DivElement.findElement(By.cssSelector("input[value='honda']"));
		HondaChk.click();
	}

}
