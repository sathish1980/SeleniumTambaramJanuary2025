package BasicOfSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class Frames {

	
	public void launch() throws InterruptedException
	{
	
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.leafground.com/frame.xhtml");
		/*
		 * id or name
		 * index
		 */
	List<WebElement> allFrames = 	browser.findElements(By.tagName("iframe"));
	int size =allFrames.size();
		for(int i=0;i<size;i++)
		{
			//browser.switchTo().frame("frame2"); 
			browser.switchTo().frame(i); // switch in to frame
			List<WebElement> elementExist = browser.findElements(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]"));
			if(elementExist.size()>0)
			{
				 browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]")).click();
				 browser.switchTo().defaultContent();	// switch out of frame
				 break;
			}
			 browser.switchTo().defaultContent();
		}
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Frames F = new Frames();
		F.launch();
	}
}
