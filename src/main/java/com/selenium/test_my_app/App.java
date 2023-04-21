package com.selenium.test_my_app;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
	
	@Test
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        
    	//System.setProperty("webdriver.chrome.driver","/Users/shubham/Documents/Softwares/chrome-driver/chromedriver");
    	//System.setProperty("webdriver.chrome.driver", "/home/ubuntu/chromedriver");
    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.addArguments("--headless");
		//chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
    	chromeOptions.addArguments("--remote-allow-origins=*");
    	
    	WebDriver driver = new ChromeDriver(chromeOptions);
    	
    	System.out.println("Selenium test scripts execution started...");
    	
    	//open browser and hit url
    	driver.get("http://34.227.27.254:8081/addressbook");
    	
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	
    	//click on new contact button
    	driver.findElement(By.className("v-button")).click();
    	
    	//enter all the details
    	driver.findElement(By.id("gwt-uid-5")).sendKeys("Shubham");
    	Thread.sleep(1000);
    	driver.findElement(By.id("gwt-uid-7")).sendKeys("Singh");
    	Thread.sleep(1000);
    	driver.findElement(By.id("gwt-uid-9")).sendKeys("999999999");
    	Thread.sleep(1000);
    	driver.findElement(By.id("gwt-uid-11")).sendKeys("shubham@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("gwt-uid-13")).sendKeys("08/03/2023,");
    	Thread.sleep(1000);
    	
    	
    	
    	//click on save to store the information
    	driver.findElement(By.className("v-button-primary")).click();
    	
    	Thread.sleep(1000);
    	
    	TakesScreenshot scrShot = ((TakesScreenshot)driver);
    	
    	File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    	
    	File destFile = new File("//tmp//test-report.jpg");
    	
    	FileUtils.copyFile(srcFile, destFile);
    	
    	Thread.sleep(5000);
    	
    	driver.quit();
    	
    	System.out.println("Scripted executed successfully and report saved at " + destFile.getAbsolutePath());
    	
    	
    	
    	
    }
}
