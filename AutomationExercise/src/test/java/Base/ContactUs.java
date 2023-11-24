package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs {
	
	 WebDriver driver;

    
    public ContactUs(WebDriver driver) {
        this.driver = driver;
    }
	
	@FindBy(xpath="//*[@href='/contact_us']")  WebElement contactus;
	@FindBy(xpath="//*[@class='btn btn-success']")  WebElement homePage;
	@FindBy(name = "name")  WebElement Name;
	@FindBy(name = "email")  WebElement Email;
	@FindBy(name ="subject") WebElement Subject;
	@FindBy(name ="message") WebElement Message;
	@FindBy(name="submit") WebElement Submit;
	
	 public void clickContactUsLink() {
	        contactus.click();
	    }

	    public void clickHomePageButton() {
	        homePage.click();
	    }

	    public void enterName(String name) {
	        Name.sendKeys(name);
	    }

	    public void enterEmail(String email) {
	        Email.sendKeys(email);
	    }

	    public void enterSubject(String subject) {
	        Subject.sendKeys(subject);
	    }

	    public void enterMessage(String message) {
	        Message.sendKeys(message);
	    }

	    public void clickSubmit() {
	        Submit.click();
	    }

		

		
		
	}
