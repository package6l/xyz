package com.Selenium.Practice;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicLoginDemo {
  @Test(description="To test  basic functionality")
  
  public void verifytitle() throws Exception {
	  
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SURYA\\PracticeProject\\Practice\\Drivers\\chromedriver.exe");
	//  System.setProperty("webdriver.firefox.marionette", "C:\\Users\\SURYA\\PracticeProject\\Practice\\Drivers\\geckodriver.exe");
	 // WebDriver browser= new FirefoxDriver();
	WebDriver browser =new ChromeDriver();
	
	  browser.get("http://www.automationtestinghub.com/selenium-3-0-launch-firefox-with-geckodriver/");
	 String x= browser.getTitle();
	   if(!(x.contains("xcxc")) ){
		   printScreenshort(browser);
	   }
	  browser.close();
  }

private void printScreenshort(WebDriver browser) throws Exception {
	TakesScreenshot img =(TakesScreenshot)browser;
	File src =img.getScreenshotAs(OutputType.FILE);
	int x= (new Random()).nextInt();
	String filepath="C:\\Users\\SURYA\\PracticeProject\\Practice\\Defect_Screenshot\\defect"+x+".png";
	File Destination = new File(filepath);
	FileUtils.copyFile(src, Destination);
	
}
  
	
}
