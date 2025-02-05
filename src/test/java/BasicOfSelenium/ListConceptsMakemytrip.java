package BasicOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListConceptsMakemytrip {
	
	public void launch(String expectedCountry) throws InterruptedException {
		WebDriver browser=new ChromeDriver();
		
		
		browser.get("https://www.makemytrip.com/flights/");
		browser.manage().window().maximize();
		/*
		 * 	click from dropdown
		 * wait till the list displays
		 * get all the list values
		 * compare the expected values
		 * click the values
		 * stop the loop
		 */
		Thread.sleep(3000);
		browser.findElement(By.xpath("//*[@for='fromCity']")).click();
		
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='react-autowhatever-1']//ul//li[last()]")));
		
		List<WebElement> allValues = browser.findElements(By.xpath("//*[@id='react-autowhatever-1']//ul//li"));
		/*for(int i=1;i<=allValues.size();i++)
		{
			String eachCountry = browser.findElement(By.xpath("//*[@id='react-autowhatever-1']//ul//li["+i+"]//div[starts-with(@class,'font14')]")).getText();
			System.out.println(eachCountry);
			if(expectedCountry.equalsIgnoreCase(eachCountry))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='react-autowhatever-1']//ul//li["+i+"]")));
				JavascriptExecutor js =(JavascriptExecutor)browser;
				js.executeScript("window.scrollBy(0,350)", "");
				browser.findElement(By.xpath("//*[@id='react-autowhatever-1']//ul//li["+i+"]")).click();
				break;
				
			}
		}*/
		
		for(WebElement eachcountry :allValues)
		{
			String actualCountry = eachcountry.findElement(By.cssSelector("div[class^='font14']")).getText();
			System.out.println(actualCountry);
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				eachcountry.click();
				break;
				
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ListConceptsMakemytrip L = new ListConceptsMakemytrip();
		L.launch("BLR");
	}

}
