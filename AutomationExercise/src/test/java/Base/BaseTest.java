package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
	WebDriver driver;

	public WebDriver intialization(String BrowserName) {

		// how to read the browser variable?

		if (BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver = new ChromeDriver();
		driver.get("https://automationexercise.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		return driver;
		
		

	}
	public void TearDown() {
		driver.quit();
	}
	

}



