package in.tripadvisor;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.homePage;
import pages.hotelPage;
import pages.reviewPage;

public class tripadvisorReview {
	WebDriver driver;
	homePage hp;
	reviewPage rp;
	hotelPage hop;
	
	
	@BeforeTest(groups="Master")
	void setup()
	{
		driver = new ChromeDriver();
		
		driver.get("https://www.tripadvisor.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		
	}
	@Test(groups="Master")
	void mainTest() throws InterruptedException, AWTException
	{
		hp = new homePage(driver);
		hop = new hotelPage(driver);
		rp = new reviewPage(driver);
		
		hp.search();
		hp.selectFirstResult();
		hop.writeReview();
		rp.reviewWriting();
	}
	
	@AfterTest(groups="Master")
	void tearDown()
	{
		driver.quit();
	}
	
	
	
	
}
