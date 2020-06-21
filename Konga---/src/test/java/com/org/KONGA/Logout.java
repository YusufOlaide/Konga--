package com.org.KONGA;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logout {

	WebDriver driver;
	Properties property;
	InputStream fs;

	
	public Properties getObjectRepository() throws IOException{
		property = new Properties();
		FileInputStream fs = null;
		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		property.load(fs);
		
		return property;
	}
	
	@BeforeTest
	public void Initilazation() throws IOException {
			
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.jumia.com.ng/customer/account/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=1)
	public void Logout() throws InterruptedException, IOException {
		
		
        
		boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true ) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement Login_Email = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	Login_Email.sendKeys(property.getProperty("email"));
        	Login_Email.sendKeys(Keys.TAB);
        	
        	WebElement Login_Password = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	Login_Password.sendKeys(property.getProperty("password"));
        	
        	
        	
        	
        	Thread.sleep(5000);
        	
        }
        	
        driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        
        Thread.sleep(15000);
	
        driver.findElement(By.xpath("//label[contains(text(),'Hi, N')]")).click();
      
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[@class='btn _def -mvs']")).click();
        
        String actual = driver.getCurrentUrl();
        String expected = "https://www.jumia.com.ng/";
        
        Assert.assertEquals(actual, expected);
        
	}
	
	
	@AfterTest
	public void Closing() {
		
        driver.quit();
	}
	
}
