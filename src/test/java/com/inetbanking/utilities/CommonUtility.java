package com.inetbanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.inetbanking.driverManager.BaseClass;
 
public class CommonUtility extends BaseClass {


	
	public static void captureScreenShot(WebDriver driver,String Testcasename) {
		String    timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath="D:\\Selenium_interview_Practice\\inetBankingV1\\ss\\"+Testcasename+".png";
	        // Specify the location to save the screenshot
		 File   destination = new File(screenshotpath);

	        try {
	            // Copy the screenshot to the specified location
	            FileHandler.copy(screenshot, destination);
	            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
	}
	        catch (Exception e) {
	        	  System.out.println("Failed to save screenshot: " + e.getMessage());
			}
}
}
