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
		p.enterloginandsignup();
		p.verityEnterinfoTitle();
		p.enterAccountInfoform();
		p.verifyaccountCreatedMessage();
	}

	@Test
	public void login_ValidUser() throws Exception {
		Login p = PageFactory.initElements(driver, Login.class);
	        p.loginWithValidCredential();
		p.loginTitle();

	}

	@Test(priority = 3)
	public void login_InvalidUser() throws Exception {
		Login p = PageFactory.initElements(driver, Login.class);
		p.clickonLogin();
		p.invalidCredential();
		

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
