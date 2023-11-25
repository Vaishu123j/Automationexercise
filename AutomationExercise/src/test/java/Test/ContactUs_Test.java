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
		p.clickContactUsLink();
		p.VerifyGetInTouchTitle();
		p.EnterAllDetailsofContactUs();
		Alert a = driver.switchTo().alert();
		a.accept();
		p.VerifySuccessMessage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.clickHomePageButton();
		boolean homepage = driver.findElement(By.xpath("//*[text()=' Home']")).isEnabled();
		System.out.println(homepage + ": " + driver.findElement(By.xpath("//*[text()=' Home']")).getText());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
