package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class WaitUtil {

	
	public static void explicitWait(AppiumDriver driver,WebElement ele,long t1)
	{
		
	WebDriverWait webDriverWait = new WebDriverWait(driver, t1);
    webDriverWait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
	}
	
	
}
