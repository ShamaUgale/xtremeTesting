package com.tw.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tw.Base.TestBase;

public class BlogPage extends TestBase{

	
	
	@FindBy(id="name")
	public WebElement nameTextBox;
	
	@FindBy(id="age")
	public WebElement ageTextBox;
	
	@FindBy(id="blogArea")
	public WebElement blogTextBox;
	
	@FindBy(id="profession")
	public WebElement professiondropDown;
	
	@FindBy(xpath="//input[@value='0-3']")
	public WebElement experience0to3Radio;
	
	@FindBy(xpath="//input[@value='3-7']")
	public WebElement experience3to7Radio;
	
	@FindBy(xpath="//input[@value='7-15']")
	public WebElement experience7to15Radio;
	
	@FindBy(xpath="//input[@value='15+']")
	public WebElement experience15Radio;
	
	@FindBy(xpath="//button[@name='button' and @type='submit']")
	public WebElement saveBlogBtn;
	
	@FindBy(linkText="Blogs")
	public WebElement blogsLink;
	
	
	
	public BlogPage addNewBlog(String name, String age, String exp, String blogArea,String profession ){
		nameTextBox.sendKeys(name);
		ageTextBox.sendKeys(age);
		switch (exp) {
		case "0-3": experience0to3Radio.click();
			break;
		case "3-7": experience3to7Radio.click();
			break;
		case "7-15": experience7to15Radio.click();
			break;
		case "15+": experience15Radio.click();
			break;
		default: System.out.println("Invalid experience entered.");
			break;
		}
		blogTextBox.sendKeys(blogArea);
		Select sec= new Select(professiondropDown);
		sec.selectByVisibleText(profession);
		saveBlogBtn.click();
		
		return new BlogPage();
	}
	
	public BlogsPage clickOnBlogs(){
		blogsLink.click();
		return new BlogsPage();
	}
	
}
