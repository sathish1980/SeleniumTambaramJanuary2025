package BasicOfSelenium;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {
	
	public void windowsimplementation() throws InterruptedException, AWTException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://leafground.com/window.xhtml"); //Enter url
		
		String parentWindow= browser.getWindowHandle();
		System.out.println(parentWindow);
		browser.findElement(By.id("j_idt88:new")).click();
		Set<String> allWindows = browser.getWindowHandles();
		System.out.println(allWindows);
		for (String eachWindow : allWindows)
		{
			if(!parentWindow.equalsIgnoreCase(eachWindow))
			{
				browser.switchTo().window(eachWindow);
				Thread.sleep(3000);
				List<WebElement> elementEist = browser.findElements(By.id("menuform:j_idt40"));
				if(elementEist.size()>0)
				{
					 browser.findElement(By.id("menuform:j_idt40")).click();
					 WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
					wait.until(ExpectedConditions.elementToBeClickable(By.id("menuform:m_input")));
					
					 browser.findElement(By.id("menuform:m_input")).click();
					 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("j_idt88:name")));
						
					 browser.findElement(By.id("j_idt88:name")).sendKeys("sathish");
					 browser.close();
					 browser.switchTo().window(parentWindow);
					 break;
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WindowsHandling W = new WindowsHandling();
		W.windowsimplementation();
	}

}
