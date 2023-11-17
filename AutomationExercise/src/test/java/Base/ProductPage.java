package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	@FindBy(xpath="//*[@href='/products']") 
	public WebElement product;
	@FindBy(xpath="//*[@href='/product_details/1']")
	public WebElement product1;
	@FindBy(xpath="//*[text()='Blue Top']") 
	public WebElement pname;
	@FindBy(xpath="//*[text()='Category']")
	public WebElement pcategory;
	@FindBy(xpath="//*[text()='Rs. 500']")
	public WebElement pprice;
	@FindBy(xpath="//*[text()=' In Stock']") 
	public WebElement pavailability;
	@FindBy(xpath="//*[text()=' New']") 
	public WebElement pconditions;
	@FindBy(xpath="//*[text()=' Polo']")
	public WebElement pbrand;
	@FindBy(xpath="//*[@href='/products']") 
	public WebElement productpage;
	@FindBy(xpath="//*[@id=\"search_product\"]")
	public WebElement searchtextbox;
	@FindBy(xpath="//*[@id='submit_search']")
	public  WebElement searchbtn;
	
	
}
	


