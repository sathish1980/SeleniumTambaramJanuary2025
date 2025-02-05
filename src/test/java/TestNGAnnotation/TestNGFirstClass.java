package TestNGAnnotation;

import org.testng.annotations.*;

public class TestNGFirstClass {

	
	@Test(priority=1,timeOut=1,dependsOnMethods="Testcase2",groups="Sanity")
	public void Testcase1()
	{
		System.out.println("Testcase 1");
	}

	@Test(priority=2,timeOut=1,dependsOnMethods="Testcase2",groups= {"Sanity","SIT"})
	public void Testcase4()
	{
		System.out.println("Testcase 4");
	}

	@Test(priority=3,timeOut=1,groups="SIT")
	public void Testcase3()
	{
		System.out.println("Testcase 3");
	}

	
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite()
	{
		System.out.println("afterSuite");
	}
	
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest()
	{
		System.out.println("BeforeTest");
	}
	
	@AfterTest(alwaysRun=true)
	public void AfterTest()
	{
		System.out.println("AfterTest");
	}
	
	
	@BeforeClass(alwaysRun=true)
	public void beforeclass()
	{
		System.out.println("BeforeClass");
	}
	
	@AfterClass(alwaysRun=true)
	public void afterclass()
	{
		System.out.println("afterClass");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforemethod()
	{
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod()
	{
		System.out.println("afterMethod");
	}
	
	
	@Test(priority=0,enabled=true,invocationCount=3,invocationTimeOut=6000,groups= {"Sanity","SIT"})
	public void Testcase2() throws InterruptedException
	{
		System.out.println("Testcase 2");
		//Thread.sleep(500);
	}
}
