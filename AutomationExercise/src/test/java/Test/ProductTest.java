package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.ProductPage;

public class ProductTest extends BaseTest {
	WebDriver driver;
	ProductPage p;

	@BeforeMethod
	public void setup() {
		driver = intialization("Chrome");
	}

	@Test(priority = 1)
	public void productpage() {
        p.verifyHomeTitle();
		ProductPage p = PageFactory.initElements(driver, ProductPage.class);
		p.clickonproduct();
//	    Alert s = driver.switchTo().alert();
//    	String sd = driver.switchTo().alert().getText();
//      	System.out.println(sd);
//	    s.dismiss();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		p.verifyAllProductList();
	}

	@Test(priority = 2)
	public void search_Product() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(200, 200);");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ProductPage p = PageFactory.initElements(driver, ProductPage.class);
		p.clickonsearchtextbox("Top");
		p.clickonsearchbox();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		je.executeScript("window.scrollBy(500, 500);");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		p.VerifySearchproductTitle();
	}

	@Test(priority = 3)
	public void productDetails() throws InterruptedException {
		ProductPage p = PageFactory.initElements(driver, ProductPage.class);

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(750,900)", "");
		p.clickonproduct1();

		boolean productdetails = driver.findElement(By.xpath("//*[text()='Blue Top']")).isEnabled();
		System.out.println(productdetails + ": " + driver.findElement(By.xpath("//*[text()='Blue Top']")).getText());

		p.verifyTitlesofTab();
		driver.close();
	}

	@Test(priority = 4)
	public void ReviewonProduct() {
		p.verifyHomeTitle();
		ProductPage p = PageFactory.initElements(driver, ProductPage.class);
		p.clickonproductpage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(p.viewproduct.isDisplayed() + ": " + p.viewproduct.getText());
		p.clickonproduct1();
		System.out.println(p.review.isDisplayed() + ": " + p.review.getText());
		p.name.sendKeys("Shalini");
		p.email.sendKeys("testcheck789@gmail.com");
		p.reviewtext.sendKeys("Good Product");
		p.clickonreviewbutton();
		System.out.println(p.reviewmsg.isDisplayed() + ": " + p.reviewmsg.getText());
	}

	@AfterMethod
	public void closeApp() {
		driver.quit();
	}
}
