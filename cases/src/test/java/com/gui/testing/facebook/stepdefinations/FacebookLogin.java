package com.gui.testing.facebook.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gui.testing.facebook.base.CreateDriverInstance;
import com.rest.clarify.cases.stepdefination.MainTestCase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookLogin {
/*
 * Login to Facebook with valid credential
 */
	
	public  FacebookLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriver driver;
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(id="u_0_w")
	WebElement login;
	
	@Given("^User is on Loginpage$")
	public void user_is_on_Loginpage() {
		CreateDriverInstance driverInstance=new CreateDriverInstance();
		driver=driverInstance.generateDriverInstance();
		
	}

	@Given("^User enter Username  as (.+)$")
	public void user_enter_Username_as_(String username) {
		//this.username.clear();
		//this.username.sendKeys(username);
		driver.findElement(By.id("email")).sendKeys(username);
	}

	@Given("^User enter Password as (.+)$")
	public void user_enter_Password_as(String password) {
		this.password.sendKeys(password);
	}

	@When("^User click on LogIn button$")
	public void user_click_on_LogIn_button() {
		//login.click();
	}

	@Then("^User should able to login successfully$")
	public void user_should_able_to_login_successfully() {
		
	}

}
