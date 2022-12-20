package Others;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class generic {
	WebDriver driver;
	
	
	
	public static void explicitWait(WebDriver driver, By locator, String Condition) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		if(Condition.equalsIgnoreCase("ElementLocated"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		else if(Condition.equalsIgnoreCase("ElementClickable"))
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		
	}
	
	public static void scrollElement(WebDriver driver, By locator)
	{
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}
	
	
	public static void HighlightElement(WebDriver driver, By locator)
	{
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(locator));
		
	}
	
	public static void switchWindow(WebDriver driver)
	{
		Set<String> windows = driver.getWindowHandles();
		List<String> listWindows= new ArrayList<String> (windows);
		String parentWindow = listWindows.get(0);
		String childWindow = listWindows.get(1);
		if(driver.getWindowHandle().equals(parentWindow))
			driver.switchTo().window(childWindow);
		else
			driver.switchTo().window(parentWindow);
		
		
		
	}
	
	public void giveRaing(WebDriver driver, By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(locator)).perform();
		
	}
	
	
	public static void jsClick(WebDriver driver, By locator)
	{
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", driver.findElement(locator));
	}
	public static void jsratingClick(WebDriver driver, By locator)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('data-value', '4');", driver.findElement(locator));
	}
	
	public static boolean isElementPresent(WebDriver driver, By locator)
	{
		try {
			driver.findElement(locator);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	
	
}
