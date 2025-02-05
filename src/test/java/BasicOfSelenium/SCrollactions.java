package BasicOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SCrollactions {
	public void scrolllementation() throws InterruptedException
	{
		//WebDriver browser = new ChromeDriver();
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/dashboard.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)browser;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		
		// verticalupward
		js.executeScript("window.scrollBy(0,-300)", "");
		Thread.sleep(2000);
		
		// horizontal right
		js.executeScript("window.scrollBy(200,0)", "");
		Thread.sleep(2000);
		
		//horizontal left
		js.executeScript("window.scrollBy(-100,0)", "");
		Thread.sleep(2000);
		
		// vertically scroll down to the end
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
				
	// vertically scroll up to the end
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(2000);
		
		WebElement calenderbutton=browser.findElement(By.xpath("(//*[@class='fc-button-group'])[last()]"));
		js.executeScript("arguments[0].scrollIntoView();", calenderbutton);


	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SCrollactions s = new SCrollactions();
		s.scrolllementation();
	}

}
