package com.testframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdactindataProvider {
@Test(dataProvider="res")
public void login(String s1,String s2) {
	System.setProperty("webdriver.chrome.driver", "D:\\Preethi\\FrameWorks\\driver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://adactinhotelapp.com/");
    driver.manage().window().maximize();
    WebElement txtuserName = driver.findElement(By.id("username"));
    txtuserName.sendKeys(s1);
    WebElement txtpassword = driver.findElement(By.id("password"));
    txtpassword.sendKeys(s2);
    WebElement btnlogin = driver.findElement(By.id("password"));
    btnlogin.click();
    driver.quit();
}
@DataProvider(name="res")
public Object[][] data() {
	return new Object[][] {{"Preethi","12345"},{"Divya","12345@"},{"Ruby","Welcome@123"},{"Vinitha","vini@123"},{"Rashmi","rash@123"},{"Suganya","suganya@123"},{"Prema","prema@123"},{"Durga","durga@123"},{"Viniba","viniba@123"},{"Anu","anu@123"}};
}

	
	
}

