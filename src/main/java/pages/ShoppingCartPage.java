package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	@FindBy(name = "removefromcart")
	WebElement removeButton;

	@FindBy(css = "a.product-name")
	public WebElement productNameLabel;
	
	@FindBy(css = "div.no-data")
	public WebElement dataClearMessageLabel;
	//Your Shopping Cart is empty!

	@FindBy(css = "input.button-2.update-cart-button")
	WebElement updateShoppingCartButton;

	@FindBy(xpath = "//*[@id=\"itemquantity26646\"]")
	public WebElement quantityTextBox;

	@FindBy(css = "span.product-subtotal")
	public WebElement quantityTotalLabel;
	
	@FindBy(id = "termsofservice")
	WebElement termOfServiceCheckBox;
	
	@FindBy(id = "checkout")
	WebElement checkOutButton;
	
	@FindBy(css = "input.button-1.checkout-as-guest-button")
	WebElement checkOutAsAguestButton;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public void removeProductFromCart() throws InterruptedException {
		clickButton(removeButton);
		Thread.sleep(2000);
		clickButton(updateShoppingCartButton);
	}

	public void updateProductQuantityFromCart(String quantity) throws InterruptedException {
		clearText(quantityTextBox);
		Thread.sleep(2000);
		sendKeysToElement(quantityTextBox, quantity);
		Thread.sleep(2000);
		clickButton(updateShoppingCartButton);
	}
	
	public void openCheckOutPage() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(termOfServiceCheckBox);
		Thread.sleep(2000);
		clickButton(checkOutButton);
	}
	
	public void openCheckOutAsAguestPage() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(checkOutAsAguestButton);
	}
}
