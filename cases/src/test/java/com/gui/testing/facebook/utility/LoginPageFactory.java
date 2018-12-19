package com.gui.testing.facebook.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	WebDriver driver;
	
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="pass")
	WebElement pwd;
	
	@FindBy(xpath="//label[@id=\"loginbutton\"]/input")
	WebElement login;
	
	@FindBy(xpath="//*[@id='js_7h']/a/div/div[3]")
	WebElement messageTab;
	
	public  LoginPageFactory (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String username) {
		userName.clear();
		userName.sendKeys(username);
	}

	public void setPassword(String password) {
		pwd.sendKeys(password);
	}

	public void setLogin() {
		login.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sendMessagetoTab() {
		messageTab.click();
	}
	
	
	
}/*End of class LoginPageFactory */

