package com.org.browerserstack;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class BrowserTest 
{
	
	 public static final String USERNAME = "dattataral1";
	  public static final String AUTOMATE_KEY = "7Kta7iCixxKiAwPpqLRd";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 
	@Test
	public void start() throws MalformedURLException
	{
		System.out.println("we are running in AWS>jenkins>browserstack");
	
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "Safari");
			caps.setCapability("browser_version", "5.1");
		  //  caps.setCapability("device", "iPhone 8 Plus");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "11");
		    caps.setCapability("resolution", "1024x768");
		    caps.setCapability("name", "Bstack-[Java] Sample Test");

		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		    
		    driver.get("http://demosite.center/wordpress/wp-login.php");
		    WebElement username=driver.findElement(By.id("user_login"));
			   username.sendKeys("admin");
			   

			   WebElement password=driver.findElement(By.id("user_pass"));
			   password.sendKeys("demo123");
			   

			   WebElement btn=driver.findElement(By.id("wp-submit"));
			   btn.click();
			   

		    System.out.println(driver.getTitle());
		    driver.quit();
		    
		    System.out.println("end the browserstack");
	  }
	}


