package BasicOfSelenium;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Upload {

	

	public void uploadfile() throws InterruptedException
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://cleartax.in/paytax/UploadForm16");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		// click the box
	    driver.findElement(By.xpath("(//div[@class='hidden-xs']//div)[1]")).click();
	    
	    // D:\Sathish\ManualTesting\manual testing interview questions.pdf
	    // copying File path to Clipboard
	    
	    StringSelection str = new StringSelection("D:\\Sathish\\ManualTesting\\manual testing interview questions.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    // using keyboard option paste the copied path and press enter
	    try {
			Robot rb = new Robot();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    } catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Thread.sleep(1000);
	    String fileName = driver.findElement(By.className("input-file-upload-hover-placeholder")).getText();
	    System.out.println(fileName);
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Upload U = new Upload();
		U.uploadfile();
	}
	
}
