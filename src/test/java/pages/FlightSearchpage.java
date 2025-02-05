package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Commons.Elements;



public class FlightSearchpage extends Elements{
	
	WebDriver Browser;
	public FlightSearchpage(WebDriver Browser)
	{
		this.Browser=Browser;
	}
	
	
	public void SelectFromLocation(String from) throws InterruptedException
	{
		ClickFromLocationdropdown();
		SelectValueFromList(from);
	}
	
	public void SelectToLocation(String to) throws InterruptedException
	{
		ClickToLocationdropdown();
		SelectValueFromList(to);
	}
	
	public void SelectDate(String expectedDate) throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> allWeeks = Browser.findElements(By.xpath("(//*[@class='DayPicker-Months']//div[@class='DayPicker-Month'])[last()]//div[@class='DayPicker-Week']"));
		for(WebElement eachWeek : allWeeks)
		{
			List<WebElement> allDaysInaWeek=	eachWeek.findElements(By.cssSelector("div[class^='DayPicker-Day']"));
			for (WebElement eachday : allDaysInaWeek)
			{
				
				String className = GetAttribute(eachday,"class");
				if(!(className.contains("outside")||className.contains("disabled")||className.contains("selected")))
				{
					String actualDate =GetText(eachday.findElement(By.tagName("p")));
					System.out.println(actualDate);
					if(actualDate.equalsIgnoreCase(expectedDate))
					{
						System.out.println(actualDate);
						
						ClickOnButton(eachday);
						return ;
					}
				}
			}
		}
	}
	
	public void clickOnSearchbutton() throws InterruptedException
	{
		WaitForClickable(Browser, By.xpath("//a[text()='Search']"));
		ClickOnButton(Browser.findElement(By.xpath("//a[text()='Search']")));

	}
	public void ClickFromLocationdropdown() throws InterruptedException
	{
		Elements.WaitForClickable(Browser, By.cssSelector("[for='fromCity']"));
		WebElement from = Browser.findElement(By.cssSelector("[for='fromCity']"));
		Elements.ClickOnButton(from);

	}
	
	public void ClickToLocationdropdown() throws InterruptedException
	{
		WaitForClickable(Browser, By.cssSelector("[for='toCity']"));
		WebElement to = Browser.findElement(By.cssSelector("[for='toCity']"));
		
		ClickOnButton(to);
	}
	
	public void SelectValueFromList(String selectValue)
	{
		WebDriverWait wait = new WebDriverWait(Browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='react-autowhatever-1']//li)[last()]")));
		
		List<WebElement> allcountry =Browser.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
	
		for (WebElement eachElement : allcountry)
		{
			String Code = eachElement.findElement(By.cssSelector("div[class^='font14']")).getText();
			System.out.println(Code);
			if(Code.equalsIgnoreCase(selectValue))
			{
				eachElement.click();
				break;
			}
		}
	}
	
	public String GetSameCityError()
	{
		return GetText(Browser.findElement(By.xpath("//*[@data-cy='sameCityError']")));
		
	}
	


}
