package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Test_base;
import com.crm.qa.pages.Contact_Page;
import com.crm.qa.pages.Home_Page;
import com.crm.qa.pages.Login_Page;

public class ContactPage extends Test_base {
	Login_Page login;
	Home_Page homePage;
	Contact_Page ContactPage;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException{
		initialiseDriver();
		login = new Login_Page();
		ContactPage=new Contact_Page();
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000);
		homePage.clickOnContactLinks();
		Thread.sleep(2000);
	}
	
	@Test
	public void contactCheckBox(){
		ContactPage.SelectcontactCheck("Ashish Govil");
		
	}
	
	@Test
	public void MultiplecontactCheckBox(){
		ContactPage.SelectMultiplecontactCheck("Ashish Govil");
		ContactPage.SelectMultiplecontactCheck("Rajbir khan");
		
	}
	
	@Test
	public void GettotalNames(){
		ContactPage.GetAllName();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
