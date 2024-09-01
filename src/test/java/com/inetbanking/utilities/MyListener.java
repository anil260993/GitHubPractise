package com.inetbanking.utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Marker;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class MyListener implements ITestListener{
	 ExtentReports extent;
	  ExtentTest test;
	  ExtentSparkReporter htmlReporter;
	 
	public  void onTestStart(ITestResult result) {
		
			
		
		    
	  }

	 
	  public void onTestSuccess(ITestResult result) {
	    test=extent.createTest(result.getName());
	    test.log(Status.PASS,"Test case passed is::"+result.getName());
	    String screenshotpath=System.getProperty("user.dir")+"\\ss\\"+result.getName()+".png";
	    System.out.println("screenshotpath::"+screenshotpath);
		File f=new File(screenshotpath);
	
		//File f=new File(System.getProperty("user.dir")+"\\ss\\");
		if(f.exists()) {
			
			try {
				test.fail( "screenshot is below::"+test.addScreenCaptureFromPath(screenshotpath));
				
				System.out.println("attached SS to Extent report");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	  }

	 
	  public  void onTestFailure(ITestResult result) {
		 
		  test=extent.createTest(result.getName());
		    test.log(Status.FAIL,"Test case failed is::"+result.getName());
		   test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		    
			String screenshotpath=System.getProperty("user.dir")+"\\ss\\"+result.getName()+".png";
			
			System.out.println("screenshotpath::"+screenshotpath);
			File f=new File(screenshotpath);
		
			//File f=new File(System.getProperty("user.dir")+"\\ss\\");
			if(f.exists()) {
			
				try {
					test.fail( "screenshot is below::"+test.addScreenCaptureFromPath(screenshotpath));
					
					System.out.println("attached SS to Extent report");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		
			
				
			}
			
		
	  
	  public  void onTestSkipped(ITestResult result) {
		  test=extent.createTest(result.getName());
		    test.log(Status.SKIP,MarkupHelper.createLabel("Test case skipped is::"+result.getName(), ExtentColor.ORANGE));
		  }

		 
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  }
		  
		
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		
		  public void onStart(ITestContext context) {
			  String    timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			  String repName="Test-Report-"+timestamp+".html";

		         htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		        htmlReporter.config().setDocumentTitle("inetbanking test project");
		        htmlReporter.config().setReportName("Selenium Test Report");
		       
		        
		        htmlReporter.config().setTheme(Theme.DARK);

		        extent = new ExtentReports();
		        extent.attachReporter(htmlReporter);
		        extent.setSystemInfo("Tester", "Anil kumar");
		        extent.setSystemInfo("Environment", "QA");
		   
		  }

		  public void onFinish(ITestContext context) {
			  extent.flush();
			  }

	
	

}
