package com.inetbanking.testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.driverManager.BaseClass;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.CommonUtility;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(readConfig.getUserName());
		logger.info("Username entreed::"+username);
		Thread.sleep(15000);
		lp.setPassword(LoginPage.textPwd);
		logger.info("pwd entreed::"+password);
		Thread.sleep(15000);
		lp.clickLoginButton();
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		
			Assert.assertTrue(true);
			
		}
		else {
			System.out.println("Hello inserting into login to push to git hub");
			System.out.println("before screenshot code in testcase ");
			CommonUtility.captureScreenShot(driver, "loginTest");
			Assert.assertTrue(false);
			
			 System.out.println("after screenshot code in testcase ");
			
		}
		
		
	}

}
