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

	@Test(priority=1)
	public void loginpage(){
		boolean homepage = driver.findElement(By.xpath("//*[text()=' Home']")).isEnabled();
		System.out.println(homepage + ": " + driver.findElement(By.xpath("//*[text()=' Home']")).getText());
		Login p = PageFactory.initElements(driver, Login.class);
		p.clickonLogin();
		p.enternamefield("Test");
		p.enteremailid("testcheck7899@gmail.com");
		p.clickonbutton();
		p.clickontitle();
		p.clickonpassword("Test789@");
		WebElement day = driver.findElement(By.id("days"));
		Select obj1 = new Select(day);
		obj1.selectByValue("29");
		WebElement months = driver.findElement(By.id("months"));
		Select obj2 = new Select(months);
		obj2.selectByVisibleText("July");
		WebElement years = driver.findElement(By.id("years"));
		Select obj3 = new Select(years);
		obj3.selectByValue("1995");
		p.clickoncheckbox1();
		p.clickoncheckbox2();
		p.enterfirstnamek("Check1");
		p.enterlastname("Check2");
		p.company.sendKeys("Software Testing");
		p.enteraddress("789,near pheonix mall");
		p.enteraddress2("Street no. 5, Software Testing");
		WebElement country = driver.findElement(By.id("country"));
		Select obj4 = new Select(country);
		obj4.selectByVisibleText("India");
		p.enterstate("Maharahtra");
		p.entercity("Pune");
		p.enterzipcode("411048");
		p.entermobilenumber("1234567891");
		p.clickoncontinuebutton();

		boolean logged = driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).isDisplayed();
		if(logged=true) {
			System.out.println(logged + " "+ driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).getText());
			}
		else {
			System.out.println("Not displayed");
		}
		
		}
	@Test(priority=2)
	public void addTocart() {
		PlaceOrderId p =PageFactory.initElements(driver, PlaceOrderId.class);
		ProductCart d= PageFactory.initElements(driver, ProductCart.class);
		d.clickonproduct1();
		d.clickonviewcart();
		p.proceedToCheck.click();
		
	
		System.out.println(p.deliveryaddress.isDisplayed() + ":" + p.deliveryaddress.getText());
		System.out.println(p.billingaddress.isDisplayed() + ":" + p.billingaddress.getText());
		System.out.println(p.revieworder.isDisplayed() + ":" + p.revieworder.getText());
		p.message.sendKeys("Thanks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p.placeorder.click();
	}
	@Test(priority=3)
	public void paymentdetails() {
		PlaceOrderId p =PageFactory.initElements(driver, PlaceOrderId.class);
		p.nameOnCard.sendKeys("Shalini Deol");
		p.cardnumber.sendKeys("123456789121");
		p.cvc.sendKeys("123");
		p.expirymonth.sendKeys("02");
		p.expiryyear.sendKeys("2028");
		p.payandconfirm.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	boolean orderplaced= driver.findElement(By.xpath("//*[text()='Order Placed!']")).isDisplayed();
		boolean orderplacedmsg= driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).isDisplayed();
		System.out.println(orderplaced + ": " + orderplacedmsg );
		p.continu.click();
	}
		@Test(priority=4)
		public void deleteAccount() {
		Login p = PageFactory.initElements(driver, Login.class);
		p.clickondelaccount();
		boolean delact =driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
		if(delact=true) {
			System.out.println(delact + " "+ driver.findElement(By.xpath("//*[text()='Account Deleted!']")).getText());
			}
		else {
			System.out.println("Not displayed");
		}
		p.clickoncontinuebutton();
	}

	@AfterTest
	public void closeApp() {
		driver.close();
	}

}

	
		
		
		
	
