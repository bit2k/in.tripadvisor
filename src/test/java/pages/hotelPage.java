package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Others.generic;

public class hotelPage extends generic{
	WebDriver driver;
	
	
	By View_Deal = By.xpath("//div[text()='View deal']");
	By btn_writeReview = By.xpath("//a[text()='Write a review']");
	
	public hotelPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void writeReview() throws InterruptedException
	{
		//scrollElement(driver, View_Deal);
		scrollElement(driver, btn_writeReview);
		Thread.sleep(2000);
		//driver.findElement(btn_writeReview).click();
		jsClick(driver, btn_writeReview);
		Thread.sleep(2000);
		switchWindow(driver);
		
	}
	
	
}
