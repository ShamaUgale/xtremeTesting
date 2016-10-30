package com.tx.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tw.Base.UserCredentials;
import com.tw.PageObjects.BaseTest;
import com.tw.PageObjects.BlogPage;
import com.tw.PageObjects.BlogsPage;
import com.tw.PageObjects.LoginPage;

public class BlogsTest extends BaseTest{
	
	
	LoginPage loginPageObjects;
	BlogPage blogPageObjects;
	BlogsPage blogsPageObjects;
	
	 UserCredentials credentials;
	
	 @BeforeClass
	 public void initPages(){
		 loginPageObjects= PageFactory.initElements(driver, LoginPage.class);
		 blogPageObjects= PageFactory.initElements(driver, BlogPage.class);
		 blogsPageObjects= PageFactory.initElements(driver, BlogsPage.class);
	 }
	
	@Test
	public void blogsTest(){
		
		credentials = new UserCredentials("admin", "admin");
		loginPageObjects.doLogin(credentials.getUserName(), credentials.getPassWord());
		blogPageObjects.addNewBlog("shama Ugale", "34", "3-7", "A test blog", "Teacher");
		blogPageObjects.clickOnBlogs();
		
		boolean isBlogCreated=blogsPageObjects.verifyBlogCreated();
		
		Assert.assertTrue(isBlogCreated, "Blog was not created.");
	}

}
