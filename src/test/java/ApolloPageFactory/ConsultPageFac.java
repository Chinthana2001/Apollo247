package ApolloPageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsultPageFac {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot r;

	public ConsultPageFac(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
//	--------------
//	XPATHS
//	--------------
	
	@FindBy(css = ".icon-ic_account") WebElement icon;
//	@FindBy(xpath="//input[@maxlength=\"10\"]") WebElement phone;
//	@FindBy(xpath="//button[text()=\"Continue\"]") WebElement submit;

//	--------------
//	METHOD
//	--------------
	
	public void background() throws InterruptedException
	{
		icon.click();
//		phone.sendKeys("8105786939");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		submit.click();
	}	

	
//	===============================@INVALID=====================================
	/*
	 * Created By: Chinthana V 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a invalid condition for checking the call option 
	 */
	
//	--------------
//	XPATHS
//	--------------
	
	@FindBy(xpath="//a[@title=\"Online Doctor Consultation\"]") WebElement onlineCon;
	@FindBy(xpath="//div[@id=\"callApollo\"]") WebElement mesg;

//	--------------
//	METHODS
//	--------------
	
	public void OnlineConsult() throws InterruptedException
	{
		onlineCon.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}	
	public String MesgDis()
	{
		return mesg.getText();
	}

	
//	==============================SEARCH=====================================
	/*
	 * Created By: Chinthana V 
	 * Reviewed By: Akasha KC 
	 * Motive: It is to validate search by specialty option 
	 */
	
//	--------------
//	XPATHS
//	--------------
	
	@FindBy(xpath = "//a[@title=\"Doctors by Specialty\"]") WebElement doctor;	
	@FindBy(xpath = "//a[text()=\"clinical nutrition and dietetics\"]") WebElement speci;
	@FindBy(xpath = "//h2[text()=\"clinical nutrition and dietetics\"]") WebElement result;

//	--------------
//	METHODS
//	--------------
	
	public void ClickOnSpec() {
		doctor.click();
	}

	public void ClickOnSpecific() throws InterruptedException {		
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		speci.click();
	}

	public void button() throws InterruptedException, AWTException {
		r=new Robot();
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(1000);
	}

	public String bookings() {
		String res = result.getText();
		System.out.println(res);
		return res;
		
	}
	

//	==============================PROHEALTH=====================================
	/*
	 * Created By: Chinthana V 
	 * Reviewed By: Akasha KC 
	 * Motive: It is to validate subscription to any pro health program  
	 */
	
//	--------------
//	XPATHS
//	--------------
	
	@FindBy(xpath="//a[@title=\"Apollo Pro Health Program\"]") WebElement proHealth;
	@FindBy(xpath="//span[text()=\"Let's go!\"]") WebElement let;
	@FindBy(xpath="//input[@placeholder=\"Name *\"]") WebElement name;
	@FindBy(xpath="//input[@placeholder=\"Phone Number *\"]") WebElement number;
	@FindBy(xpath="//select[@id=\"city\"]") WebElement city;
	@FindBy(xpath="(//select[@id=\"city\"]/optgroup[1]/option[@value=\"1: 3015\"])") WebElement cityy;
	@FindBy(xpath="https://www.askapollo.com/apollo-prohealth?utm_source=askapollo_below_banner&utm_medium=owned_media&utm_campaign=pro_health_below_banner") WebElement result1; 
	
//	--------------
//	METHODS
//	--------------
	
	public void ClickOnPro() throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		proHealth.click();
	}
	public void scroll()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,6000)");
	}
	public void ClickOnLet()
	{
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		let.click();
	}
	public void scroll1()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
	}
	public void ClickOnBook() throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.navigate().to("https://www.askapollo.com/apollo-prohealth?utm_source=askapollo_below_banner&utm_medium=owned_media&utm_campaign=pro_health_below_banner");
	}
	public void scroll2()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,7000)");
	}
	public void EnterName(String n) throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		name.sendKeys(n);
	}
	public void SelectCity() throws InterruptedException
	{
		Thread.sleep(2000);
		city.click();
		Thread.sleep(2000);
		cityy.click();
	}
	public void EnterPhone(String num) throws InterruptedException
	{
		Thread.sleep(2000);
		number.sendKeys(num);
	}
	public String book() 
	{
		String res = result1.getText();
		System.out.println(res);
		return res;	
	}
	
	
//	=============================APPOINTMENTS==================================
	/*
	 * Created By: Chinthana V 
	 * Reviewed By: Akasha KC 
	 * Motive: It is to view all the appointments booked before hand  
	 */
	
//	--------------
//	XPATHS
//	--------------
	
	@FindBy(xpath="//div[@title=\"View active appointments\"]") WebElement active;
	@FindBy(xpath="//p[text()=\"Mrs.padmaja Mandali\"]") WebElement result2;
	
//	--------------
//	METHODS
//	--------------
	
	public void scroll3()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,900)");
	}
	public void ClickOnActive() throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(active)).click();
//		Thread.sleep(1000);
//		active.click();
	}
	public String book1() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(result2));
		String res = result2.getText();
		System.out.println(res);
		return res;
	}
	

//	=============================SHARE=========================================
	/*
	 * Created By: Chinthana V 
	 * Reviewed By: Akasha KC 
	 * Motive: It is to validate share option on a specific specialty 
	 */
	
//	--------------
//	XPATHS
//	--------------
	@FindBy(xpath = "//a[@title=\"All Doctors List\"]") WebElement doctor1;
	@FindBy(xpath = "//a[text()=\"Dr. Ankita Pal\"]") WebElement anki;
	@FindBy(xpath = "(//img[@class=\"Nl lazy DoctorProfileCard_shareIcon__0EvYW\"])") WebElement share;
	@FindBy(xpath="//h2[text()=\"Obstetrics & Gynaecology\"]") WebElement result3;
	
//	--------------
//	METHODS
//	--------------
	
	public void AllDoctors()
	{
		doctor1.click();
	}
	public void ClickDoctor()
	{
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(anki)).click();
	}
	public String ClickShare() throws InterruptedException
	{
		Thread.sleep(1000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", share);
		String res = result3.getText();
		System.out.println(res);
		return res;
	}
	
}
