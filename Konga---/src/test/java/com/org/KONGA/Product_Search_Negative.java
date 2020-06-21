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

public class Product_Search_Negative {

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
		driver.navigate().to("https://www.jumia.com.ng/");;
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
        	search_box.sendKeys(property.getProperty("wrong_product1"));
        	
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]"));
        	search_btn.click();
        	
        	
        	Thread.sleep(5000);	
    
        	
        }
        
        String actual = driver.getCurrentUrl();
        String expected = "https://www.jumia.com.ng/catalog/?q=*a";
        
        Assert.assertEquals(actual, expected);
        
        driver.navigate().back();
        		
		
	}
	
	@Test (priority=3)
	public void Sanity() throws InterruptedException, IOException {
		
		
        
        boolean Search = driver.findElement(By.xpath("//input[@id='fi-q']")).isDisplayed();
        
        if(Search ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement search_box = driver.findElement(By.xpath("//input[@id='fi-q']"));
        	search_box.sendKeys(property.getProperty("wrong_product2"));
        	
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]"));
        	search_btn.click();
        	
        	
        	Thread.sleep(5000);	
        	
        	driver.navigate().back();
        	
        	
    
        	
        }
        
        String actual = driver.getCurrentUrl();
        String expected = "https://www.jumia.com.ng/catalog/?q=-*%21%22%C2%A3%40\"";
        
        Assert.assertEquals(actual, expected);
        
        driver.navigate().back();
        
        
        	
        if(driver.getCurrentUrl().equalsIgnoreCase(expected)) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement search_box = driver.findElement(By.xpath("//input[@id='fi-q']"));
        	search_box.sendKeys(property.getProperty("product"));
        	
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]"));
        	search_btn.click();
        	
        	
        	Thread.sleep(5000);	
        	
        	driver.navigate().back();
        	
        	String actual1 = driver.getCurrentUrl();
            String expected1 = "https://www.jumia.com.ng/phones-tablets/samsung/?bcsq=1&q=galaxy+s7";
            
            Assert.assertEquals(actual1, expected1);
    
        	
        }
        		
		
	}
	
	
	@Test (priority=4)
	public void Search_Product2() throws InterruptedException, IOException {
		
		
        
        boolean Search = driver.findElement(By.xpath("//input[@id='fi-q']")).isDisplayed();
        
        if(Search ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement search_box = driver.findElement(By.xpath("//input[@id='fi-q']"));
        	search_box.sendKeys(property.getProperty("wrong_product2"));
        	
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]"));
        	search_btn.click();
        	
        	
        	Thread.sleep(5000);	
    
        	
        }
        
        String actual = driver.getCurrentUrl();
        String expected = "https://www.jumia.com.ng/catalog/?q=-*%21%22%C2%A3%40";
        
        Assert.assertEquals(actual, expected);
        
        driver.navigate().back();
        		
		
	}
	
	@Test (priority=5)
	public void Search_Product3() throws InterruptedException, IOException {
		
		
        
        boolean Search = driver.findElement(By.xpath("//input[@id='fi-q']")).isDisplayed();
        
        if(Search ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement search_box = driver.findElement(By.xpath("//input[@id='fi-q']"));
        	search_box.sendKeys(property.getProperty("wrong_product3"));
        	
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]"));
        	search_btn.click();
        	
        	
        	Thread.sleep(5000);	
    
        	
        }
        
        String actual = driver.getCurrentUrl();
        String expected = "https://www.jumia.com.ng/catalog/?q=.";
        
        Assert.assertEquals(actual, expected);
        
        driver.navigate().back();
        		
		
	}
	
	@Test (priority=6)
	public void Search_Product4() throws InterruptedException, IOException {
		
		
        
        boolean Search = driver.findElement(By.xpath("//input[@id='fi-q']")).isDisplayed();
        
        if(Search ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement search_box = driver.findElement(By.xpath("//input[@id='fi-q']"));
        	search_box.sendKeys(property.getProperty("wrong_product4"));
        	
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]"));
        	search_btn.click();
        	
        	
        	Thread.sleep(5000);	
    
        	
        }
        
        String actual = driver.getCurrentUrl();
        String expected = "https://www.jumia.com.ng/catalog/?q=aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        
        Assert.assertEquals(actual, expected);
        
        driver.navigate().back();
        		
		
	}
	
	@Test (priority=7)
	public void Search_Product5() throws InterruptedException, IOException {
		
		
        
        boolean Search = driver.findElement(By.xpath("//input[@id='fi-q']")).isDisplayed();
        
        if(Search ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement search_box = driver.findElement(By.xpath("//input[@id='fi-q']"));
        	search_box.sendKeys(" ");
        	
        	
        	
        	WebElement search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]"));
        	search_btn.click();
        	
        	boolean Search_btn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/section[1]/div[1]/form[1]/button[1]")).isEnabled();
        	
        	if (Search_btn ==true) {
        		System.out.println("I am enabled");
        	} else {
        		System.out.println("I can not be clicked");
        	}
    
        	
        	
        }
        
        
	}
	
	@AfterTest
	public void Closing() {
		
        driver.quit();
	}
}
