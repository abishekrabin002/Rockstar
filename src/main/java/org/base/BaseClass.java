package org.base;

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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
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
	
	
	public static WebDriver chromeDriver() {
		WebDriverManager .chromedriver().setup();
		return driver=new ChromeDriver();
		}
	
	public static void url(String url) {
		driver.get(url);
	}
	public static void  maximize() {
		driver.manage().window().maximize();
	}
	public static void implicitlywait(int e) {
		driver.manage().timeouts().implicitlyWait(e, TimeUnit.SECONDS);
	}
	
	public static void sendkey(WebElement b, String c) {
		b.sendKeys(c);
	}
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public static String getAttribute(WebElement f ,String a) {
		 return f.getAttribute(a);
		}
	public static String getText(WebElement g) {
		String text = g.getText();
		return text;
	}
	public static String getattributes(WebElement s) {
		String attribute = s.getAttribute("value");
		return attribute;
	}

	
	public static void click(WebElement d) {
		d.click();
		}
	public static void quit() {
		driver.quit();
	}
	
	public static void moveToElement(WebElement w) {
		Actions a=new Actions(driver);
		a.moveToElement(w).perform();
	}
	public static void dragAndDrop(WebElement c, WebElement d) {
		Actions b=new Actions(driver);
		b.dragAndDrop(c, d).perform();
	}
	public static void contextClick(WebElement s) {
		Actions j=new Actions(driver);
       j.contextClick(s).perform();
	}
	public static void doubleClick(WebElement k) {
	Actions u=new Actions(driver);	
	u.doubleClick(k);
	}
	public static void robotSelect() throws AWTException {
		Robot c=new Robot();
		c.keyPress(KeyEvent.VK_CONTROL);
		c.keyPress(KeyEvent.VK_A);
		c.keyRelease(KeyEvent.VK_CONTROL);
		c.keyRelease(KeyEvent.VK_A);
		}
	public static void selectByIndex(WebElement q,int s) {
		Select r=new Select(q);
		r.selectByIndex(s);
	}
	public static void selectByvalue(WebElement r,String s) {
		Select b=new Select(r);
		b.selectByValue(s);
	}
	public static void selectByVisibleText(WebElement v,String k) {
		Select c=new Select(v);
		c.selectByVisibleText(k);
	}
	public static void selectAllByIndex(WebElement f) {
		Select e=new Select(f);
	List<WebElement> options = e.getOptions();
	int size = options.size();
		for(int i=0;i<options.size();i++) {
			e.selectByIndex(i);
		}}
	public static void selectAllByValue(WebElement v) {
		Select h=new Select(v);
		List<WebElement> options = h.getOptions();
		int size = options.size();
		for(int i=0;i<options.size();i++) {
			WebElement w = options.get(i);
			String att = w.getAttribute("value");
			h.selectByValue(att);
			}}
	public static void selectAllbyVisibleText(WebElement r) {
		Select n=new Select(r);
		List<WebElement> options = n.getOptions();
		int size = options.size();
		for(WebElement  y:options) {
		String text = y.getText();
		n.selectByVisibleText(text);
		}}
	public static String getOptions(WebElement z) {
		Select s=new Select(z);
		List<WebElement> options = s.getOptions();
		for(int i=0;i<=options.size();i++) {
		WebElement web = options.get(i);
		String t = web.getText();
		}
		return null;
	}
	public static String getFirstSelectedOption(WebElement a) {
		Select x=new Select(a);
		 WebElement fs = x.getFirstSelectedOption();
		 String t = fs.getText();
		return t;
	}
	public static String getAllSelectedOptions(WebElement g) {
		Select c=new Select(g);
		c.getAllSelectedOptions();
		return null;
	}
	public static void deselectByIndex(WebElement q,int s) {
		Select r=new Select(q);
		r.deselectByIndex(s);
	}
	public static void deselectByvalue(WebElement r,String s) {
		Select b=new Select(r);
		b.deselectByValue(s);
	}
	public static void deselectByVisibleText(WebElement v,String k) {
		Select c=new Select(v);
		c.deselectByVisibleText(k);
	}
	public static void deselectAll(WebElement q) {
		Select v=new Select(q);
		v.deselectAll();
	}
	public static void simpleAlert() {
		Alert g=driver.switchTo().alert();
		g.accept();
	}
	public static void confirmAlert() {
		Alert k=driver.switchTo().alert();
		k.accept();
	}
	public static void promptAlert(WebElement e,String s) {
		Alert t=driver.switchTo().alert();
		e.sendKeys(s);
		t.accept();
		}
	public static void snaps(String name) throws IOException {
		TakesScreenshot a=(TakesScreenshot)driver;
		File b = a.getScreenshotAs(OutputType.FILE);
		File c=new File(System.getProperty("user dir")+name+".png");
		FileUtils.copyFile(b, c);
	}
	
	
	
	
	public static void windowHandle() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for(String  x:child) {
		if(!child.equals(x)) {
			driver.switchTo().window(x);
		}}}
	public static  String excel( String excel ,String a, int b,int p) throws IOException {
		
		File f= new File("C:\\JustIn\\Exel\\"+excel+".xlsx");
		
		
		FileInputStream fi=new FileInputStream(f);
		
		Workbook w= new XSSFWorkbook(fi);
		
		Sheet s = w.getSheet(a);
		
		Row r = s.getRow(b);
		
		Cell  c= r.getCell(p);
		
		int type = c.getCellType();
		
		String value=null;
		if(type==1) {
			 value = c.getStringCellValue();
			}
	
		else {
			if(DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat  n=new SimpleDateFormat("dd-MM-yyyy");
				value = n.format(date);
			}
			else {
				double numer = c.getNumericCellValue();
				long l=(long)numer;
				 value = String.valueOf(l);
			}}
		return value;
	}
	public static String getData(String excel ,String a, int b,int p,String z) throws IOException {
		File f= new File("C:\\JustIn\\Exel\\"+excel+".xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fi);
		Sheet s = w.getSheet(a);
		
		Row r = s.getRow(b);
		Cell c = r.createCell(p);
		c.setCellValue(z);
		FileOutputStream fo=new FileOutputStream(f);
		w.write(fo);
		return z;
	
		
}
	
 
}
