package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.BaseTest;
import Base.Login;
import Base.PlaceOrderId;
import Base.ProductCart;
import Base.ProductPage;

public class PlaceOrder extends BaseTest {
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		driver = intialization("Chrome");

	}

	@Test(priority = 1)
	public void loginpage() {
		boolean homepage = driver.findElement(By.xpath("//*[text()=' Home']")).isEnabled();
		System.out.println(homepage + ": " + driver.findElement(By.xpath("//*[text()=' Home']")).getText());
		Login p = PageFactory.initElements(driver, Login.class);
		p.clickonLogin();
		p.enterAccountInfoform();

		boolean logged = driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).isDisplayed();
		if (logged = true) {
			System.out.println(
					logged + " " + driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).getText());
		} else {
			System.out.println("Not displayed");
		}

	}

	@Test(priority = 2)
	public void addTocart() {
		PlaceOrderId p = PageFactory.initElements(driver, PlaceOrderId.class);
		ProductCart d = PageFactory.initElements(driver, ProductCart.class);
		d.clickonproduct1();
		d.clickonviewcart();
		p.proceedToCheck.click();
		p.verifycartTab();
		p.message.sendKeys("Thanks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.placeorder.click();
	}

	@Test(priority = 3)
	public void paymentdetails() {
		PlaceOrderId p = PageFactory.initElements(driver, PlaceOrderId.class);
		p.paymentDetails();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean orderplaced = driver.findElement(By.xpath("//*[text()='Order Placed!']")).isDisplayed();
		boolean orderplacedmsg = driver
				.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).isDisplayed();
		System.out.println(orderplaced + ": " + orderplacedmsg);
		p.continu.click();
	}

	@Test(priority = 4)
	public void deleteAccount() {
		Login p = PageFactory.initElements(driver, Login.class);
		p.clickondelaccount();
		p.delAccMsg();
		p.clickoncontinuebutton();
	}

	@AfterTest
	public void closeApp() {
		driver.close();
	}

}
