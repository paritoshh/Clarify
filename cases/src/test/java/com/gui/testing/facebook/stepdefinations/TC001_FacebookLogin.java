package com.gui.testing.facebook.stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.gui.testing.facebook.base.CreateDriverInstance;
import com.gui.testing.facebook.base.World;
import com.gui.testing.facebook.utility.LoginPageFactory;
import com.rest.clarify.cases.stepdefination.MainTestCase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class TC001_FacebookLogin extends CreateDriverInstance {
/*
 * Login to Facebook with valid credential
 */
	private World world;

    public TC001_FacebookLogin(World world) {
        this.world = world;
    }
	WebDriver driver;
	LoginPageFactory pageElement;//=new LoginPageFactory(driver);

	
	@Given("^User is on Loginpage$")
	public void user_is_on_Loginpage() {
		CreateDriverInstance driverInstance=new CreateDriverInstance();
		driver=driverInstance.generateDriverInstance();
		
	}

	@Given("^User enter Username$")
	public void user_enter_Username() {
		pageElement=new LoginPageFactory(driver);
		pageElement.setUsername(MainTestCase.getValue("username"));
	}

	@Given("^User enter Password$")
	public void user_enter_Password() {
		pageElement=new LoginPageFactory(driver);
		pageElement.setPassword(MainTestCase.getValue("password"));
	}

	@When("^User click on LogIn button$")
	public LoginPageFactory user_click_on_LogIn_button() {
		pageElement=new LoginPageFactory(driver);
		pageElement.setLogin();
		return new LoginPageFactory(driver);
		
	}

	@Then("^User should able to login successfully$")
	public void user_should_able_to_login_successfully() {
		String currentURL =driver.getCurrentUrl();
		Assert.assertTrue("Not able to login to Facebook Page,please check credentials", currentURL.equalsIgnoreCase("https://www.facebook.com/"));
		//https://www.facebook.com/
		driver.close();
	}
	@Then("^User close the browser$")
	public void user_close_the_browser() {
		driver.close();
	}
	@Given("^User enter Password as(.+)$")
	public void user_enter_Password_as(String password) {
		pageElement=new LoginPageFactory(driver);
		pageElement.setPassword(password);
	}

	@Then("^User should not able to login$")
	public void user_should_not_able_to_login() {
		String currentURL =driver.getCurrentUrl();
		Assert.assertTrue("Not able to login to Facebook Page,please enter correct password", currentURL.equalsIgnoreCase("https://www.facebook.com/"));
		
	}
}
