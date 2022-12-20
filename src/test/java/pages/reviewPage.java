package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Others.generic;

public class reviewPage extends generic{
	WebDriver driver;
	
	By propertyName = By.xpath("//h2[@class='propertyname']");
	By propertyTitle = By.xpath("//div[@data-automation='review-title']");
	//div[@data-automation='review-title']
	By rating = By.xpath("(//*[@class='yGxQr'])[4]");
	
	
	//interface1 Locators
	By int1_overallRating = By.xpath("(//*[@class='yGxQr'])[4]");
	By int1_travelRange = By.xpath("//span[text()='Select one']");
	By int1_travelRangeValue = By.xpath("//span[@id='menu-item-2022-01-01']");
	By int1_travelWith = By.xpath("//span[text()= 'Solo']");
	By int1_txtReview = By.xpath("//textarea[@id='review-text']");
	By int1_txtTitle = By.xpath("//input[@id='review-title']");
	By int1_upload = By.xpath("//div[@data-automation='photo-upload-trigger']");
	By int1_Submit = By.xpath("//span[text()='Submit review']");
	By int1_LoginHeader = By.xpath("//div[@id='coreHeader']");
	
	
	//interface2 Locators
	By bubble_rating = By.xpath("//span[@id='bubble_rating']");
	By int2_txtTitle = By.xpath("//input[@id='ReviewTitle']");
	By int2_reviewText = By.xpath("//textarea[@id='ReviewText']");
	By int2_typeOfTrip = By.xpath("//div[text()='Solo']");
	By int2_travelTime = By.xpath("//select[@id='trip_date_month_year']");
	By int2_oprionJanuary = By.xpath("//select[@id='trip_date_month_year']/option[contains(text(), 'January')]");
	By int2_expensive  = By.xpath("//*[@id=\"DQ_TAGRADIO\"]/div[2]/div[2]");
	By int2_txtTip = By.xpath("//textarea[@id='ROOM_TIP']");
	By int2_addPhoto = By.xpath("//*[@id=\"MAIN_COL\"]/div/fieldset[1]/div[4]/div[2]/div[1]/div");
	By int2_declearation = By.xpath("//input[@id='noFraud']");
	By int2_submitReview = By.xpath("//div[@id='SUBMIT']");
	By int2_addPhotoUpload = By.xpath("//*[@id=\"uploader-dlg\"]/div[5]/div/div[1]");
	//input[@id='noFraud']
	By upload_radioType = By.xpath("//input[@id='cat_2c1635aa-f98f-4b34-8418-3ad480eef74b_8']");
	By upload_photoDescrption = By.xpath("//*[@id=\"listitem-2c1635aa-f98f-4b34-8418-3ad480eef74b\"]/form/div[2]/textarea");
	By upload_button = By.xpath("//*[@id=\"uploader-dlg\"]/div[10]/div[2]/div");
	
	
	
	By bubble_rating_Service = By.xpath("//span[@id='qid12_bubbles']");
	By bubble_rating_Rooms = By.xpath("//span[@id='qid11_bubbles']");
	By bubble_rating_Cleanliness = By.xpath("//span[@id='qid14_bubbles']");
	
	
	
	
	
	
	
	
	
	
	
	
	
	public reviewPage(WebDriver driver)
	{
		this.driver = driver;
			
	}
	
	public void reviewWriting() throws InterruptedException, AWTException
	{
		
		if(isElementPresent(driver, propertyTitle))
		{
			reviewOnInterface1();
		}
		else
			reviewOnInterface2();
		//HighlightElement(driver, propertyName);
		//giveRaing(driver, rating);
		//driver.findElement(rating).click();
		//driver.findElement(rating_x).getAttribute(null)
		//jsratingClick(driver, rating_x);
	}
	
	void reviewOnInterface1() throws InterruptedException
	{
		HighlightElement(driver, propertyTitle);
		driver.findElement(int1_overallRating).click();
		//jsClick(driver, int1_overallRating);
		driver.findElement(int1_travelRange).click();
		explicitWait(driver,  int1_travelRangeValue,  "ElementLocated");
		driver.findElement(int1_travelRangeValue).click();
		jsClick(driver, int1_travelWith); //select Solo
		driver.findElement(int1_txtReview).click();
		driver.findElement(int1_txtReview).sendKeys("This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!This is done by automation Testing!!!");
		
		driver.findElement(int1_txtTitle).click();
		driver.findElement(int1_txtTitle).sendKeys("This is Review Title Section. Writing with Automation.... Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....Writing with Automation....");
		//int1_travelWith
		driver.findElement(int1_Submit).click();
		Thread.sleep(5000);
		
		driver.switchTo().frame(4);
		HighlightElement(driver, int1_LoginHeader);
		String HeaderTxt = driver.findElement(int1_LoginHeader).getText();
		Assert.assertEquals(HeaderTxt, "Log in to continue leaving your review.");
		
	}
	
	void reviewOnInterface2() throws AWTException, InterruptedException
	{
		HighlightElement(driver, propertyName);
		//jsratingClick(driver, rating_x);
		//new Actions(driver).moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='bubble_rating']"))), 50, 0).click().build().perform();
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(bubble_rating)), 40, 0).click().build().perform();
		driver.findElement(int2_txtTitle).click();
		driver.findElement(int2_txtTitle).sendKeys("Title: Second interface title section Test");
		driver.findElement(int2_reviewText).click();
		driver.findElement(int2_reviewText).sendKeys("Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....Review Section Test by Automation....");
		driver.findElement(int2_typeOfTrip).click();
		
		
		driver.findElement(int2_travelTime).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(int2_oprionJanuary));
		driver.findElement(int2_oprionJanuary).click();
		
		action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(bubble_rating_Service)), 50, 0).click().build().perform();
		
		//action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(bubble_rating_Rooms)), 40, 0).click().build().perform();
		
		//action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(bubble_rating_Cleanliness)), 30, 0).click().build().perform();
		
		driver.findElement(int2_expensive).click();
		driver.findElement(int2_txtTip).click();
		driver.findElement(int2_txtTip).sendKeys("Rooms on the North side are quieter");
		
		/*
		driver.findElement(int2_addPhoto).click();
		
		driver.findElement(int2_addPhotoUpload).click();
		uploadPhoto();
		
		
		
		jsClick(driver, int2_declearation);
		*/
		
		driver.findElement(int2_submitReview).click();
		Thread.sleep(5000);
		driver.switchTo().frame(3);
		HighlightElement(driver, int1_LoginHeader);
		String HeaderTxt = driver.findElement(int1_LoginHeader).getText();
		Assert.assertEquals(HeaderTxt, "Log in to continue leaving your review.");
		
	}

	private void uploadPhoto() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		//String path = System.getProperty("user.dir")+"\\Photos\\club-mahindra.jpg";
		StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\Photos\\club-mahindra.jpg");
		Robot rt= new Robot();
		rt.delay(5000);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_V);
		
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_V);
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		driver.findElement(upload_radioType).click();
		driver.findElement(upload_photoDescrption).click();
		driver.findElement(upload_photoDescrption).sendKeys("Nothing!!!");
		
		driver.findElement(upload_button).click();
		
		driver.switchTo().defaultContent();
		
	}

	
	
	
}
