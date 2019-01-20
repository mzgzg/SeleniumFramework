package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTextBox;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTextTextBox;

	@FindBy(id = "addproductrating_3")
	WebElement ratingOptionRadioButton;

	@FindBy(name = "add-review")
	WebElement submitReviewButton;

	@FindBy(css = "div.result")
	public WebElement reviewNotificationMessage;

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	public void submitReviewForProduct(String reviewTitle, String reviewText) throws InterruptedException {
		sendKeysToElement(reviewTitleTextBox, reviewTitle);
		sendKeysToElement(reviewTextTextBox, reviewText);
		clickButton(ratingOptionRadioButton);
		Thread.sleep(3000);
		clickButton(submitReviewButton);
	}
}
