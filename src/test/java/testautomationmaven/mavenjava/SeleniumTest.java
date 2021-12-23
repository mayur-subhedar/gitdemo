package testautomationmaven.mavenjava;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.Test;

public class SeleniumTest {
	ExtentReports ext;
	
	@BeforeTest
	public void config()
	{
		
		//extent reports and //ExtentSparkReporter
		
		String path= System.getProperty("user.dir")+"/repa/re.html";
		ExtentSparkReporter repo= new ExtentSparkReporter(path);
		repo.config().setReportName("web automation results");
		repo.config().setDocumentTitle("expo reports");
		
		ext = new ExtentReports();
		ext.attachReporter(repo);
		ext.setSystemInfo("tester", "mayur");;
		
		
	}

	@Test
	public void BrowserAutomation()
	{
		
		ext.createTest("BrowserAutomation");
		System.setProperty("webdriver.chrome.driver", "/opt/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		
		driver.findElement(By.className("blinkingText")).click();
		
	Set<String> st = driver.getWindowHandles();
	Iterator<String> i=st.iterator();
	
	String parentId=i.next();
	String childId=i.next();
	
	driver.switchTo().window(childId);
	String Text =driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split("with")[0].trim();
	
	driver.switchTo().window(parentId);
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Text);
	
	driver.close();
	
	}
	
	@Test
	public void ElementsAutomation()
	{
		System.out.println("elements ui automation tool");
	}
	
	
}
