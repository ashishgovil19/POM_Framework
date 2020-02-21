package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Test_base;
import com.crm.qa.pages.Home_Page;
import com.crm.qa.pages.Login_Page;

public class LoginPageTest extends Test_base{
	
	 Login_Page login;
	 Home_Page homePage;

	@BeforeMethod
	public void setup() throws IOException{
		initialiseDriver();
		 login = new Login_Page();
		}
	
	@Test(priority=1)
	public void fgtPwdVerify(){
		boolean result=login.forgotpwdDisplay();
		System.out.println("forgotPwd is displaying if True else not if false-->"+result);
		Assert.assertTrue(result);
		Reporter.log("Forgot pwd is displaying--"+result,true);
	}
	
//Each test is running in new browser - Best practice. AS ALL TC is independent of each other
	@Test(priority=2)
	public void LoginPageTitle(){
		String ActualTitle=login.validateTitle();
		String expectedTitle=driver.getTitle();
		
		Assert.assertEquals(ActualTitle, expectedTitle);
		System.out.println("actual title is-->"+ActualTitle);
		System.out.println("actual title is-->"+expectedTitle);
		
		Reporter.log("Assert was made here",true);
		
	}

	@Test(priority=3)
	public void loginTest() throws IOException{
		 homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
