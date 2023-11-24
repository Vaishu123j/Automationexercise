package Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a") WebElement login;
	@FindBy(name="name")public WebElement name;
	@FindBy(xpath="//h2[text()='New User Signup!']//following::input[@name='email']") WebElement emailid;
	@FindBy(xpath="//*[text()='Signup']") WebElement btn;
	@FindBy(id="id_gender2")  WebElement title;
        @FindBy(id="days")WebElement Day;
	@FindBy(id="password") WebElement psd;
	@FindBy(id="newsletter")  WebElement chk1;
	@FindBy(id="optin") WebElement chk2;
	@FindBy(id="first_name")WebElement firstname;
	@FindBy(id="last_name")  WebElement lastname;
	@FindBy(id="company")public WebElement company;
	@FindBy(id="address1") WebElement addrs1;
	@FindBy(id="address2")WebElement addrs2;
	@FindBy(id="state")WebElement state;
	@FindBy(id="city") WebElement city;
	@FindBy(id="zipcode") WebElement zipcode;
	@FindBy(id="mobile_number") WebElement mobnumber;
	@FindBy(xpath="//*[text()='Create Account']") WebElement createaccbtn;
	@FindBy(xpath="//*[@class='btn btn-primary']")  WebElement continu;
	@FindBy(xpath="//*[@href='/delete_account']") WebElement delacc;
	@FindBy(xpath="//*[@href='/logout']") WebElement logout;
	
	public Login(WebDriver driver) {
        this.driver = driver;
    }
	
	public void clickonLogin() {
        login.click();
    }
	public void enternamefield(String Name) {
	name.sendKeys(Name);
	}
	public void enteremailid(String Email) {
	emailid.sendKeys(Email);
	}
	public void clickonbutton() {
	btn.click();
    }
	public void clickontitle() {
	title.click();
    }
	public void clickonDay() {
	Day.click();
    }
	public void clickonpassword(String Password) {
        psd.sendKeys(Password);
    }
	public void clickoncheckbox1() {
	chk1.click();
    }
	public void clickoncheckbox2() {
        chk2.click();
    }
	public void enterfirstnamek(String firstName) {
        firstname.sendKeys(firstName);
    }
	public void enterlastname(String Lastname) {
        lastname.sendKeys(Lastname);
    }
	public void enteraddress(String Address) {
        addrs1.sendKeys(Address);
    }
	public void enteraddress2(String Address2) {
        addrs2.sendKeys(Address2);
    }
	public void enterstate(String State){
        state.sendKeys(State);
    }
	public void entercity (String City){
        city.sendKeys(City);
    }
	public void enterzipcode(String Zipcode) {
        zipcode.sendKeys(Zipcode);
    }
	public void entermobilenumber(String MobileNo) {
	mobnumber .sendKeys(MobileNo);
    }
	public void clickoncreateaccount() {
	createaccbtn.click();
    }
	public void clickoncontinuebutton() {
	continu.click();
    }
	public void clickondelaccount() {
        delacc.click();
    }
	public void clickonlogoutbutton() {
        logout.click();
    }


	
}
