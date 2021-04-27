package com.testframework;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseclasswithTestng extends BaseClass {
	@BeforeClass
	public void beforeClass() {
		BaseClass.launchBrowser();
		BaseClass.launchUrl("http://demo.automationtesting.in/Register.html");

	}

	@Test

	public void test1() throws IOException, InterruptedException, AWTException {
		Thread.sleep(7000);
		WebElement findXpath = BaseClass.findXpath("//input[@placeholder='First Name']");
				
		BaseClass.enterText(findXpath,
				BaseClass.excelRead("D:\\Preethi\\TestNGFramework\\Excel\\demo.xlsx", "data", 1, 0));
		WebElement findXpath1 = BaseClass.findXpath("//input[@placeholder='Last Name']");
		String txtValue = BaseClass.getAttrinute(findXpath1, "value");
		Assert.assertEquals(txtValue, "Nive");

		BaseClass.enterText(findXpath1,
				BaseClass.excelRead("D:\\Preethi\\TestNGFramework\\Excel\\demo.xlsx", "data", 1, 1));
		WebElement findXpath2 = BaseClass.findXpath("//textarea[@ng-model='Adress']");
		
		BaseClass.enterText(findXpath2,
				BaseClass.excelRead("D:\\Preethi\\TestNGFramework\\Excel\\demo.xlsx", "data", 1, 2));
		WebElement findXpath3 = BaseClass.findXpath("//input[@type='email']");
		
		BaseClass.enterText(findXpath3,
				BaseClass.excelRead("D:\\Preethi\\TestNGFramework\\Excel\\demo.xlsx", "data", 1, 3));
		WebElement findXpath4 = BaseClass.findXpath("//input[@type='tel']");
		
		BaseClass.enterText(findXpath4,
				BaseClass.excelRead("D:\\Preethi\\TestNGFramework\\Excel\\demo.xlsx", "data", 1, 4));
		WebElement findXpath5 = BaseClass.findXpath("//input[@value='FeMale']");
		
		BaseClass.clickbtn(findXpath5);
		boolean true1 = findXpath5.isSelected();
		Assert.assertTrue(true1);
		WebElement findXpath6 = BaseClass.findXpath("//input[@value='Cricket']");
		
		BaseClass.clickbtn(findXpath6);
		boolean true2 = findXpath6.isSelected();
		Assert.assertTrue(true2);
		WebElement findXpath7 = BaseClass.findXpath("//div[@id='msdd']");
		BaseClass.clickbtn(findXpath7);
		WebElement findXpath8 = BaseClass.findXpath("//a[text() ='English']");
		
		BaseClass.clickbtn(findXpath8);
		
		WebElement findXpath9 = BaseClass.findXpath("//select[@ng-model='Skill']");
		BaseClass.drobDown(findXpath9);
		BaseClass.selectIndex(10);
		
		WebElement country = BaseClass.findId("countries");
		BaseClass.drobDown(country);
		BaseClass.selectvisible("India");
		WebElement selectCountry = BaseClass.findXpath("//span[@role='combobox']");
		BaseClass.clickbtn(selectCountry);
		BaseClass.robotClass();
		
		WebElement year = BaseClass.findId("yearbox");
		BaseClass.drobDown(year);
		BaseClass.selectvisible("1996");
		
		WebElement month = BaseClass.findXpath("//select[@ng-model='monthbox']");
		BaseClass.drobDown(month);
		BaseClass.selectvisible("March");
		
		WebElement day = BaseClass.findId("daybox");
		BaseClass.drobDown(day);
		BaseClass.selectvisible("24");

		WebElement password = BaseClass.findId("firstpassword");
		
		BaseClass.enterText(password,
				BaseClass.excelRead("D:\\Preethi\\TestNGFramework\\Excel\\demo.xlsx", "data", 1, 12));
		WebElement confirmpassword = BaseClass.findId("secondpassword");
		
		BaseClass.enterText(confirmpassword,
				BaseClass.excelRead("D:\\Preethi\\TestNGFramework\\Excel\\demo.xlsx", "data", 1, 13));
		Thread.sleep(2000);
		WebElement submit = BaseClass.findName("signup");
		BaseClass.clickbtn(submit);
	}
	
}
