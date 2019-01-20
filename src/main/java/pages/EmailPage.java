package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {

	@FindBy(id = "FriendEmail")
	WebElement friendEmailTestBox;
	
	@FindBy(id = "YourEmailAddress")
	WebElement yourEmailAddressTestBox;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageTestBox;
	
	@FindBy(name = "send-email")
	WebElement sendEmailButton;
	
	@FindBy(css = "div.result")
	public WebElement messageResultLabel;
	
	
	public EmailPage(WebDriver driver) {
		super(driver);
	}
	
	public void sendEmailToFriend(String friendEmail , String message) throws InterruptedException {
		sendKeysToElement(friendEmailTestBox, friendEmail);
		sendKeysToElement(personalMessageTestBox, message);
		Thread.sleep(2000);
		clickButton(sendEmailButton);
	}

}
