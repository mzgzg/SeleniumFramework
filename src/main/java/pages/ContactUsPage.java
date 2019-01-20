package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	@FindBy(id = "FullName")
	WebElement fullNameTestBox;
	
	@FindBy(id = "Email")
	WebElement emailTestBox;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTestBox;
	
	@FindBy(name = "send-email")
	WebElement submitButton;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	public void contactUs(String fName,String email , String enquery) throws InterruptedException {
		sendKeysToElement(fullNameTestBox, fName);
		sendKeysToElement(emailTestBox, email);
		sendKeysToElement(enquiryTestBox, enquery);
		Thread.sleep(2000);
		clickButton(submitButton);
	}

}
