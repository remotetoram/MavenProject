package com.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
   @Test
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);	
		
		
			
WebElement dropdown = driver.findElement(By.xpath(".//*[@id='searchLanguage']"));
		
//dropdown.click();
List<WebElement> dropdownitems=dropdown.findElements(By.tagName("option"));

System.out.println(dropdownitems.size() );


for(WebElement i:dropdownitems)
{
	System.out.println(i.getText());
			//getAttribute("lang"));
}
		//Select select = new Select(dropdown);
		//select.selectByValue("hi");
	}

}
