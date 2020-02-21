package com.crm.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Test_base;
import com.crm.qa.pages.Contact_Page;
import com.crm.qa.pages.Home_Page;
import com.crm.qa.pages.Login_Page;

public class HomePageTest extends Test_base {
	
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
		
		//Just adding comments
	}
	
	
	@Test(priority=1)
	public void VeriyHomeTitle(){
		String expected_Title=homePage.verifyHomePageTitle();
		String Actual_Title="Cogmento CRM";
		Assert.assertEquals(Actual_Title, expected_Title);
		Reporter.log("Log says -- Assert pass",true);
	}
	
	@Test(priority=2)
	public void VerifyUserLabel(){
		String label = homePage.verifyLabel();
		System.out.println("current lable is-->"+label);
	}
	

	@Test(priority=3)
	public void ContactPages() throws IOException, InterruptedException{
		ContactPage=homePage.clickOnContactLinks();
		Thread.sleep(5000);
		String titles=driver.getTitle();
		System.out.println(titles);
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
