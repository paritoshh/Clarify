package com.gui.testing.facebook.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.rest.clarify.cases.stepdefination.MainTestCase;

public class CreateDriverInstance {
	
	public WebDriver generateDriverInstance() {
		WebDriver driver;
		if(MainTestCase.getValue("browser").equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
			 driver=new ChromeDriver();
			 }
		else if(MainTestCase.getValue("browser").equalsIgnoreCase("firefox")) {
			 driver=new FirefoxDriver();
		}
		else if(MainTestCase.getValue("browser").equalsIgnoreCase("ie")) {
			 driver=new InternetExplorerDriver();
		}
		else{
			 driver=new ChromeDriver();
		}
		driver.get(MainTestCase.getValue("applicationUrl"));
		return driver;
	}//End of method generateDriverInstance
	
	public void closeDriverInstance(WebDriver driver) {
		driver.quit();	
	}
}/*End of class CreateDriverInstance*/


