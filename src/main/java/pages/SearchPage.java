package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;

	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchButton;

	@FindBy(id = "ui-id-1")
	List<WebElement> searchProductList;

	@FindBy(tagName = "h2.product-title")
	WebElement productTitleLabel;

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void productSearch(String productName) throws InterruptedException {

		sendKeysToElement(searchTextBox, productName);
		Thread.sleep(2000);
		clickButton(searchButton);
	}

	public void openProductDetailsPage() {
		clickButton(productTitleLabel);
	}

	public void productSearchUsingSuggest(String productName) throws InterruptedException {
		sendKeysToElement(searchTextBox, productName);
		Thread.sleep(2000);
		searchProductList.get(0).click();
	}

}
