package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.PlaceOrderId;
import Base.ProductCart;
import Base.ProductPage;

public class PlaceOrderRWC extends BaseTest{
	WebDriver driver;
	
	public void Setup() {
		driver = intialization("Chrome");
	}

	@Test(priority = 1)
	public void addToCart() {
		PlaceOrderId p = PageFactory.initElements(driver, PlaceOrderId.class);
		ProductPage e = PageFactory.initElements(driver, ProductPage.class);
		e.clickonproduct1();
		System.out.println("Product added to cart");
		p.viewcart.click();
		System.out.println("Viewed the cart");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.proceedToCheck.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.register.click();

	}

	@Test(priority = 2)
	public void registerWhileCheckout() {
		PlaceOrderId p = PageFactory.initElements(driver, PlaceOrderId.class);
		Login d = PageFactory.initElements(driver, Login.class);
		d.enterloginandsignup();
		d.verityEnterinfoTitle();
		d.enterAccountInfoform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean accc = driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed();
		d.verifyaccountCreatedMessage();
		p.cart.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.proceedToCheck.click();

	}

	@Test(priority = 3)
	public void checkoutDetails() {
		PlaceOrderId p = PageFactory.initElements(driver, PlaceOrderId.class);
		System.out.println(p.deliveryaddress.isDisplayed() + ":" + p.deliveryaddress.getText());
		System.out.println(p.billingaddress.isDisplayed() + ":" + p.billingaddress.getText());
		System.out.println(p.revieworder.isDisplayed() + ":" + p.revieworder.getText());
		p.message.sendKeys("Thanks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.placeorder.click();
	}

	@Test(priority = 4)
	public void paymentdetails() {
		PlaceOrderId p = PageFactory.initElements(driver, PlaceOrderId.class);
		p.paymentDetails();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean orderplaced = driver.findElement(By.xpath("//*[text()='Order Placed!']")).isDisplayed();
		boolean orderplacedmsg = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).isDisplayed();
		System.out.println(orderplaced + ": " + orderplacedmsg);
		p.continu.click();
	}

	@Test(priority = 5)
	public void deleteAccount() {
		PlaceOrderId p = PageFactory.initElements(driver, PlaceOrderId.class);
		p.delacc.click();
		boolean delact = driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
		if (delact = true) {
			System.out.println(delact + " " + driver.findElement(By.xpath("//*[text()='Account Deleted!']")).getText());
		} else {
			System.out.println("Not displayed");
		}
		p.continu.click();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
