package com.tx.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tw.Base.BlogContent;
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
	BlogContent blogContent;
	
	 @BeforeClass
	 public void initPages(){
		 loginPageObjects= PageFactory.initElements(driver, LoginPage.class);
		 blogPageObjects= PageFactory.initElements(driver, BlogPage.class);
		 blogsPageObjects= PageFactory.initElements(driver, BlogsPage.class);
	 }
	
	@Test
	public void blogsTest(){
		
		credentials = new UserCredentials("admin", "admin");
		blogContent= new BlogContent("Shama Ugale", "34", "3-7", "A test Blog", "Engineer");
		loginPageObjects.doLogin(credentials.getUserName(), credentials.getPassWord());
		blogPageObjects.addNewBlog(blogContent.getName(),
				blogContent.getAge(), 
				blogContent.getExperience(), 
				blogContent.getBlogContent(), 
				blogContent.getProfession());
		blogPageObjects.clickOnBlogs();
		
		boolean isBlogCreated=blogsPageObjects.verifyBlogCreated(blogContent.getName(),
				blogContent.getAge(), 
				blogContent.getExperience(), 
				blogContent.getBlogContent(), 
				blogContent.getProfession());
		
		Assert.assertTrue(isBlogCreated, "Blog was not created.");
	}

}
