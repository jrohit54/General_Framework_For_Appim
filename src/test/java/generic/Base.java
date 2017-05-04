package generic;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {

	static String appium_node_path="C:\\Appium\\node.exe";
	static String appium_js_path="C:\\Appium\\node_modules\\appium\\bin\\appium.js";
	static AppiumDriverLocalService service;
	public static AppiumDriver driver;

	
	public static void start_Server() throws InterruptedException
	{

		service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723)
				.usingDriverExecutable(new File(appium_node_path)).withAppiumJS(new File(appium_js_path)));


		service.start();
		if(service.isRunning())
		{
			System.out.println("started the appium server");
		}
		else
		{
			System.out.println("not able to start the appium server");
		}

		Thread.sleep(8000);
	}

	public static void init_App() throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();

		//device details
		dc.setCapability("deviceName", "Lenovo A7020a48");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "6.0");

		//app details
		dc.setCapability("appPackage", "com.intsig.camscanner");
		dc.setCapability("appActivity", "com.intsig.camscanner.MainMenuActivity");

		//appium server details

		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		Thread.sleep(5000);
		System.out.println("app get launched");
	}
	
	public static void stop_server() throws InterruptedException
	{
		if(service.isRunning())
		{
			service.stop();
			Thread.sleep(4000);
			System.out.println("stopped the appium server");
		}
		
	}
}
