package BasicOfSelenium;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsConcepts {
	
	public void alertsimplementation() throws InterruptedException, AWTException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://leafground.com/alert.xhtml"); //Enter url
		browser.findElement(By.id("j_idt88:j_idt91")).click();
		browser.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("simple_result")));
	
		String text = browser.findElement(By.id("simple_result")).getText();
		System.out.println(text);
		
		browser.findElement(By.id("j_idt88:j_idt93")).click();
		browser.switchTo().alert().dismiss();
		//WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
	
		String text1 = browser.findElement(By.id("result")).getText();
		System.out.println(text1);
		
		browser.findElement(By.id("j_idt88:j_idt104")).click();
		Alert a =browser.switchTo().alert();
		String t =a.getText();
		a.sendKeys("Besant");
		a.accept();
		
		System.out.println(t);
		//WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm_result")));
	
		String text2 = browser.findElement(By.id("confirm_result")).getText();
		System.out.println(text2);
		
		browser.findElement(By.id("j_idt88:j_idt106")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt109")));
		Thread.sleep(1000);
		browser.findElement(By.id("j_idt88:j_idt109")).click();
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		AlertsConcepts A = new AlertsConcepts();
		A.alertsimplementation();
	}

}
