package Testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Browsers.BrowserDriver;
import Commons.Elements;
import Utils.ExcelfileRead;
import Utils.PropertyFileRead;
import pages.FlightSearchpage;
import pages.FlightsearchResultPage;

public class MakeMyTripFlightSearch extends BrowserDriver {
	
	
	@BeforeSuite
	public void OpenBrowser() throws IOException
	{
		launchTheBrowser();
	}
	
	@AfterSuite
	public void CloseBrowser() throws IOException
	{
		CloseTheBrowser();
	}
	
	
	@BeforeTest
	public void LaunchtheApplication() throws IOException
	{
		String url1 = PropertyFileRead.GetDataFromPropFile().getProperty("url");
		driver.get(url1);
	}
	
	@BeforeClass
	public void closePopup()
	{
		By loactor =By.xpath("//*[@data-cy='closeModal']");
		Elements.WaitForClickable(driver,loactor);
		Elements.ClickOnButton(driver.findElement(loactor));
	}
	
	
	@Test(priority=0,dataProvider="GetValidFlightTestData")
	public void ValidatedFlightSearchWithValidValues(String from,String to,String date) throws InterruptedException
	{
		test = extent.createTest("SearchWithValidValues Testcase");
		/*
		 * Select from location
		 * select to location
		 * select date
		 * click search
		 * Validate the search result
		 */
		FlightSearchpage fs = new FlightSearchpage(driver);
		fs.SelectFromLocation(from);
		test.log(Status.INFO, "Select from location");
		fs.SelectToLocation(to);
		test.log(Status.INFO, "Select to location");
		fs.SelectDate(date);
		test.log(Status.INFO, "Select date ");
		fs.clickOnSearchbutton();
		test.log(Status.INFO, "Click search");
		FlightsearchResultPage fsr =new FlightsearchResultPage(driver);
		String actualResult = fsr.GetsearchResult();
		String expectedResult = "NETWORK PROBLEM";
		Assert.assertEquals(actualResult, expectedResult);
		test.log(Status.INFO, "validate search result");
		fs.ClickBackButton(driver);
	}
	
	@Test(priority=1,dataProvider="GetinValidFlightTestData")
	public void ValidatedFlighrSearchWithinValidValues(String from,String to) throws InterruptedException
	{
		test = extent.createTest("SearchWithinValidValues Testcase");
		/*
		 * Select from location
		 * select to location
		 * select date
		 * click search
		 * Validate the search result
		 */
		FlightSearchpage fs = new FlightSearchpage(driver);
		//fs.ClickBackButton(driver);
		fs.SelectFromLocation(from);
		test.log(Status.INFO, "Select from location");
		fs.SelectToLocation(to);
		test.log(Status.INFO, "Select to location");
		String actualResult = fs.GetSameCityError();
		String expectedResult = "From & To airports cannot be the same";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterMethod
	public void WriteInReport(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.SUCCESS) {
			String filePath = Elements.GetScreenshot(driver,result.getName());
		     test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is passed");

        }else if(result.getStatus()==ITestResult.FAILURE) {
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is FAILED");
            String filePath = Elements.GetScreenshot(driver,result.getName());
            test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.FAIL,"Test failure : "+ result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SKIP) {
            test.log(Status.SKIP,"Test Method named as : "+ result.getName()+" is skipped");
        }
	}
	
	@DataProvider
	public Object[][] GetValidFlightTestData() throws IOException
	{
		return ExcelfileRead.ExcelRead("Valid");
	}
	
	@DataProvider
	public Object[][] GetinValidFlightTestData() throws IOException
	{
		return ExcelfileRead.ExcelRead("invalid");
	}
}
