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

public class Login_Positive {

	
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
	public void Verify_Page_Title() {
		String actual = driver.getTitle();
		String expected = "Login Page";
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority=2)
	public void Email_Label_Presence() {
		
        boolean Email = driver.findElement(By.xpath("//label[contains(text(),'E-mail')]")).isDisplayed();
        
        
        if(Email ==true) {
        	
        	WebElement emailLabel = driver.findElement(By.xpath("//label[contains(text(),'E-mail')]"));
        	
	    	String actual = emailLabel.getText();
	    	String expected = "E-mail";
	    	
	    	Assert.assertEquals(actual, expected);	
	    
        }
        
	}
	
	@Test (priority=3)
	public void Email_Txt_Box_Presence() throws InterruptedException, IOException {
		
		
        
        boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        
        if(Email_Txt_Box ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement txt_box = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	txt_box.sendKeys(property.getProperty("email"));
        	txt_box.sendKeys(Keys.TAB);
        	
        	Thread.sleep(5000);
        	
        	txt_box.clear();
        	
        }
		Thread.sleep(5000);	
	}

	
	@Test (priority=4)
	public void Password_Label_Presence() {
		
        boolean Password = driver.findElement(By.xpath("//label[contains(text(),'Password')]")).isDisplayed();
        
        
        if(Password ==true) {
        	
        	WebElement passwordLabel = driver.findElement(By.xpath("//label[contains(text(),'Password')]"));
        	
	    	String actual = passwordLabel.getText();
	    	String expected = "Password";
	    	
	    	Assert.assertEquals(actual, expected);	
	    
        }
        
	}
	
	@Test (priority=5)
	public void Password_Txt_Box_Presence() throws InterruptedException, IOException {
		
		
        
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Password_Txt_Box ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement txt_box = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	txt_box.sendKeys(property.getProperty("password"));
        	txt_box.sendKeys(Keys.TAB);
        	
        	Thread.sleep(5000);
        	
        	
        	txt_box.clear();
        	
        }
		Thread.sleep(5000);	
	}
	
	@Test (priority=6)
	public void Password_Btn_Presence() throws InterruptedException, IOException {
		
		
        
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        boolean Password_Btn = driver.findElement(By.xpath("//div[@class='fi-w fi-br']//button//*[local-name()='svg']")).isDisplayed();
        
        if(Password_Txt_Box ==true && Password_Btn ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement txt_box = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	txt_box.sendKeys(property.getProperty("password"));
        	
        	WebElement btn = driver.findElement(By.xpath("//div[@class='fi-w fi-br']//button//*[local-name()='svg']"));
        	btn.click();
        	btn.click();
        	
        	Thread.sleep(5000);
        	
        	
        	txt_box.clear();
        	
        }
		Thread.sleep(5000);	
	}
	
	@Test (priority=7)
	public void Login() throws InterruptedException, IOException {
		
		
        
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
	
	}
	
	
	@Test (priority=8)
	public void Remember_Me() throws InterruptedException, IOException {
		
		
        
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
        	
        	driver.findElement(By.xpath("//label[contains(text(),'Remember me')]"));
        	
        	
        	
        	Thread.sleep(5000);
        	
        }
        	
        driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
	
	}
	
	@AfterTest
	public void Closing() {
		
        driver.quit();
	}
}
