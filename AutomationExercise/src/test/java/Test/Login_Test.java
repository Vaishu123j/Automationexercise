package Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.visio.x2012.main.SheetType;

import Base.BaseTest;
import Base.Login;

public class Login_Test extends BaseTest{
	private static final String Workbook = null;
	WebDriver driver;
	Login p;
	
	@BeforeMethod
	public void SetUp() {
		driver = intialization("Chrome");
		
	}
	
	@Test(priority=1)
	public void registerUser() {
 		Login p = PageFactory.initElements(driver, Login.class);
		p.login.click();
	    p.name.sendKeys("Test");
		p.emailid.sendKeys("testcheck7899@gmail.com");
		p.btn.click();
		
		boolean eai = driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();
		if(eai=true) {
			System.out.println(eai + " " + driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText());
		}
		else {
			System.out.println("Not displayed");
		}
		p.title.click();
		p.psd.sendKeys("Test789@");
		WebElement day = driver.findElement(By.id("days"));
		Select obj1 = new Select(day);
		obj1.selectByValue("29");
		WebElement months = driver.findElement(By.id("months"));
		Select obj2 = new Select(months);
		obj2.selectByVisibleText("July");
		WebElement years = driver.findElement(By.id("years"));
		Select obj3 = new Select(years);
		obj3.selectByValue("1995");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,360)", "");
		p.chk1.click();
		p.chk2.click();
		p.firstname.sendKeys("Check1");
		p.lastname.sendKeys("Check2");
		p.company.sendKeys("Software Testing");
		p.addrs1.sendKeys("789,near pheonix mall");
		p.addrs2.sendKeys("Street no. 5, Software Testing");
		WebElement country = driver.findElement(By.id("country"));
		Select obj4 = new Select(country);
		obj4.selectByVisibleText("India");
		p.state.sendKeys("Maharahtra");
		p.city.sendKeys("Pune");
		p.zipcode.sendKeys("411048");
		p.mobnumber.sendKeys("1234567891");
		p.createaccbtn.click();
		boolean accc= driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed();
		if(accc=true) {
			System.out.println(accc + " "+ driver.findElement(By.xpath("//*[text()='Account Created!']")).getText() );
			}
		else {
			System.out.println("Not displayed");
		}
		p.continu.click();
		boolean logged = driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).isDisplayed();
		if(logged=true) {
			System.out.println(logged + " "+ driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).getText());
			}
		else {
			System.out.println("Not displayed");
		}
		p.delacc.click();
		boolean delact =driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
		if(delact=true) {
			System.out.println(delact + " "+ driver.findElement(By.xpath("//*[text()='Account Deleted!']")).getText());
			}
		else {
			System.out.println("Not displayed");
		}
		p.continu.click();
		}
		
	
	@Test
	public void login_ValidUser() throws Exception {
		Login p = PageFactory.initElements(driver, Login.class);
		p.name.sendKeys("Test");
		p.psd.sendKeys("Test789@");
		boolean loginacc =driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();
		if(loginacc=true) {
			System.out.println(loginacc + " "+ driver.findElement(By.xpath("//*[text()='Login to your account']")).getText());
			}
		else {
			System.out.println("Not displayed");
		}	
		
	}
	@Test(priority=3)
	public void login_InvalidUser() throws Exception {
		Login p = PageFactory.initElements(driver, Login.class);
		p.login.click();
		driver.findElement(By.name("email")).sendKeys("testcheck7891@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test789@");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
	
	boolean msg = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed();
	if(msg=true) {
		System.out.println(msg + ": "+ driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).getText());
		}
	else {
	System.out.println("Not displayed");
	}
	driver.close();
	}
	
	@AfterMethod
	
	public void TearDown() {
		driver.quit();
	}
	
	

}
