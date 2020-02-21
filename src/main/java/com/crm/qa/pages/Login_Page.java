package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Test_base;

public class Login_Page extends Test_base {

	public Login_Page() throws IOException {
		//super();
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='E-mail address']") 
	private WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']") 
	private WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") 
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]") 
	private WebElement signUp;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]") 
	private WebElement ForgotPwd;
	
	
	public String validateTitle(){
		return driver.getTitle();
	}
	
	
	public boolean forgotpwdDisplay(){
		return ForgotPwd.isDisplayed();
	}
	
	public Home_Page login(String un, String pwd) throws IOException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new Home_Page();
	}
	
	
	

	

}
