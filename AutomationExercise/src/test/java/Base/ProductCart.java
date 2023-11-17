package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCart {
	@FindBy(xpath="//*[@href='/products']") public WebElement productpage;
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a") public WebElement product1;
	@FindBy(xpath="//*[@class='modal-footer']//following::*[text()='Continue Shopping']")public WebElement continueshopping;
	@FindBy(xpath="//*[@data-product-id='2'][1]") public WebElement product2;
	@FindBy(xpath="//*[@class='modal-dialog modal-confirm']//following::*[@href='/view_cart']") public WebElement viewcart;
	@FindBy(xpath="//*[text()='Blue Top']//following::*[@class='cart_price'][1]") public WebElement p1price;
	@FindBy(xpath="//*[text()='Blue Top']//following::*[@class='cart_quantity'][1]") public WebElement p1quantity;
	@FindBy(xpath="//*[text()='Blue Top']//following::*[@class='cart_total'][1]") public WebElement item1totalprice;
	@FindBy(xpath="//*[text()='Men > Tshirts']//following::*[@class='cart_price'][1]")public WebElement p2price;
	@FindBy(xpath="//*[text()='Men > Tshirts']//following::*[@class='cart_quantity'][1]")public WebElement p2quantity;
	@FindBy(xpath="//*[text()='Men > Tshirts']//following::*[@class='cart_total'][1]")public WebElement item2totalprice;
	
	@FindBy(xpath="//*[@data-product-id='1']")public WebElement deleteitem;
	@FindBy(xpath="//*[text()='Cart is empty!']") public WebElement emptycart;


}
