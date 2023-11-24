package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	WebDriver driver;
	@FindBy(xpath = "//*[@href='/products']")
	WebElement product;
	@FindBy(xpath = "//*[@href='/product_details/1']")
	WebElement product1;
	@FindBy(xpath = "//*[text()='Blue Top']")
	public WebElement pname;
	@FindBy(xpath = "//*[text()='Category']")
	public WebElement pcategory;
	@FindBy(xpath = "//*[text()='Rs. 500']")
	public WebElement pprice;
	@FindBy(xpath = "//*[text()=' In Stock']")
	public WebElement pavailability;
	@FindBy(xpath = "//*[text()=' New']")
	public WebElement pconditions;
	@FindBy(xpath = "//*[text()=' Polo']")
	public WebElement pbrand;
	@FindBy(xpath = "//*[@href='/products']")
	WebElement productpage;
	@FindBy(xpath = "//*[@id=\"search_product\"]")
	WebElement searchtextbox;
	@FindBy(xpath = "//*[@id='submit_search']")
	WebElement searchbtn;
	@FindBy(xpath = "//*[text()='All Products']")
	public WebElement viewproduct;
	@FindBy(xpath = "//*[text()='Write Your Review']")
	public WebElement review;
	@FindBy(xpath = "//*[@id='name']")
	public WebElement name;
	@FindBy(xpath = "//*[@id='email']")
	public WebElement email;
	@FindBy(xpath = "//*[@id='review']")
	public WebElement reviewtext;
	@FindBy(xpath = "//*[@id='button-review']")
	WebElement reviewbutton;
	@FindBy(xpath = "//*[text()='Thank you for your review.']")
	public WebElement reviewmsg;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickonproduct() {
		product.click();
	}

	public void clickonproduct1() {
		product1.click();
	}

	public void clickonpname() {
		pname.click();
	}

	public void clickonproductcategory() {
		pcategory.click();
	}

	public void clickonpprice() {
		pprice.click();
	}

	public void clickonproductavailability() {
		pavailability.click();
	}

	public void clickonproductconditions() {
		pconditions.click();
	}

	public void clickproductbrand() {
		productpage.click();
	}

	public void clickonproductpage() {
		productpage.click();
	}

	public void clickonsearchtextbox(String Search) {
		searchtextbox.sendKeys(Search);
	}

	public void clickonsearchbox() {
		searchbtn.click();
	}

	public void clickonviewproduct() {
		viewproduct.click();
	}

	public void clickonreview() {
		review.click();
	}

	public void enternamefield(String Name) {
		name.sendKeys(Name);
	}

	public void enteremailid(String Email) {
		email.sendKeys(Email);
	}

	public void clickonreviewText() {
		reviewtext.click();
	}

	public void clickonreviewbutton() {
		reviewbutton.click();
	}

}
