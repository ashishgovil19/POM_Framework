package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Test_base;

public class Home_Page extends Test_base{

	@FindBy(xpath="//div/span[text()='Ashish Govil']")
	WebElement userLabel;
		
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement Contacts;

	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement Deals;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement Tasks;
	
	public Home_Page(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLabel(){
		return userLabel.getText();
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public Contact_Page clickOnContactLinks() throws IOException{
		Contacts.click();
		return new Contact_Page();
	}
	
	public Deals_Page clickOnDealsLinks() throws IOException{
		Deals.click();
		return new Deals_Page();
	}
	
	public Task_Page clickOnTaskLinks() throws IOException{
		Tasks.click();
		return new Task_Page();
	}



}
