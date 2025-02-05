package BasicOfSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mouseandKeyboard {
	
	public void mousemplementation() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.ebay.com/");
		Actions mouseactions = new Actions(browser);
		mouseactions.moveToElement(browser.findElement(By.xpath("//*[@class='vl-flyout-nav__js-tab']//*[text()='Electronics']"))).perform();
		Thread.sleep(5000);
		mouseactions.moveToElement(browser.findElement(By.xpath("//*[text()='Computers and tablets']"))).click().perform();
	}
	
	public void mousemplementation1() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		Actions mouseactions = new Actions(browser);
		mouseactions.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}
	
	public void mousemplementation2() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/drag.xhtml");
		Actions mouseactions = new Actions(browser);
		mouseactions.moveToElement(browser.findElement(By.id("form:drag_content"))).dragAndDrop(browser.findElement(By.id("form:drag_content")), browser.findElement(By.id("form:drop_content"))).perform();
	}
	
	public void mousemplementation3() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/drag.xhtml");
		Actions mouseactions = new Actions(browser);
		mouseactions.moveToElement(browser.findElement(By.id("form:conpnl"))).dragAndDropBy(browser.findElement(By.id("form:conpnl")), 150, 0).perform();
		Thread.sleep(2000);
		mouseactions.moveToElement(browser.findElement(By.id("form:conpnl"))).dragAndDropBy(browser.findElement(By.id("form:conpnl")), -50, 0).perform();
	}
	
	public void mousemplementation4() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/drag.xhtml");
		Actions mouseactions = new Actions(browser);
		mouseactions.moveToElement(browser.findElement(By.id("form:j_idt119"))).click().perform();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-progressbar-label"),"100%"));
		browser.close();
	}
	
	public void keyboard() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		Actions mouseactions = new Actions(browser);
		mouseactions.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").perform();
		mouseactions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(2000);
		mouseactions.keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).perform();
		
	}

	
	public void keyboard1() throws InterruptedException, AWTException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		Actions mouseactions = new Actions(browser);
		mouseactions.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		
		Robot keyboard= new Robot();
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		keyboard.keyPress(KeyEvent.VK_TAB);
		keyboard.keyRelease(KeyEvent.VK_TAB);
		keyboard.keyPress(KeyEvent.VK_CONTROL);
		keyboard.keyPress(KeyEvent.VK_V);
		keyboard.keyRelease(KeyEvent.VK_CONTROL);
		keyboard.keyRelease(KeyEvent.VK_V);
		
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		mouseandKeyboard C = new mouseandKeyboard();
		C.keyboard1();
	}

}
