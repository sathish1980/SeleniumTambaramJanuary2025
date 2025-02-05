package BasicOfSelenium;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstClass {
	
	// maven-archetype-quickstart
	
	public void launch() throws InterruptedException
	{
	//	WebDriver browser = new ChromeDriver();
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		//browser.manage().window().minimize();
		//browser.quit();
		browser.get("https://www.facebook.com/");
		/*browser.navigate().to("https://www.google.com/");
		browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();*/
		Thread.sleep(2000);
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		WaitforVisible(browser,By.id("email"));
		WebElement username = browser.findElement(By.id("email"));
		EnterText(username,"kumar.sathish189@gmail.com");
		//username.sendKeys("kumar.sathish189@gmail.com");
		//username.clear();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
		WaitforVisible(browser,By.name("pass"));
		browser.findElement(By.name("pass")).sendKeys("Admin");
		browser.findElement(By.id("pass")).clear();
		//browser.findElement(By.className("inputtext _55r1 _6luy _9npi")).sendKeys("test");
		//browser.findElement(By.name("login")).click();
		//browser.findElement(By.linkText("Forgotten password?")).click();
		browser.findElement(By.partialLinkText("password?")).click();
		//Teststep = webElement +actions;
		/*
		 * Css selector
		 * 1. Tag and id --> tag#id
		 * 2. Tag and Class--> tag.class
		 * 3. Tag and Attribute--> tag[attribute='value'] or [attribute='value'] or *[attribute='value']
		 * 4. Tag class and Attribute-> tag.class[attribute='value']
		 * 5. contains-- * -->tag[attribute*='somevalue']
		 * 6. startswith -- ^ -->tag[attribute^='startting value of the attribute']
		 * 7. endswith -- $ -->tag[attribute$='end value of the attribute']
		 */
		browser.findElement(By.cssSelector("input#email")).sendKeys("sathish");
		browser.findElement(By.cssSelector("div._6lux>input")).clear();
		browser.findElement(By.cssSelector("input[id='email']")).sendKeys("Besant");
		/*
		 * Xpath
		 * 2 types
		 * Absolute Xpath -- > /
		 * Relative Xpath -->  //
		 * 
		 * Relative Xpath -  5 types
		 * 1.Basic xpath -- //tagname[@attribute='value'] or //*[@attribute='value'] 
		 * 2.Contains --> //tagname[contains(@attribute,'some value')]
		 * 3.And or --> //tagname[contains(@attribute,'some value') and @attribute2='value2']
		 * 4.starts-with -->  //tagname[starts-with(@attribute,'startting value')]
		 * 5.text-- > 	//tagname[text()='text value']
		 */
		
		browser.findElement(By.xpath("//div[@class='_6lux']/input[@type='text']")).sendKeys("Tambaram");
		
		
		
	}
	
	public void EnterText(WebElement element,String texttoEneter)
	{
		element.clear();
		element.sendKeys(texttoEneter);
	}
	
	public void WaitforVisible(WebDriver driver, By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.launch();
	}

}
