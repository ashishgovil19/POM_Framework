package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Test_base;

public class Contact_Page extends Test_base{

	public Contact_Page() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement ContactsLabel;
	

	
	public boolean verifyContactLabel(){
		return ContactsLabel.isDisplayed();
		
	}
	
	public void SelectcontactCheck(String name){
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
	}
	
	public void SelectMultiplecontactCheck(String name){
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
	}
	
	public void GetAllName(){
		List<WebElement> name=driver.findElements(By.xpath("//tbody/tr/td[2]"));
		for(int i=0; i<name.size();i++){
			 String data = name.get(i).getText();
			 System.out.println(data);
		}
			
		
	}

}
