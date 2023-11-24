package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.ProductCart;

public class ProductCart_Test extends BaseTest{
	WebDriver driver;

	@BeforeClass
	public void Intialization() {
		driver = intialization("Chrome");
	}

	@Test(priority = 1)
	public void addProduct() {
		boolean homepage = driver.findElement(By.xpath("//*[text()=' Home']")).isEnabled();
		System.out.println(homepage + ": " + driver.findElement(By.xpath("//*[text()=' Home']")).getText());
		ProductCart p = PageFactory.initElements(driver, ProductCart.class);

		p.clickonproductpage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(800,960)", "");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		p.clickonproduct1();
		System.out.println("Product1 added in the cart");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		p.clickonshoppingbutton();
		p.clickonproduct2();
		System.out.println("Product2 added in the cart");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		p.clickonviewcart();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void productprice() {

		boolean item1 = driver.findElement(By.xpath("//*[text()='Blue Top']")).isDisplayed();
		Assert.assertEquals(item1, true);
		System.out.println(item1);
		boolean item2 = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[2]/p")).isDisplayed();
		Assert.assertEquals(item2, true);
		System.out.println(item2);
		ProductCart p = PageFactory.initElements(driver, ProductCart.class);

		System.out.println(p.p1price.isDisplayed() + ": Item1 price is Displayed");
		System.out.println(p.p1quantity.isDisplayed() + ": Item2 price is Displayed");
		System.out.println(p.item1totalprice.isDisplayed() + ": Item1 quantity is Displayed");
		System.out.println(p.p2price.isDisplayed() + ": Item2 quantity is Displayed");
		System.out.println(p.p2quantity.isDisplayed() + ": Item1 totalprice is Displayed");
		System.out.println(p.item2totalprice.isDisplayed() + ": Item2 totalprice is Displayed");
	}

	@Test(priority = 3)
	public void RemoveItemfromcart() {
		ProductCart p = PageFactory.initElements(driver, ProductCart.class);
		boolean cartpage = driver.findElement(By.xpath("//*[text()='Shopping Cart']")).isEnabled();
		System.out.println(cartpage + "Cart Page is Displayed ");
		p.clickondeleteitem();
		System.out.println(p.emptycart.isDisplayed() + p.emptycart.getText());
	}

	@AfterClass
	public void closeApp() {
		driver.close();
	}

}
