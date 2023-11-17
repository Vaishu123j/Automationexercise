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

	@Test(priority=1)
	public void productpage() {
		boolean homepage = driver.findElement(By.xpath("//*[text()=' Home']")).isEnabled();
		System.out.println(homepage + ": " + driver.findElement(By.xpath("//*[text()=' Home']")).getText());
		ProductPage p = PageFactory.initElements(driver, ProductPage.class);
		p.product.click();
//	    Alert s = driver.switchTo().alert();
//    	String sd = driver.switchTo().alert().getText();
//      	System.out.println(sd);
//	    s.dismiss();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		boolean allproducts = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2")).isEnabled();
		System.out.println(allproducts + ": " + driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2")).getText());
		List<WebElement> productlist = driver.findElements(By.xpath("//*[@alt='ecommerce website products']/following::p"));
		for(WebElement plist : productlist) {
			System.out.println(plist.getText());
		}
	}
	@Test(priority=2)
	public void search_Product() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(200, 200);");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ProductPage p = PageFactory.initElements(driver, ProductPage.class);
		p.searchtextbox.sendKeys("Top");
		p.searchbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		je.executeScript("window.scrollBy(500, 500);");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean searchedproduct =driver.findElement(By.xpath("//*[text()='Searched Products']")).isDisplayed();
		if(searchedproduct=true) {
			System.out.println(searchedproduct + ": "+ driver.findElement(By.xpath("//*[text()='Searched Products']")).getText());
			}
		else {
			System.out.println("Not displayed");
	
		
	}
	}
	@Test(priority = 3)
	public void productDetails() throws InterruptedException {
		ProductPage p = PageFactory.initElements(driver, ProductPage.class);
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(750,900)", "");
		p.product1.click();
	
		boolean productdetails = driver.findElement(By.xpath("//*[text()='Blue Top']")).isEnabled();

		System.out.println(productdetails + ": " + driver.findElement(By.xpath("//*[text()='Blue Top']")).getText());

		System.out.println(p.pname.isDisplayed());
		System.out.println(p.pname.getText());
		System.out.println(p.pcategory.isDisplayed());
		System.out.println(p.pcategory.getText());
		System.out.println(p.pprice.isDisplayed());
		System.out.println(p.pprice.getText());
//		Alert a = driver.switchTo().alert();
//		a.dismiss();
		System.out.println(p.pavailability.isDisplayed());
		System.out.println(p.pavailability.getText());
		System.out.println(p.pconditions.isDisplayed());
		System.out.println(p.pconditions.getText());
		System.out.println(p.pbrand.isDisplayed());
		System.out.println(p.pbrand.getText());
	}
	@Test(priority = 4)
	public void ReviewonProduct() {
		boolean homepage = driver.findElement(By.xpath("//*[text()=' Home']")).isEnabled();
		System.out.println(homepage + ": " + driver.findElement(By.xpath("//*[text()=' Home']")).getText());
		ProductPage p = PageFactory.initElements(driver, ProductPage.class);
		p.productpage.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(p.viewproduct.isDisplayed() + ": " + p.viewproduct.getText());
		p.product1.click();
		System.out.println(p.review.isDisplayed() + ": " + p.review.getText());
		p.name.sendKeys("Shalini");
		p.email.sendKeys("testcheck789@gmail.com");
		p.reviewtext.sendKeys("Good Product");
		p.reviewbutton.click();
		System.out.println(p.reviewmsg.isDisplayed() + ": " + p.reviewmsg.getText());
		}
	
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}
}
