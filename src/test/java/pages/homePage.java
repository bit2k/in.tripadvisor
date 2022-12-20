package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Others.generic;

public class homePage extends generic{
	WebDriver driver;
	
	By txt_Search = By.xpath("//input[@placeholder='Where to?']");
	By SearchResult_1 = By.xpath("//div[@id='typeahead_results']/a");
	By Heading_1 = By.xpath("//h1[@id='HEADING']");
	By View_Deal = By.xpath("//div[text()='View deal']");
	
	
	
	public homePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void search() throws InterruptedException
	{
		driver.findElement(txt_Search).click();
		driver.findElement(txt_Search).sendKeys("Club Mahindra");
		Thread.sleep(5000);
		explicitWait(driver,SearchResult_1 , "ElementLocated");
	}
	
	public void selectFirstResult()
	{
		driver.findElement(SearchResult_1).click();
		explicitWait(driver,Heading_1 , "ElementLocated");
		//explicitWait(driver,View_Deal , "ElementClickable");
		HighlightElement(driver,Heading_1);
	}
	
	
	
	
}
