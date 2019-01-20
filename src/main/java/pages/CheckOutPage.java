package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstNameLabel;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastNameLabel;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailLabel;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countrySelectMenu;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTextBox;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTextBox;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTextBox;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTextBox;

	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
	WebElement billingAdressContinueButton;

	@FindBy(id = "shippingoption_1")
	WebElement shippingOption1RadioButton;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement shippingMethodContinueButton;

	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement paymentMethodContinueButton;

	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement paymentInformationContinueButton;

	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement confirmOrderButton;

	@FindBy(css = "a.product-name")
	WebElement productNameLabel;

	@FindBy(css = "h1")
	public WebElement thankYouLabel;
	// Thank you
	@FindBy(css = "div.title")
	public WebElement successMessageLabel;
	// Your order has been successfully processed!

	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	public void guestCanCheckOutProduct(String fName, String lName, String email, String country, String city,
			String address, String postcode, String phone) throws InterruptedException {
		sendKeysToElement(firstNameLabel, fName);
		sendKeysToElement(lastNameLabel, lName);
		sendKeysToElement(emailLabel, email);
		selectVisibleTextFromList(new Select(countrySelectMenu), country);
		sendKeysToElement(cityTextBox, city);
		sendKeysToElement(addressTextBox, address);
		sendKeysToElement(postalCodeTextBox, postcode);
		sendKeysToElement(phoneNumberTextBox, phone);
		Thread.sleep(2000);
		clickButton(billingAdressContinueButton);
		clickButton(shippingOption1RadioButton);
		Thread.sleep(2000);
		clickButton(shippingMethodContinueButton);
		Thread.sleep(2000);
		clickButton(paymentMethodContinueButton);
		Thread.sleep(2000);
		clickButton(paymentInformationContinueButton);
		Thread.sleep(2000);
		clickButton(confirmOrderButton);
		Thread.sleep(2000);
	}

	public void openMoreDetails() throws InterruptedException {
		clickButton(orderDetailsLink);
		Thread.sleep(2000);
	}

}
