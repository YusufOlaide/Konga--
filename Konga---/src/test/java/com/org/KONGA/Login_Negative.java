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

public class Login_Negative {


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
	public void Email_Txt_Box_Empty() throws InterruptedException {
		
		
		boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	
        	txt_box_emp.sendKeys(" ");
        	txt_box_emp.sendKeys(Keys.TAB);
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("//div[@class='fi-w']//div[@class='fi-er'][contains(text(),'Required field')]")).getText();
        	String expected = "Required field";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	
        }
        
	}
	
	@Test (priority=3)
	public void Password_Txt_Box_Empty() throws InterruptedException {
		
		
		boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	
        	txt_box_emp.sendKeys(" ");
        	txt_box_emp.sendKeys(Keys.TAB);
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]")).getText();
        	String expected = "Required field";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	
        }
        
		
	}
	
	@Test (priority=4)
	public void Email_Txt_Box_Middle_Space() throws InterruptedException, IOException {
		
		
        boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
        	
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	
        	txt_box_emp.sendKeys(property.getProperty("invalidemail_MS"));
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	WebElement p_txt_box_ = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	p_txt_box_.sendKeys(property.getProperty("password"));
        	
        	
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("//div[@class='fi-er']")).getText();
        	String expected = "Invalid Information";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	txt_box_emp.clear();
        	p_txt_box_.clear();
        }
        
        Thread.sleep(5000);
        
	}
	
	@Test (priority=5)
	public void Email_Txt_Box_Without_AT() throws InterruptedException, IOException {
		
		
        boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
        	
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	
        	txt_box_emp.sendKeys(property.getProperty("invalidemail_@"));
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	WebElement p_txt_box_ = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	p_txt_box_.sendKeys(property.getProperty("password"));
        	
        	
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("//div[@class='fi-er']")).getText();
        	String expected = "Invalid Information";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	txt_box_emp.clear();
        	p_txt_box_.clear();
        	
        }
        Thread.sleep(5000);
	}
	
	
	
	@Test (priority=6)
	public void Invaild_Email_Valid_Password() throws InterruptedException, IOException {
		
		
        boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	txt_box_emp.sendKeys(property.getProperty("invalidemail"));
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	WebElement p_txt_box_ = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	p_txt_box_.sendKeys(property.getProperty("password"));
        	
        	
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("//div[@class='fi-w']//div[@class='fi-er'][contains(text(),'Required field')]")).getText();
        	String expected = "Required field";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	txt_box_emp.clear();
        	p_txt_box_.clear();
        	
        }
        Thread.sleep(5000);
	}
	
	@Test (priority=7)
	public void Valid_Email_Invaild_Password() throws InterruptedException, IOException {
		
        boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	txt_box_emp.sendKeys(property.getProperty("email"));
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	WebElement p_txt_box_ = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	p_txt_box_.sendKeys(property.getProperty("invalidpassword"));
        	
        	
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("//div[@class='fi-w']//div[@class='fi-er'][contains(text(),'Required field')]")).getText();
        	String expected = "Required field";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	txt_box_emp.clear();
        	p_txt_box_.clear();
        }
     
        Thread.sleep(5000);
	}
	
	@Test (priority=8)
	public void Email_Txt_Box_Without_COM() throws InterruptedException, IOException {
		
		
        boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
        	
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	
        	txt_box_emp.sendKeys(property.getProperty("invalidemail_COM"));
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	WebElement p_txt_box_ = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	p_txt_box_.sendKeys(property.getProperty("password"));
        	
        	
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("//div[@class='fi-er']")).getText();
        	String expected = "Invalid Information";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	txt_box_emp.clear();
        	p_txt_box_.clear();
        	
        }
        Thread.sleep(5000);
        
	}
	
	
	@Test (priority=9)
	public void Invalid_Email_Invaild_Password() throws InterruptedException, IOException {
		
        boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	txt_box_emp.sendKeys(property.getProperty("invalidemail"));
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	WebElement p_txt_box_ = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	p_txt_box_.sendKeys(property.getProperty("invalidpassword"));
        	
        	
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("//div[@class='fi-w']//div[@class='fi-er'][contains(text(),'Required field')]")).getText();
        	String expected = "Required field";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	txt_box_emp.clear();
        	p_txt_box_.clear();
        }
        
        Thread.sleep(5000);
        
	}
	
	@Test (priority=10)
	public void Invalid_Email_Invaild_Password_With_Remeber_Me() throws InterruptedException, IOException {
		
		
        boolean Email_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-email']")).isDisplayed();
        boolean Password_Txt_Box = driver.findElement(By.xpath("//input[@id='fi-password']")).isDisplayed();
        
        if(Email_Txt_Box ==true && Password_Txt_Box ==true) {
        	
        	property = new Properties();
    		FileInputStream fs = null;
    		fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
    		property.load(fs);
    		
    		
        	WebElement txt_box_emp = driver.findElement(By.xpath("//input[@id='fi-email']"));
        	txt_box_emp.sendKeys(property.getProperty("invalidemail"));
        	txt_box_emp.sendKeys(Keys.TAB);
        	
        	WebElement p_txt_box_ = driver.findElement(By.xpath("//input[@id='fi-password']"));
        	p_txt_box_.sendKeys(property.getProperty("invalidpassword"));
        	
        	
        	driver.findElement(By.xpath("//label[contains(text(),'Remember me')]"));
        	
        	driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']//span[contains(text(),'Login')]")).click();
        	
        	String actual = driver.findElement(By.xpath("//div[@class='fi-w']//div[@class='fi-er'][contains(text(),'Required field')]")).getText();
        	String expected = "Required field";
        	
        	Assert.assertEquals(actual, expected);
        	
        	Thread.sleep(5000);
        	
        	txt_box_emp.clear();
        	p_txt_box_.clear();
        	
        }
        Thread.sleep(5000);
        
	}
	
	
	
	@AfterTest
	public void Closing() {
		
        driver.quit();
	}
}
