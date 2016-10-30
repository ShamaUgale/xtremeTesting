package com.tw.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	 public Properties config=null;
	 public WebDriver driver=null;
	public static final String PROJECT_PATH=System.getProperty("user.dir");
	


	/*
	 * Initializes config.properties file and driver object based on the value of "browserType" on config.properties file
	 * 
	 */
	public void initialize() throws IOException{
		
		if(config==null){
			config=new Properties();
			FileInputStream ip= new FileInputStream(new File(PROJECT_PATH+"\\src\\main\\resources\\com\\tw\\config\\config.properties"));
			config.load(ip);
		}
		
		if(driver==null){
		String browser=config.getProperty("browserType");
		String chromeDriverPath=PROJECT_PATH+"\\src\\test\\resources\\chromedriver.exe";
		String IEDriverPath=PROJECT_PATH+"\\src\\test\\resources\\IEDriverServer.exe";
		int implicitWait=Integer.parseInt(config.getProperty("implicitWait"));

		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver= new ChromeDriver();
		}else if(browser.equalsIgnoreCase("FF")){
			driver= new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", IEDriverPath);
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
	}
	
}
