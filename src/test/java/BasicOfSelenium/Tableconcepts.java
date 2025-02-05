package BasicOfSelenium;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Tableconcepts {
	public void alertsimplementation(String ExpectedCountry) throws InterruptedException, AWTException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://leafground.com/table.xhtml"); //Enter url
		// get all Pages
		List<WebElement> allPages = browser.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for(int j=1;j<=allPages.size();j++)
		{
			browser.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
			Thread.sleep(2000);
			
		
		// getTotal rows
		List<WebElement> allRows =browser.findElements(By.xpath("//*[@id='form:j_idt89_data']//tr"));
		for(int i=1;i<=allRows.size();i++)
		{
			String actualCountry = browser.findElement(By.xpath("//*[@id='form:j_idt89_data']//tr["+i+"]//td[2]//span[starts-with(@style,'vertical-align')]")).getText();
			if(ExpectedCountry.equalsIgnoreCase(actualCountry))
			{
				String rep =browser.findElement(By.xpath("//*[@id='form:j_idt89_data']//tr["+i+"]//td[3]//span[starts-with(@style,'vertical-align')]")).getText();
				System.out.println(rep);
			}
		}
		}
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		Tableconcepts t = new Tableconcepts();
		t.alertsimplementation("India");
	}

}
