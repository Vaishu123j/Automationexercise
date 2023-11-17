package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs {
	
	@FindBy(xpath="//*[@href='/contact_us']") public WebElement contactus;
	@FindBy(xpath="//*[@class='btn btn-success']") public WebElement homepage;
	@FindBy(name = "name") public WebElement Name;
	@FindBy(name = "email") public WebElement Email;
	@FindBy(name ="subject")public WebElement Subject;
	@FindBy(name ="message")public WebElement Message;
	@FindBy(name="submit")public WebElement Submit;

}
