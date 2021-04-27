package com.testframework;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactintestNG {
	WebDriver driver;
	@BeforeClass
	private void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		}
		@AfterClass
		private  void afterClass() {
			driver.quit();
	}
		@BeforeMethod
		private void beforeMethod() {
			
			Date date = new Date();
			System.out.println(date);
	}
		@AfterMethod
		private void afterMethod() {
			Date date = new Date();
			System.out.println(date);	
			}
		@Test
		private void test1() throws Exception {
			driver.findElement(By.id("username")).sendKeys("Preethi");
			driver.findElement(By.id("password")).sendKeys("12345");
			driver.findElement(By.id("login")).click();
			Thread.sleep(2000);
		}
	

}
