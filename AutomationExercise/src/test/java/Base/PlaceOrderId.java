package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderId {
	@FindBy(xpath="//*[text()='Proceed To Checkout']")public WebElement proceedToCheck;
	@FindBy(xpath="//*[text()='Your delivery address']") public WebElement deliveryaddress;
	@FindBy(xpath="//*[text()='Your billing address']") public WebElement billingaddress;
	@FindBy(xpath="//*[text()='Review Your Order']") public WebElement revieworder;
	@FindBy(xpath="//*[@name='message']") public WebElement message;
	@FindBy(xpath="//*[text()='Place Order']") public WebElement placeorder;
	@FindBy(xpath="//*[@name='name_on_card']") public WebElement nameOnCard;
	@FindBy(xpath="//*[@name='card_number']") public WebElement cardnumber;
	@FindBy(xpath="//*[@name='cvc']") public WebElement cvc;
	@FindBy(xpath="//*[@name='expiry_month']")public WebElement expirymonth;
	@FindBy(xpath="//*[@name='expiry_year']") public WebElement expiryyear;
	@FindBy(xpath="//*[@id='submit']") public WebElement payandconfirm;
	@FindBy(xpath="//*[@href='/delete_account']")public WebElement delacc;
	@FindBy(xpath="//*[@class='btn btn-primary']") public WebElement continu;
	@FindBy(xpath="//*[@class='modal-dialog modal-confirm']//following::a[@href='/login']")public WebElement register;
	@FindBy(xpath="//*[@class='shop-menu pull-right']//following::*[@href='/login']")public WebElement login;
	@FindBy(name="name")public WebElement name;
	@FindBy(xpath="//h2[text()='New User Signup!']//following::input[@name='email']")public WebElement emailid;
	@FindBy(xpath="//*[text()='Signup']") public WebElement btn;
	@FindBy(id="id_gender2") public WebElement title;
	@FindBy(id="days")public WebElement Day;
	@FindBy(id="password") public WebElement psd;
	@FindBy(id="newsletter")public WebElement chk1;
	@FindBy(id="optin") public WebElement chk2;
	@FindBy(id="first_name")public WebElement firstname;
	@FindBy(id="last_name")public WebElement lastname;
	@FindBy(id="company") public WebElement company;
	@FindBy(id="address1")public WebElement addrs1;
	@FindBy(id="address2")public WebElement addrs2;
	@FindBy(id="state")public WebElement state;
	@FindBy(id="city") public WebElement city;
	@FindBy(id="zipcode")public WebElement zipcode;
	@FindBy(id="mobile_number")public WebElement mobnumber;
	@FindBy(xpath="//*[text()='Create Account']")public WebElement createaccbtn;
	@FindBy(xpath="//*[@class='modal-dialog modal-confirm']//following::*[text()='View Cart']")public WebElement viewcart;
	@FindBy(xpath="//*[@href='/view_cart']") public WebElement cart;
	
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
	public void clickoncartbutton() {
        cart.click();
    }

	

}
