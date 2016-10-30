package com.tw.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tw.Base.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(id="userName")
	public WebElement userNameTxtBox;
	
	@FindBy(id="password")
	public WebElement passwordTxtBox;
	
	@FindBy(xpath="//button[text()='Login']")
	public WebElement loginBtn;
	

	
	public BlogPage doLogin(String userName, String password){
		userNameTxtBox.sendKeys(userName);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		return new BlogPage();
	}
	
	
	
}
