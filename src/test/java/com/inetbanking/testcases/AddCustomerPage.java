package com.inetbanking.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage {
	
	@FindBy(how=How.NAME, using="aaa")
	WebElement element;
	
	@FindBy(how=How.ID_OR_NAME,using="bbb")
	WebElement element1;

}
