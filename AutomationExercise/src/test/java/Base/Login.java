package Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	WebDriver driver;

	@FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")public WebElement login;
	@FindBy(name = "name")public WebElement name;
	@FindBy(xpath = "//h2[text()='New User Signup!']//following::input[@name='email']")WebElement emailid;
	@FindBy(xpath = "//*[text()='Signup']")WebElement btn;
	@FindBy(id = "id_gender2")WebElement title;
	@FindBy(id = "days")WebElement Day;
	@FindBy(id = "password")WebElement psd;
	@FindBy(id = "newsletter")WebElement chk1;
	@FindBy(id = "optin")WebElement chk2;
	@FindBy(id = "first_name")WebElement firstname;
	@FindBy(id = "last_name")WebElement lastname;
	@FindBy(id = "company")public WebElement company;
	@FindBy(id = "address1")WebElement addrs1;
	@FindBy(id = "address2")WebElement addrs2;
	@FindBy(id = "state")WebElement state;
	@FindBy(id = "city")WebElement city;
	@FindBy(id = "zipcode")WebElement zipcode;
	@FindBy(id = "mobile_number")WebElement mobnumber;
	@FindBy(xpath = "//*[text()='Create Account']")WebElement createaccbtn;
	@FindBy(xpath = "//*[@class='btn btn-primary']")WebElement continuebtn;
	@FindBy(xpath = "//*[@href='/delete_account']")WebElement delacc;
	@FindBy(xpath = "//*[@href='/logout']")WebElement logout;
	@FindBy(xpath = "//*[text()='Account Deleted!']")WebElement Delaccmsg;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void enterloginandsignup() {
		login.click();
		name.sendKeys("Test");
		emailid.sendKeys("testcheck7899@gmail.com");
		btn.click();

	}

	public void verityEnterinfoTitle() {
		boolean eai = driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();
		if (eai = true) {
			System.out.println(
					eai + " " + driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText());
		} else {
			System.out.println("Not displayed");
		}
	}

	public void enterAccountInfoform() {
		title.click();
		psd.sendKeys("Test789@");
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
		chk1.click();
		chk2.click();
		firstname.sendKeys("abcd");
		lastname.sendKeys("Check2");
		company.sendKeys("Software Testing");
		addrs1.sendKeys("789,near pheonix mall");
		addrs2.sendKeys("Street no. 5, Software Testing");
		WebElement country = driver.findElement(By.id("country"));
		Select obj4 = new Select(country);
		obj4.selectByVisibleText("India");
		state.sendKeys("Maharahtra");
		city.sendKeys("Pune");
		zipcode.sendKeys("411048");
		mobnumber.sendKeys("1234567891");
		createaccbtn.click();
	}

	public void verifyaccountCreatedMessage() {

		boolean accc = driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed();
		if (accc = true) {
			System.out.println(accc + " " + driver.findElement(By.xpath("//*[text()='Account Created!']")).getText());
		} else {
			System.out.println("Not displayed");
		}
		continuebtn.click();
		boolean logged = driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).isDisplayed();
		if (logged = true) {
			System.out.println(
					logged + " " + driver.findElement(By.xpath("//*[contains(@class,'fa fa-user')]")).getText());
		} else {
			System.out.println("Not displayed");
		}
	}

	public void loginWithValidCredential() {
		name.sendKeys("Test");
		psd.sendKeys("Test789@");
	}

	public void loginTitle() {
		boolean loginacc = driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();
		if (loginacc = true) {
			System.out.println(
					loginacc + " " + driver.findElement(By.xpath("//*[text()='Login to your account']")).getText());
		} else {
			System.out.println("Not displayed");
		}
	}

	public void invalidCredential() {
		driver.findElement(By.name("email")).sendKeys("testcheck7891@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test789@");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
	}

	public void delAccMsg() {
		boolean delact = Delaccmsg.isDisplayed();
		if (delact = true) {
			System.out.println(delact + " " + Delaccmsg.getText());
		} else {
			System.out.println("Not displayed");
		}
	}

	public void clickonLogin() {
		login.click();
	}

	public void clickoncontinuebutton() {
		continuebtn.click();
	}

	public void clickondelaccount() {
		delacc.click();
	}

}
