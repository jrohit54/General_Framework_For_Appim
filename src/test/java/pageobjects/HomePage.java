package pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import util.WaitUtil;

public class HomePage {

	public static AppiumDriver driver;
    Logger logger=Logger.getLogger(HomePage.class);

	@FindBy(xpath="//*[@index=0][@class='android.widget.ImageView'][@resource-id='com.intsig.camscanner:id/widget_imageview']")
	public List<WebElement> topMenuElements;

	
	@FindBy(xpath="//*[@resource-id='com.intsig.camscanner:id/title'][@class='android.widget.TextView']")
	public List<WebElement> allNavigationElements;

	
	@FindBy(id="com.intsig.camscanner:id/cb_select")
	public List<WebElement> allGalleryElements;
	
	@FindBy(id="com.intsig.camscanner:id/tv_export")
	public WebElement importButtonElement;
	
	@FindBy(id="com.intsig.camscanner:id/widget_imageview")
	public List<WebElement> bottomBarElements;

	
	@FindBy(id="com.intsig.camscanner:id/tv_title")
	public WebElement titleElement;
	
	public HomePage(AppiumDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnThreeDotIcon()
	{
		WaitUtil.explicitWait(driver, topMenuElements.get(2), 5);
		topMenuElements.get(2).click();
		logger.info("**clicked on the 3 dot icon**");
	}

	public void clickOnImportFromGalleryOption()
	{
		WaitUtil.explicitWait(driver, allNavigationElements.get(0), 5);
		for (WebElement element : allNavigationElements) {

			if(element.getText().equals("Import from Gallery"))
			{
				element.click(); 	
				System.out.println("clicked on import from gallery");
				break;
			}
		}
		logger.info("**clicked on the import from gallery option **");
	}

	public void selectImageToUpload(int index)
	{  
		WaitUtil.explicitWait(driver, allGalleryElements.get(index), 5);
		allGalleryElements.get(index).click();
		logger.info("**selected an image to upload **");
	}

	
	public void clickOnImport()
	{
		
		if(importButtonElement.isEnabled())
		{
			importButtonElement.click();
		}
		logger.info("**clicked on the import button**");
	}
	
	
	public void clickOnConfirmIcon()
	{
		WaitUtil.explicitWait(driver, bottomBarElements.get(4), 5);
		bottomBarElements.get(4).click();
		logger.info("**clicked on the confirm icon**");
		
	}
	
	public String getTitleAfterImport()
	{
		WaitUtil.explicitWait(driver, titleElement, 5);
		return titleElement.getText();
	}
	

}
