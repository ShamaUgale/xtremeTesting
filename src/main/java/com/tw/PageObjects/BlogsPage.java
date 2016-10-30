package com.tw.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.tw.Base.TestBase;

public class BlogsPage extends TestBase{
	
	@FindBys({@FindBy(xpath="//a[@role='button']")})
	public List<WebElement> blogs; 
	
	@FindBy(xpath="//*[@id='collapse0']/div/span[1]")
	public WebElement nameTxt; 
	
	@FindBy(xpath="//*[@id='collapse0']/div/span[2]")
	public WebElement ageTxt; 
	
	@FindBy(xpath="//*[@id='collapse0']/div/span[3]")
	public WebElement experienceTxt; 
	
	@FindBy(xpath="//*[@id='collapse0']/div/span[4]")
	public WebElement blogContentTxt; 
	
	@FindBy(xpath="//*[@id='collapse0']/div/span[5]")
	public WebElement professionTxt; 
	
	
	/*
	 * verify if the currently added blog is listed on blogs listing page.
	 * If listed , then verify the contents of the blog added.
	 */
	public boolean verifyBlogCreated(String name, String age, String exp, String blogArea,String profession ){
		int size=blogs.size();
		boolean isNameValid=nameTxt.getText().trim().equalsIgnoreCase(name);
		boolean isAgeValid= ageTxt.getText().trim().equalsIgnoreCase(age);
		boolean isExperienceValid= experienceTxt.getText().trim().equalsIgnoreCase(exp);
		boolean isBlogContentValid= blogContentTxt.getText().trim().equalsIgnoreCase(blogArea);
		boolean isProfessionValid= professionTxt.getText().trim().equalsIgnoreCase(profession);
		
		if(blogs.get(size-1).isDisplayed()){
			if(isNameValid && isAgeValid && isBlogContentValid && isExperienceValid && isProfessionValid){
				return true;
			}else{
				return false;
			}
		}else{
			return isProfessionValid;
		}
	}
	
	
}
