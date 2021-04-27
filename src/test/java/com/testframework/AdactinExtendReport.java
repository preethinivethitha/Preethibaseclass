package com.testframework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class AdactinExtendReport extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	@BeforeClass
	public void beforeClass() {
		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("Adactin.html");
		reports.attachReporter(htmlReporter);
		launchBrowser();
		launchUrl("https://adactinhotelapp.com/");
	}
@BeforeMethod
public void beforeMethod() {
Date date = new Date();
System.out.println(date);
}
@AfterMethod
public void afterMethod(Method method) throws IOException {
	screenShot(method.getName());
}
@Test
public void tc0() throws IOException {
test = reports.createTest("validating home page of adactin");
test.log(Status.INFO,"Verifying Url of Adactin page");
if (driver.getCurrentUrl().contains("adactinhotelapp")) {
	test.log(Status.PASS, "valid Url");
	}else {
		test.log(Status.FAIL, "Invalid Url");
}
WebElement logo = driver.findElement(By.className("logo"));
if (logo.isDisplayed()) {
	test.log(Status.PASS, "Adacting log is present on home page");
	File screenshotAs = logo.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotAs, new File("logo.png"));
	test.addScreenCaptureFromPath("logo.png");
} else {
test.log(Status.FAIL,"Adacting log is not present on home page");
}
}
@Test
public void tc1() {
	test = reports.createTest("Enterning username and password");
	WebElement txtuser = driver.findElement(By.id("username"));
	test.log(Status.INFO, "validating username field");
	if (txtuser.isDisplayed() && txtuser.isDisplayed()) {
		test.log(Status.PASS, "Username field box is enabled and displayed");
		txtuser.sendKeys("Karthi007");
		} else {
			test.log(Status.PASS, "Username field box is not enabled and not displayed");	
}
	test.log(Status.INFO, "validating password field");
	WebElement txtpassword = driver.findElement(By.id("password"));
	if (txtpassword.isDisplayed() && txtpassword.isDisplayed()) {
		test.log(Status.PASS, "password field box is enabled and displayed");
		txtpassword.sendKeys("Karthi@1989");
		} else {
			test.log(Status.PASS, "password field box is not enabled and not displayed");	
}	
	WebElement btnlogin = driver.findElement(By.id("login"));
	BaseClass.clickbtn(btnlogin);
	if (btnlogin.isDisplayed() && btnlogin.isDisplayed()) {
		test.log(Status.PASS, "login box is enabled and displayed");
		clickbtn(btnlogin);
		} else {
			test.log(Status.PASS, "login box is not enabled and not displayed");	
}	
	test.log(Status.INFO, "validating location field");
	WebElement findlocation = driver.findElement(By.id("location"));
	drobDown(findlocation);
	if (findlocation.isDisplayed() && findlocation.isEnabled() ) {
		test.log(Status.PASS, "location field box is enabled and displayed");
		selectvisible("Melbourne");
	} else {
		test.log(Status.FAIL, "location field box is not enabled and not displayed");
}
	WebElement findhotel = driver.findElement(By.name("hotels"));
	drobDown(findhotel);
	if (findhotel.isDisplayed() && findhotel.isEnabled() ) {
		test.log(Status.PASS, "Hotel field box is enabled and displayed");
	
		selectvisible("Hotel Sunshine");
	} else {
		test.log(Status.FAIL, "Hotel field box is not enabled and not displayed");
	}
//	WebElement findroom = driver.findElement(By.id("room_type"));
//drobDown(findroom);
//	if (findroom.isDisplayed() && findroom.isEnabled() ) {
//		test.log(Status.PASS, "Room field box is enabled and displayed");
//		
//		selectvisible("Super Deluxe");
//	} else {
//		test.log(Status.FAIL, "Room field box is not enabled and not displayed");
//	}
//	WebElement findselectroom = driver.findElement(By.id("room_nos"));
//	//drobDown(findselectroom);
//	if (findselectroom.isDisplayed() && findselectroom.isEnabled()) {
//		test.log(Status.PASS, "selectRoom field box is enabled and displayed");
//		drobDown(findselectroom);
//		selectvisible("2 - Two");
//	} else {
//		test.log(Status.FAIL, "selectRoom field box is not enabled and not displayed");
//	}
//	WebElement checkindate = driver.findElement(By.id("datepick_in"));
//	checkindate.clear();
//	if (checkindate.isDisplayed() && checkindate.isEnabled() ) {
//		test.log(Status.PASS, "Date box is enabled and displayed");
//		enterText(checkindate,"27/04/2021");
//	} else {
//		test.log(Status.FAIL, "Date box is not enabled and not displayed");
//	}
//	
//	WebElement checkout = driver.findElement(By.id("datepick_out"));
//	checkout.clear();
//	if (checkout.isDisplayed() && checkout.isEnabled() ) {
//		test.log(Status.PASS, "Date box is enabled and displayed");
//		enterText(checkout,"29/04/2021");
//	} else {
//		test.log(Status.FAIL, "Date box is not enabled and not displayed");
//	}
//	
//	WebElement adultperroom = driver.findElement(By.id("adult_room"));
//	drobDown(adultperroom);
//	if (adultperroom.isDisplayed() && adultperroom.isDisplayed() ) {
//		test.log(Status.PASS, "adultRoom field box is enabled and displayed");
//		
//		selectvisible("2 - Two");
//	} else {
//		test.log(Status.FAIL, "adultRoom field box is not enabled and not displayed");
//	}
//	WebElement childrenperroom = driver.findElement(By.id("child_room"));
//	drobDown(childrenperroom);
//	if (childrenperroom.isDisplayed() && childrenperroom.isDisplayed()) {
//		test.log(Status.PASS, "childrenRoom field box is enabled and displayed");
//		
//		selectvisible("1 - One");
//	} else {
//		test.log(Status.FAIL, "childrenRoom field box is not enabled and not displayed");
//	}
//	WebElement btnsearch = driver.findElement(By.id("Submit"));
//	if (adultperroom.isDisplayed() && adultperroom.isDisplayed() ) {
//		test.log(Status.PASS, "search is enabled");
//		clickbtn(btnsearch);
//	} else {
//		test.log(Status.FAIL, "search is not enabled");
//	}
	
//	WebElement clickradio = driver.findElement(By.id("radiobutton_0"));
//	//clickradio.click();
//	if (clickradio.isDisplayed() && clickradio.isDisplayed() ) {
//		test.log(Status.PASS, "radio is enabled");
//		clickbtn(clickradio);
//	} else {
//		test.log(Status.FAIL, "radio is not enabled");
//	}
//	WebElement btncontinue = driver.findElement(By.id("continue"));
//	//btncontinue.click();
//	if (btncontinue.isDisplayed() && btncontinue.isDisplayed() ) {
//		test.log(Status.PASS, "continue is enabled");
//		clickbtn(btncontinue);
//	} else {
//		test.log(Status.FAIL, "continue is not enabled");
//	}
//	WebElement txtfirstname = driver.findElement(By.id("first_name"));
//	//enterText(txtfirstname, "Preethi");
//	if (txtfirstname.isDisplayed() && txtfirstname.isDisplayed()) {
//		test.log(Status.PASS, "first box is enabled and displayed");
//		txtfirstname.sendKeys("Preethi");
//		} else {
//			test.log(Status.PASS, "first  box is not enabled and not displayed");	
//}	
//	WebElement txtlastname = driver.findElement(By.id("last_name"));
//	//enterText(txtlastname,"Nive");
//	if (txtlastname.isDisplayed() && txtlastname.isDisplayed()) {
//		test.log(Status.PASS, "last box is enabled and displayed");
//		txtlastname.sendKeys("nive");
//		} else {
//			test.log(Status.PASS, "last box box is not enabled and not displayed");	
//}	
//	WebElement txtaddress = driver.findElement(By.id("address"));
//	//enterText(txtaddress,"Sholinganallur");
//	if (txtaddress.isDisplayed() && txtaddress.isDisplayed()) {
//		test.log(Status.PASS, " Address box is enabled and displayed");
//		txtaddress.sendKeys("Sholinganallur");
//		} else {
//			test.log(Status.PASS, "Address box is not enabled and not displayed");	
//}	
//	WebElement txtcard = driver.findElement(By.id("cc_num"));
//	//enterText(txtcard,"1234567890111213");
//	if (txtcard.isDisplayed() && txtcard.isDisplayed()) {
//		test.log(Status.PASS, " card box is enabled and displayed");
//		txtcard.sendKeys("1234567890111213");
//		} else {
//			test.log(Status.PASS, "card box is not enabled and not displayed");	
//}	
//	WebElement findcardtype = driver.findElement(By.id("cc_type"));
//	drobDown(findcardtype);
//	//selectvisible("Master Card");
//	if (findcardtype.isDisplayed() && findcardtype.isDisplayed()) {
//		test.log(Status.PASS, " card box is enabled and displayed");
//		findcardtype.sendKeys("Master Card");
//		} else {
//			test.log(Status.PASS, "card box is not enabled and not displayed");	
//}	
//	WebElement findmonth = driver.findElement(By.id("cc_exp_month"));
//	drobDown(findmonth);
//	//selectvisible("March");
//	if (findmonth.isDisplayed() && findmonth.isDisplayed()) {
//		test.log(Status.PASS, " Month box is enabled and displayed");
//		findmonth.sendKeys("March");
//		} else {
//			test.log(Status.PASS, "Month box is not enabled and not displayed");	
//}	
//	
//	WebElement findyear = driver.findElement(By.id("cc_exp_year"));
//	drobDown(findyear);
//	//selectvisible("2022");
//	if (findyear.isDisplayed() && findyear.isDisplayed()) {
//		test.log(Status.PASS, " year box is enabled and displayed");
//		findmonth.sendKeys("2022");
//		} else {
//			test.log(Status.PASS, "year box is not enabled and not displayed");	
//}	
//	WebElement findcvv = driver.findElement(By.id("cc_cvv"));
//	//enterText(findcvv,"123");
//	if (findcvv.isDisplayed() && findcvv.isDisplayed()) {
//		test.log(Status.PASS, " card cvv box is enabled and displayed");
//		findcvv.sendKeys("123");
//		} else {
//			test.log(Status.PASS, "card cvv box is not enabled and not displayed");	
//}	
//	WebElement btnbooknow = driver.findElement(By.id("book_now"));
//	//btnbooknow.click();
//	if (btnbooknow.isDisplayed() && btnbooknow.isDisplayed() ) {
//		test.log(Status.PASS, "booknow is enabled");
//		clickbtn(btnbooknow);
//	} else {
//		test.log(Status.FAIL, "booknow is not enabled");
//	}
}
@AfterClass
public void afterClass() {
	reports.flush();
}
}