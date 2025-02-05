package BasicOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Highlight {

	WebDriver browser;


	public void HighLights()
	{
		browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.leafground.com/dashboard.xhtml");
		WebElement element = browser.findElement(By.id("menuform:j_idt40"));
		
		JavascriptExecutor js = (JavascriptExecutor) browser;
        //use executeScript() method and pass the arguments 
        //Here i pass values based on css style. Yellow background color with solid red color border. 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		WebElement ele = browser.findElement(By.id("email"));
		js.executeScript("arguments[0].setAttribute('style', 'background: grey; border: 2px solid red;');", ele);
		
		System.out.println(browser.getCurrentUrl());
		System.out.println(browser.getTitle());
		System.out.println(browser.getPageSource());
		
	}
	
	public static void main(String[] args)
	{
		Highlight H = new Highlight();
		H.hashCode();
	}
	
	
}
