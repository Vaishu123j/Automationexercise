package Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")
	public WebElement login;
	@FindBy(name="name")
	public WebElement name;
	@FindBy(xpath="//h2[text()='New User Signup!']//following::input[@name='email']")
	public WebElement emailid;
	@FindBy(xpath="//*[text()='Signup']") 
	public WebElement btn;
	@FindBy(id="id_gender2") 
	public WebElement title;
	@FindBy(id="days")
	public WebElement Day;
	@FindBy(id="password")
	public WebElement psd;
	@FindBy(id="newsletter") 
	public WebElement chk1;
	@FindBy(id="optin") 
	public WebElement chk2;
	@FindBy(id="first_name") 
	public WebElement firstname;
	@FindBy(id="last_name") 
	public WebElement lastname;
	@FindBy(id="company")
	public WebElement company;
	@FindBy(id="address1") 
	public WebElement addrs1;
	@FindBy(id="address2")
	public WebElement addrs2;
	@FindBy(id="state")
	public WebElement state;
	@FindBy(id="city")
	public WebElement city;
	@FindBy(id="zipcode")
	public WebElement zipcode;
	@FindBy(id="mobile_number") 
	public WebElement mobnumber;
	@FindBy(xpath="//*[text()='Create Account']") 
	public WebElement createaccbtn;
	@FindBy(xpath="//*[@class='btn btn-primary']") 
	public WebElement continu;
	@FindBy(xpath="//*[@href='/delete_account']") 
	public WebElement delacc;
	@FindBy(xpath="//*[@href='/logout']")
	public WebElement logout;
	
	

}
