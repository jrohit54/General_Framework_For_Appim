package scenerios;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Base;
import pageobjects.HomePage;

public class UploadDocumentTest extends Base {

	
	@Test
	public void testImportScenerio()
	{
		try {
			start_Server();
			init_App();
			HomePage homePage=new HomePage(driver);
			homePage.clickOnThreeDotIcon();
			homePage.clickOnImportFromGalleryOption();
			homePage.selectImageToUpload(1);
			homePage.clickOnImport();
			homePage.clickOnConfirmIcon();
			Thread.sleep(3000);
			homePage.clickOnConfirmIcon();
			String titleAfterImport = homePage.getTitleAfterImport();
			
			Date date=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			String format = sf.format(date);
		

			Assert.assertTrue(titleAfterImport.contains(format));
			stop_server();
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
	}
	
	
}
