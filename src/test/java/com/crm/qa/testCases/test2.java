package com.crm.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class test2 {

	public static void main(String[] args) throws IOException, InterruptedException {

		

		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
		System.setProperty("webdriver.gecko.driver", "C:\\Ashish\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");

		WebDriver driver =new FirefoxDriver();
	driver.manage().window().maximize();
	
	driver.get("https://ui.cogmento.com/");
	driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("ashish.govil19@gmail.com");
	
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("AG@mymother5");
	driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
	
	Thread.sleep(4000);
	System.out.println(driver.getTitle());
	
	driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();

	}

}
