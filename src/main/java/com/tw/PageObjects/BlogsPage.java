package com.tw.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.tw.Base.TestBase;

public class BlogsPage extends TestBase{
	
	@FindBys({@FindBy(xpath="//a[@role='button']")})
	public List<WebElement> blogs; 
	
	
	
	public boolean verifyBlogCreated(){
		int size=blogs.size();
		return blogs.get(size-1).isDisplayed();
	}
	
	
}
