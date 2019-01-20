package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;

	@FindBy(linkText = "Wishlist")
	WebElement wishListLink;
	
	@FindBy(linkText = "Shopping cart")
	WebElement shoppingCartLink;
	
	@FindBy(id = "customerCurrency")
	WebElement customerCurrency;

	@FindBy(linkText = "Computers")
	WebElement computerMenu;

	@FindBy(linkText = "Notebooks")
	WebElement noteBooksMenu;
	
	@FindBy(linkText = "Desktops")
	WebElement desktopsMenu;
	
	@FindBy(linkText = "Software")
	WebElement softwareMenu;

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	public void openRegisterationPage() {
		clickButton(registerLink);
	}

	public void openLogInPage() {
		clickButton(loginLink);
	}

	public void openContactUsPage() {
		scrollToBottmPage();
		clickButton(contactUsLink);
	}
	
	public void openWishListPage() {
		clickButton(wishListLink);
	}
	
	public void openShoppingCartPage() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(shoppingCartLink);
	}

	public void chooseCurrency(int index) {
		selectIndexFromList(new Select(customerCurrency), index);
	}

	public void selectDesktopsMenu() {
		action.moveToElement(computerMenu).moveToElement(desktopsMenu).click().build().perform();
	}
	public void selectNoteBooksMenu() {
		action.moveToElement(computerMenu).moveToElement(noteBooksMenu).click().build().perform();
	}
	public void selectSoftwareMenu() {
		action.moveToElement(computerMenu).moveToElement(softwareMenu).click().build().perform();
	}
}
