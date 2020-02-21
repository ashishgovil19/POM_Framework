package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.UserDataHandler;

import com.crm.qa.util.TestUtil;

public class Test_base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	//public Test_base() throws IOException{
	///	 prop=new Properties();
//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//crm//qa//config//config.properties");
		//prop.load(fis);
			
	//}
	
	//String browser=System.getProperty(prop.getProperty("url"));
	
	public static void initialiseDriver() throws IOException{
		
		 prop=new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//crm//qa//config//config.properties");
		 		prop.load(fis);
		 		
		 		System.out.println(prop.getProperty("browsers"));
		 		
		 		
		String browserName=prop.getProperty("browsers");
		if(browserName.equals("Mozilla")){
		
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
			System.setProperty("webdriver.gecko.driver", "C:\\Ashish\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
			else if(browserName.equalsIgnoreCase("Chrome")){
				driver=new ChromeDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//testUtil is a class in diff pack.. so its getting time from their.. Awesome
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
	
			
		}
		
	}

