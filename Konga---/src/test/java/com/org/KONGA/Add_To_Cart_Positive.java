package com.org.KONGA;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Add_To_Cart_Positive {

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
		driver.get("https://www.jumia.com.ng/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=1)
	public void Verify_Page_Title() {
		String actual = driver.getTitle();
		String expected = "Jumia Nigeria | Online Shopping for Groceries, Cleaning Supplies, Home Essentials & More";
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority=2)
	public void Search_Product() throws InterruptedException, IOException {
		
		
        
        boolean Search = driver.findElement(By.xpath("//input[@id='fi-q']")).isDisplayed();
        
        if(Search ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement search_box = driver.findElement(By.xpath("//input[@id='fi-q']"));
        	search_box.sendKeys(property.getProperty("product"));
        	
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]"));
        	search_btn.click();
        	
        	
        	Thread.sleep(5000);	
    
        	
        }
        
        String actual = driver.getCurrentUrl();
        String expected = "https://www.jumia.com.ng/phones-tablets/samsung/?bcsq=1&q=galaxy+s7";
        
        Assert.assertEquals(actual, expected);
        		
		
	}
	
	@Test (priority=3)
	public void Add() throws InterruptedException, IOException {
		
		
        
        boolean Search = driver.findElement(By.xpath("//article[1]//a[1]//div[1]//img[1]")).isDisplayed();
        
        if(Search ==true) {
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("//article[1]//a[1]//div[1]//img[1]"));
        	search_btn.click();
        	
        	
        	Thread.sleep(5000);
        	
        	WebElement add_btn = driver.findElement(By.xpath("//button[@class='btn _prim _i -fw']//span[contains(text(),'Add to cart')]"));
        	add_btn.click();
        	
        	Thread.sleep(5000);
    
        	
        }
        
        String actual = driver.findElement(By.xpath("//div[contains(@class,'card card-sku osh_line-no_gutter card-horizontal_separator -no-margin -pam -ptl -pbl js-sku js-sku-main')]")).getAttribute("class");
        String expected = "card card-sku osh_line-no_gutter card-horizontal_separator -no-margin -pam -ptl -pbl js-sku js-sku-main";
        Assert.assertEquals(actual, expected);
        		
		
	}
	
	@AfterTest
	public void Closing() {
		
        driver.quit();
	}
}

