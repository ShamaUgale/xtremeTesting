package com.tw.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.tw.Base.TestBase;

public class BaseTest{

	protected WebDriver driver;
	
	
	
	
	@BeforeSuite
	public void setUp() throws IOException{
		TestBase base= new TestBase();
		base.initialize();
		this.driver=base.driver;
		base.driver.navigate().to(base.config.getProperty("TestURL"));
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
