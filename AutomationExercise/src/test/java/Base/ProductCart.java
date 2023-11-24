package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCart {
	WebDriver driver;
	@FindBy(xpath="//*[@href='/products']") WebElement productpage;
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a") WebElement product1;
	@FindBy(xpath="//*[@class='modal-footer']//following::*[text()='Continue Shopping']") WebElement continueshopping;
	@FindBy(xpath="//*[@data-product-id='2'][1]") WebElement product2;
	@FindBy(xpath="//*[@class='modal-dialog modal-confirm']//following::*[@href='/view_cart']")  WebElement viewcart;
	@FindBy(xpath="//*[text()='Blue Top']//following::*[@class='cart_price'][1]")public WebElement p1price;
	@FindBy(xpath="//*[text()='Blue Top']//following::*[@class='cart_quantity'][1]")public  WebElement p1quantity;
	@FindBy(xpath="//*[text()='Blue Top']//following::*[@class='cart_total'][1]")public  WebElement item1totalprice;
        @FindBy(xpath="//*[text()='Men > Tshirts']//following::*[@class='cart_price'][1]")public WebElement p2price;
	@FindBy(xpath="//*[text()='Men > Tshirts']//following::*[@class='cart_quantity'][1]")public WebElement p2quantity;
	@FindBy(xpath="//*[text()='Men > Tshirts']//following::*[@class='cart_total'][1]")public WebElement item2totalprice;
	@FindBy(xpath="//*[@data-product-id='1']") WebElement deleteitem;
	@FindBy(xpath="//*[text()='Cart is empty!']")public  WebElement emptycart;

	public ProductCart(WebDriver driver) {
		this.driver =driver;
	}
	public void clickonproductpage() {
        productpage.click();
	}
	public void clickonproduct1() {
        product1.click();
        }
	public void clickonshoppingbutton() {
        continueshopping.click();
	}
	public void clickonproduct2() {
        product2.click();
	}
	public void clickonviewcart() {
        viewcart.click();
	}

	public void clickonitem2price() {
        productpage.click();
	}
	public void clickondeleteitem() {
        deleteitem.click();
	}
	public void clickonemptycart() {
        emptycart.click();
	}
	
}
	
