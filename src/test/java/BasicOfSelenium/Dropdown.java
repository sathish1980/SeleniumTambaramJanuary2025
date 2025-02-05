package BasicOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	
	public void dropdownimplementation() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/select.xhtml;");
		Select dropdown = new Select(browser.findElement(By.xpath("//*[@class='ui-selectonemenu']")));
		/*
		 * 3 method
		 * selectbyindex
		 * selectbyvalue
		 * selectbyvisibletext
		 * 
		 * for multiple dropdown
		 * ismultiple
		 * deselectbyindex
		 * deselectbyvalue
		 * deselectbyvisibletext
		 * deselectall
		 * 
		 */
		System.out.println(dropdown.isMultiple());
		dropdown.selectByIndex(2);
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Cypress");
		dropdown.selectByValue("6");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropdown D = new Dropdown();
		D.dropdownimplementation();
	}

}
