package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Commons.Elements;


public class FlightsearchResultPage extends Elements {

	WebDriver Browser;

	public FlightsearchResultPage(WebDriver Browser)
	{
		this.Browser=Browser;
	}
	
	public String GetsearchResult()
	{
		WaitForVisible(Browser, By.xpath("//*[@class='error-title']"));
		return GetText(Browser.findElement(By.xpath("//*[@class='error-title']")));

	}
}
