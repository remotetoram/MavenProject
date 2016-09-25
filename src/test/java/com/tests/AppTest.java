package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public abstract class AppTest implements WebDriver{
 @org.junit.Test
 public void Test()
 {
	 //System.setProperty("webdriver.chrome.driver", "C:\\Ram\\UTAS\\WebDriverDrivers\\chromedriver.exe");
	 WebDriver Driver = new ChromeDriver();
     Driver.get("https:\\www.google.com");
    
 }

}
