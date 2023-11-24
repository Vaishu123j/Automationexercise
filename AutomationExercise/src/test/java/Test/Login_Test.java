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
	WebDriver driver;
	Login p;

	@BeforeMethod
	public void SetUp() {
		driver = intialization("Chrome");

	}

	@Test(priority = 1)
	public void registerUser() {
		Login p = PageFactory.initElements(driver, Login.class);
		p.clickonLogin();
		p.enternamefield("Test");
		p.enteremailid("testcheck7899@gmail.com");
		p.clickonbutton();

		boolean eai = driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();
		if (eai = true) {
			System.out.println(
					eai + " " + driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText());
		} else {
			System.out.println("Not displayed");
		}
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,360)", "");
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
		p.clickoncreateaccount();
		boolean accc = driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed();
		if (accc = true) {
			System.out.println(accc + " " + driver.findElement(By.xpath("//*[text()='Account Created!']")).getText());
		} else {
			System.out.println("Not displayed");
		}
		p.clickoncontinuebutton();
		boolean logged = driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).isDisplayed();
		if (logged = true) {
			System.out.println(
					logged + " " + driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).getText());
		} else {
			System.out.println("Not displayed");
		}
		p.clickondelaccount();
		boolean delact = driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
		if (delact = true) {
			System.out.println(delact + " " + driver.findElement(By.xpath("//*[text()='Account Deleted!']")).getText());
		} else {
			System.out.println("Not displayed");
		}
		p.clickoncontinuebutton();
	}

	@Test
	public void login_ValidUser() throws Exception {
		Login p = PageFactory.initElements(driver, Login.class);
		p.enternamefield("Test");
		p.clickonpassword("Test789@");
		boolean loginacc = driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();
		if (loginacc = true) {
			System.out.println(
					loginacc + " " + driver.findElement(By.xpath("//*[text()='Login to your account']")).getText());
		} else {
			System.out.println("Not displayed");
		}

	}

	@Test(priority = 3)
	public void login_InvalidUser() throws Exception {
		Login p = PageFactory.initElements(driver, Login.class);
		p.clickonLogin();
		driver.findElement(By.name("email")).sendKeys("testcheck7891@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test789@");
		driver.findElement(By.xpath("//*[text()='Login']")).click();

		boolean msg = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed();
		if (msg = true) {
			System.out.println(msg + ": "
					+ driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).getText());
		} else {
			System.out.println("Not displayed");
		}
		driver.close();
	}

	@AfterMethod

	public void TearDown() {
		driver.quit();
	}

}
