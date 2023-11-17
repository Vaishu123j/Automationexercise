package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.ContactUs;

public class ContactUs_Test extends BaseTest{
	WebDriver driver; 
	
	@BeforeMethod
	public void Initialization() {
		driver = intialization("Chrome");
	}
	
	@Test
	public void contact_us() throws Exception, Exception {
	ContactUs p = PageFactory.initElements(driver, ContactUs.class);
	p.contactus.click();
	boolean getintouch =driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed();
	if(getintouch=true) {
		System.out.println(getintouch + ": "+ driver.findElement(By.xpath("//*[text()='Get In Touch']")).getText());
		}
	else {
		System.out.println("Not displayed");
	}
	p.Name.sendKeys("xyz");
	p.Email.sendKeys("xtz@gmail.com");
	p.Subject.sendKeys("product return");
	p.Message.sendKeys("I want to return this product");
	p.Submit.click();
	Alert a = driver.switchTo().alert();
	a.accept();
	boolean successmsg =driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed();
	if(successmsg=true) {
		System.out.println(successmsg + ": "+ driver.findElement(By.xpath("//*[@class='status alert alert-success']")).getText());
		}
	else {
		System.out.println("Not displayed");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	p.homepage.click();
	boolean homepage = driver.findElement(By.xpath("//*[text()=' Home']")).isEnabled();
	System.out.println(homepage + ": " + driver.findElement(By.xpath("//*[text()=' Home']")).getText());
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}


}
