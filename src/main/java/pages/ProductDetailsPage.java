package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCramb;

	@FindBy(css = "div.product-price")
	public WebElement productPrice;

	@FindBy(css = "input.button-2.email-a-friend-button")
	public WebElement emailFriend;
	
	@FindBy(css = "p.content")
	public WebElement addToComparePageSuccessfullyMessage;
	
	@FindBy(linkText = "Add your review")
	public WebElement addYourReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishListButton;
	
	@FindBy(css = "input.button-2.add-to-compare-list-button")
    WebElement addToCompareButton;
	
	@FindBy(linkText = "product comparison")
    WebElement productComparisonLink;
	
	@FindBy(id = "add-to-cart-button-4")
    WebElement addToCartButton;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	public void openEmailToFriendPage() {
		clickButton(emailFriend);
	}
	
	public void openProductReviewPage() {
		clickButton(addYourReviewLink);
	}
	
	public void addProductToWishListPage() {
		clickButton(addToWishListButton);
	}
	
	public void addProductToShoppingCartPage() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(addToCartButton);
	}
	
	public void addProductToComparePage() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(addToCompareButton);
	}
	
	public void openProductComparisonPage() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(productComparisonLink);
	}

}
