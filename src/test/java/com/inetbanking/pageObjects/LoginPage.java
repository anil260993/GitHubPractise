package com.inetbanking.pageObjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
	
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement textUserName;
	
@FindBy(xpath="//input[@name='password']")
@CacheLookup
public static
WebElement textPwd;


	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginBtn;
	
	
	public void setUserName(String username) throws IOException {
		textUserName.sendKeys(username);

	}
	public void setPassword(WebElement textPwd) {
		
		JavascriptExecutor jsExecutor=(JavascriptExecutor)ldriver;
		jsExecutor.executeScript("arguments[0].value='AsepYpe';", textPwd);
		//textUserName.sendKeys(pwd);
	}
	public void clickLoginButton() {
		loginBtn.click();
		
	}
	
}
