package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserRegistertionPage extends PageBase {

	@FindBy(id = "gender-male")
	WebElement maleRadioButton;

	@FindBy(id = "gender-female")
	WebElement femaleRadioButton;

	@FindBy(id = "FirstName")
	WebElement firstNameTextBox;

	@FindBy(id = "LastName")
	WebElement lastNameTextBox;

	@FindBy(name = "DateOfBirthDay")
	WebElement dayMenu;

	@FindBy(name = "DateOfBirthMonth")
	WebElement monthMenu;

	@FindBy(name = "DateOfBirthYear")
	WebElement yearMenu;

	@FindBy(id = "Email")
	WebElement emailTextBox;

	@FindBy(id = "Newsletter")
	WebElement newsletterCheckBox;

	@FindBy(id = "Password")
	WebElement passwordTextBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextBox;

	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(css="div.result")
	public WebElement succesfulNotification;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccount;

	public UserRegistertionPage(WebDriver driver) {
		super(driver);
	}

	public void userRegisteration(String fName, String lName, String day,
			String month, String year, String email,String password) throws InterruptedException {
		
		clickButton(femaleRadioButton);
		sendKeysToElement(firstNameTextBox, fName);
		sendKeysToElement(lastNameTextBox, lName);
		selectValueFromList(new Select(dayMenu), day);
		selectValueFromList(new Select(monthMenu), month);
		selectValueFromList(new Select(yearMenu), year);
		sendKeysToElement(emailTextBox, email);
		clickButton(newsletterCheckBox);
		sendKeysToElement(passwordTextBox, password);
		sendKeysToElement(confirmPasswordTextBox, password);
		Thread.sleep(2000);
		clickButton(registerButton);
	}
	
	public void userRegisterationn(String fName, String lName,String email,String password) throws InterruptedException {
		
		clickButton(maleRadioButton);
		sendKeysToElement(firstNameTextBox, fName);
		sendKeysToElement(lastNameTextBox, lName);
		sendKeysToElement(emailTextBox, email);
		clickButton(newsletterCheckBox);
		sendKeysToElement(passwordTextBox, password);
		sendKeysToElement(confirmPasswordTextBox, password);
		Thread.sleep(2000);
		clickButton(registerButton);
	}
	
	public void userLogOut() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(logoutLink);
	}
	
	public void userNavigateToAccount() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(myAccount);
		
	}

}
