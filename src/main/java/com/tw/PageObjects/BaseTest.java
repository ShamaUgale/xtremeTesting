package com.tw.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.tw.Base.TestBase;

public class BaseTest{

	protected WebDriver driver;
	
	/*
	 * initialize the driver and navigate to testURL placed in config.properties file
	 */
	@BeforeSuite
	public void setUp() throws IOException{
		TestBase base= new TestBase();
		base.initialize();
		this.driver=base.driver;
		base.driver.navigate().to(base.config.getProperty("TestURL"));
	}
	
	/*
	 * close the browser instance after the tests
	 */
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
