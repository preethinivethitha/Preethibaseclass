package com.testframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemo {
	WebDriver driver;
	@BeforeClass
	private void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
	}
	@Test
	@Parameters({"FirstName","SecondName","Address","Email","PhoneNumber","Password","ConfirmPassword"})
	public void test(String FirstName,String SecondName,String Address,String Email,String PhoneNumber,String Password,String ConfirmPassword ) throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(SecondName);
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(Address);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(PhoneNumber);
		driver.findElement(By.xpath("//input[@value='FeMale']")).click();
		driver.findElement(By.xpath("//input[@value='Cricket']")).click();
		driver.findElement(By.xpath("//input[@value='Movies']")).click();
		driver.findElement(By.xpath("//input[@value='Hockey']")).click();
		driver.findElement(By.xpath("//div[@id='msdd']")).click();
		driver.findElement(By.xpath("//a[text() ='English']")).click();
		WebElement skills = driver.findElement(By.xpath("//select[@ng-model='Skill']"));
		Select S1 = new Select(skills);
		S1.selectByIndex(10);
		WebElement countries = driver.findElement(By.id("countries"));
		Select S2 = new Select(countries);
		S2.selectByVisibleText("India");
		driver.findElement(By.xpath("//span[@role='combobox']")).click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_DOWN);
		WebElement findyear = driver.findElement(By.id("yearbox"));
		Select S4 = new Select(findyear);
		S4.selectByVisibleText("1996");
		WebElement findmonth = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
		Select S5 = new Select(findmonth);
		S5.selectByVisibleText("March");
		WebElement findday = driver.findElement(By.id("daybox"));
		Select S6 = new Select(findday);
		S6.selectByVisibleText("24");
		driver.findElement(By.id("firstpassword")).sendKeys(Password);
		driver.findElement(By.id("secondpassword")).sendKeys(ConfirmPassword);
		driver.findElement(By.id("submitbtn")).click();
	}

}
