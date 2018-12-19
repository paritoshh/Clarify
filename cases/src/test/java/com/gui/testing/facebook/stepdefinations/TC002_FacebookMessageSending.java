package com.gui.testing.facebook.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gui.testing.facebook.base.World;
import com.gui.testing.facebook.utility.LoginPageFactory;

import cucumber.api.java.en.Then;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TC002_FacebookMessageSending {
	private World world;

public TC002_FacebookMessageSending(World world) {
    this.world = world;
}
	
	WebDriver driver;
	LoginPageFactory pageElement;
	
	@Then("^User send message to(.+)$")
	public void user_send_message_to(String messageTo) {
		driver=new ChromeDriver();
		pageElement=new LoginPageFactory(driver);
		pageElement.sendMessagetoTab();
		/*driver.findElement(By.xpath("//*[@id='js_7h']/a/div/div[3]")).click();
		driver.findElement(By.xpath("//*[@id='cch_f34453ee6b70d4a']/div/div/div[2]/div/div/div/div")).sendKeys("Hello I am Testing,please ignore");
		driver.findElement(By.xpath("//a[@label='send']")).click();//sendKeys(Keys.ENTER);*/
	}

	@Then("^User minimize the message tab and close the tab$")
	public void user_minimize_the_message_tab_and_close_the_tab() {
		
	}

	@Then("^User logout the facebook application$")
	public void user_logout_the_facebook_application() {
		
	}
}
