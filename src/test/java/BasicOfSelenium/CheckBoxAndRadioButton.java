package BasicOfSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxAndRadioButton {
	
	public void checkboximplementation() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/checkbox.xhtml;");
		browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//div[starts-with(@class,'ui-chkbox')]")).click();
		Thread.sleep(3000);
		browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//div[starts-with(@class,'ui-chkbox')]")).click();
		browser.findElement(By.className("ui-toggleswitch-slider")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='ui-growl-title']")));
		String text = browser.findElement(By.xpath("//*[@class='ui-growl-title']")).getText();
		System.out.println(text);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='ui-growl-title']")));
		
		browser.findElement(By.className("ui-toggleswitch-slider")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='ui-growl-title']")));
		String text1 = browser.findElement(By.xpath("//*[@class='ui-growl-title']")).getText();
		System.out.println(text1);
	}
	
	public void radiobuttonimplementation() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/radio.xhtml");
		browser.findElement(By.xpath("//*[@id='j_idt87:console1']//td[3]//div[starts-with(@class,'ui-radiobutton-box')]")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CheckBoxAndRadioButton C = new CheckBoxAndRadioButton();
		C.radiobuttonimplementation();
	}

}
