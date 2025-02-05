package Browsers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.PropertyFileRead;

public class BrowserDriver {
	
	public static WebDriver driver;
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	//helps to generate the logs in test report.
	public static ExtentTest test;
	
	String reportPath= "C:\\Users\\DELL\\eclipse-workspace\\SeleniumTambaramJanuary2025\\Report\\seleniumbesanttambaram.html";
	
	public void launchTheBrowser() throws IOException
	{
		
		String browserName = PropertyFileRead.GetDataFromPropFile().getProperty("browser");
		
		if(browserName.equalsIgnoreCase("edge"))
		{
		driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		CreateReport();
		
	}
	
	public void CreateReport()
	{
		htmlReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	public void closeReport()
	{
		extent.flush();
	}
	
	public void CloseTheBrowser()
	{
		closeReport();
		driver.quit();
	}
}
