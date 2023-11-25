package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductQuantity extends BaseTest {
	@FindBy(xpath = "//*[text()='View Product']")
	public WebElement viewproduct;
	@FindBy(id = "quantity")
	public WebElement quantity;
	@FindBy(xpath = "//*[@class='btn btn-default cart']//following::*[@class='fa fa-shopping-cart']")
	public WebElement addtocart;
	@FindBy(xpath = "//*[@class='modal-dialog modal-confirm']//following::*[@href='/view_cart']")
	public WebElement viewcart;
	@FindBy(xpath = "//*[text()='4']")
	public WebElement displayquantity;
	@FindBy(xpath = "//div[@class='modal-dialog modal-confirm']")
	public WebElement popup;
	@FindBy(xpath = "//*[text()='Blue Top']")
	public WebElement product1;
	WebDriver driver;

	@BeforeMethod
	public void Initialization() {
		driver = intialization("Chrome");
	}

	@Test(priority = 1)
	public void productQuality() {
		boolean homepage = driver.findElement(By.xpath("//*[text()=' Home']")).isEnabled();
		System.out.println(homepage + ": " + driver.findElement(By.xpath("//*[text()=' Home']")).getText());
		ProductQuantity p = PageFactory.initElements(driver, ProductQuantity.class);
		p.viewproduct.click();
		p.quantity.clear();
		p.quantity.sendKeys("4");
		p.addtocart.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 2)
	public void viewCart() {
		ProductQuantity p = PageFactory.initElements(driver, ProductQuantity.class);
		p.viewcart.click();
		p.product1.isDisplayed();
		System.out.println("Product is Displayed : " + p.product1.getText());
		p.displayquantity.isDisplayed();
		System.out.println("Product Quantity is : " + p.displayquantity.getText());

	}

	@BeforeMethod
	public void TearDown() {
		driver.quit();

	}
}
