package BasicOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListConcepts {
	
	public void launch(String expectedCountry) {
		WebDriver browser=new ChromeDriver();
		
		
		browser.get("https://www.leafground.com/select.xhtml");
		browser.manage().window().maximize();
		/*
		 * 	click list dropdown
		 * wait till the list displays
		 * get all the list values
		 * compare the expected values
		 * click the values
		 * stop the loop
		 */
		browser.findElement(By.xpath("//*[@id='j_idt87:country']//*[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:country_items']//li[5]")));
		
		List<WebElement> allValues = browser.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
		/*for(int i=1;i<=allValues.size();i++)
		{
			String eachCountry = browser.findElement(By.xpath("//*[@id='j_idt87:country_items']//li["+i+"]")).getText();
			System.out.println(eachCountry);
			if(expectedCountry.equalsIgnoreCase(eachCountry))
			{
				browser.findElement(By.xpath("//*[@id='j_idt87:country_items']//li["+i+"]")).click();
				break;
				
			}
		}*/
		
		for(WebElement eachcountry :allValues)
		{
			String actualCountry = eachcountry.getText();
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				eachcountry.click();
				break;
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListConcepts L = new ListConcepts();
		L.launch("Germany");
	}

}
