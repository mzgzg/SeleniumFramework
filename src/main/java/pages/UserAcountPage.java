package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAcountPage extends PageBase{

	@FindBy(linkText = "Change password")
	public WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTextBox;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordTextBox;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPasswordTextBox;
	
	@FindBy(css="input.button-1.change-password-button")
    WebElement changePasswordButton;
	
	@FindBy(css="div.result")
    public WebElement changePassMessageResult;
	
	public UserAcountPage(WebDriver driver) {
		super(driver);
	}
	
	public void userNavigateToChangeHisPassword() {
		clickButton(changePasswordLink);
	}
	
	public void userChangeHisPassword(String oldPass, String newPass) throws InterruptedException {
		sendKeysToElement(oldPasswordTextBox, oldPass);
		sendKeysToElement(newPasswordTextBox, newPass);
		sendKeysToElement(confirmNewPasswordTextBox, newPass);
		Thread.sleep(3000);
		clickButton(changePasswordButton);
	}

}
