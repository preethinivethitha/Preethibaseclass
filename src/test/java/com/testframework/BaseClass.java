package com.testframework;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
		public static WebDriver driver;
		static Actions ac ;
		public static Select s;
		static JavascriptExecutor  js;
		static Alert al;
		//1
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
	//2
	public static void launchUrl(String data) {
		driver.get(data);
	}
	//3
	public static void enterText(WebElement element,String data) {
		element.sendKeys(data);
	}
	//4
	public static void clickbtn(WebElement element) {
		element.click();
		}
	//5
	public static void movetoElement(WebElement element) {
		ac= new Actions(driver);
		ac.moveToElement(element).perform();
	}
	//6
	public static void settextbyJs(String data,WebElement element) {
		js = (JavascriptExecutor) (driver);
		js.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
		}
	//7
	public static void drag(WebElement element,WebElement element2) {
		ac.dragAndDrop(element,element2).perform();
	}
	//8
	public static void doubleClick(WebElement element) {
		ac.doubleClick(element).perform();
	}
	//9
	public static void rightClick(WebElement element) {
		ac.contextClick(element).perform();
	}
	//10
	public static void clickandHold(WebElement element,WebElement element1) {
		ac.clickAndHold(element).moveToElement(element1).release().build().perform();
	}
	//11
	public static void gettextbyJs(String data,WebElement element) {
		String text = (String) js.executeScript("return arguments[0].getAttribute('value','"+data+"')", element);
		System.out.println(text);
	}
	//12
	public static void scrollUp(WebElement element) {
		js.executeScript("argument[0].scrollIntoView(false)", element);
	}
	//13
	public static void ScrollDown(WebElement element) {
	js.executeScript("argument[0].scrollIntoView(true)", element);
	}
	//14
	public static void keyUPAndDown(WebElement element,String data) {
		ac.keyDown(element,Keys.SHIFT).sendKeys(element,data).keyUp(element, Keys.SHIFT).perform();

	}
	//15
	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}
	//16
	public static void drobDown(WebElement element) {
		 s= new Select(element);
		 
		 
		 }
	public static void selectIndex(int i) {
		s.selectByIndex(i);

	}
	//17
	public static void selectValue(String value) {
		s.selectByValue(value);
	}
	//18
	public static void selectvisible(String text) {
		s.selectByVisibleText(text);
	}
	//19
	public static void popup() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	//20
	public static void confirmPopup() {
		al.accept();
		al.dismiss();
	}
	//21
	public static void promptPopup(String data,String text) {
		al.accept();
		al.dismiss();
		al.sendKeys(data);
	}
	//22
	public static void optionsGet() {
		  s.getOptions();	
		}
	//23
	public static void allOptions() {
		s.getAllSelectedOptions();
	}
	//24
	public static void firstselectedOptions() {
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}
	//25
	public static void checkDropdown() {
		s.isMultiple();
	}
	//26
	public static void deSelectIndex(int i) {
	s.deselectByIndex(i);
	}
	//27
	public static void deSelectText(String text) {
		s.deselectByVisibleText(text);

	}
	//28
	public static void deselectValue(String value) {
		s.deselectByValue(value);
	}
	//29
	public static void deselectAll() {
		s.deselectAll();

	}
	//30
	public static void screenShot(String path) throws IOException {
		TakesScreenshot capture = (TakesScreenshot) driver;

	File screenshotAs = capture.getScreenshotAs(OutputType.FILE);
	File f = new File(path);
	FileUtils.copyFile(screenshotAs, f);
	}
	//31
	public static void frame(int i,String name,WebElement element) {
		driver.switchTo().frame(i);
		driver.switchTo().frame(name);
		driver.switchTo().frame(element);
		}
	//32
	public static void windows(String title,String url,String id) {
		driver.switchTo().window(title);
		driver.switchTo().window(url);
		driver.switchTo().window(id);
		
	}
	//33
	public static void getParentWindow() {
		String windowHandle = driver.getWindowHandle();

	}
	//34
	public static void getAllWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
	}
	//35
	public static void locators(String locator) {
		if(locator.equalsIgnoreCase("ID")) {
			driver.findElement(By.id(" "));
		}
		else if(locator.equalsIgnoreCase("CLASSNAME")) {
			driver.findElement(By.className(" "));
		}
		else if(locator.equalsIgnoreCase("XPATH")) {
			driver.findElement(By.xpath(" "));
		}
		else if(locator.equalsIgnoreCase("NAME")) {
			driver.findElement(By.name(" "));
		}
		else {
			driver.findElement(By.tagName(" "));
		}
		

	}
	//36
	public static void launchUrlByNavigate(String url) {
		driver.navigate().to(url);
	}
	//37
	public static void forwardpage() {
		driver.navigate().forward();

	}
	//38
	public static void backPage() {
		driver.navigate().back();
	}
	//39
	public static void refreshPage() {
		driver.navigate().refresh();

	}
	//40
	public static void findLisfOfElements(String locators) {
		if(locators.equalsIgnoreCase("ID")) {
			driver.findElements(By.id(" "));
		}
		else if(locators.equalsIgnoreCase("CLASSNAME")) {
			driver.findElements(By.className(" "));
		}
		else if(locators.equalsIgnoreCase("XPATH")) {
			driver.findElements(By.xpath(" "));
		}
		else if(locators.equalsIgnoreCase("NAME")) {
			driver.findElements(By.name(" "));
		}
		else {
			driver.findElements(By.tagName(" "));
		}

	}
	//41
	public static void createExcel(String path,String datas,int i,int j,String value) throws InvalidFormatException, IOException {
		File file = new File("path");
		Workbook w = new XSSFWorkbook(file);
		Sheet createSheet = w.createSheet("datas");
		Row createRow = createSheet.createRow(i);
		Cell createCell = createRow.createCell(j);
		createCell.setCellValue("Value");
		FileOutputStream stream= new FileOutputStream(file);
		w.write(stream);
			
	}
	//42
	public static void closeAllBrowser() {
		driver.quit();

	}
	//43
	public static void closeCurrentWindow() {
		driver.close();

	}
	//44
	public static String getAttrinute(WebElement element,String value) {
		String attribute = element.getAttribute(value);
		return attribute;
		
	}
	//45
	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}
	//46
	public static void parentframe() {
		driver.switchTo().parentFrame();
	}
	//47
	public static void waitt(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

	}
	public static void robotClass() throws AWTException {
	Robot r = new Robot();
	for (int i = 0; i < 5; i++) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
	}
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);


	}
	public static WebElement findXpath(String locator) {
		WebElement findElement = driver.findElement(By.xpath(locator));
		return findElement;

	}
	public static WebElement findId(String locator) {
		WebElement findElement = driver.findElement(By.id(locator));
		return findElement;

	}

	public static WebElement findName(String locator) {
		WebElement findElement = driver.findElement(By.name(locator));
		return findElement;

	}
	public static String excelRead(String path,String SheetName,int rowNo,int cellNo) throws IOException {
	File file = new File(path);
	FileInputStream stream = new FileInputStream (file);
	Workbook w = new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet(SheetName);
	Row row = sheet.getRow(rowNo);
	Cell cell = row.getCell(cellNo);
	int cellType = cell.getCellType();
	String value="";
	if (cellType==1) {
		 value = cell.getStringCellValue();
		
	}else if (DateUtil.isCellDateFormatted(cell)) {
		Date dateCellValue = cell.getDateCellValue();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		 value = format.format(dateCellValue);

	}else {
		double numericCellValue = cell.getNumericCellValue();
		long l = (long) numericCellValue;
		 value = String.valueOf(l);
	}
	
	return value;
	
}


	}





