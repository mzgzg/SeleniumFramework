package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLogInPage extends PageBase {

	@FindBy(id = "Email")
	WebElement emailTextBox;

	@FindBy(id = "Password")
	WebElement passwordTextBox;

	@FindBy(css="input.button-1.login-button")
	WebElement logInButton;
	
	
	public UserLogInPage(WebDriver driver) {
		super(driver);
	}
	
	public void userLogIn(String email, String pass) throws InterruptedException {
		
		sendKeysToElement(emailTextBox, email);
		sendKeysToElement(passwordTextBox, pass);
		Thread.sleep(3000);
		clickButton(logInButton);
	}

}
