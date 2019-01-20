package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistertionPage;

public class AddProductReviewTest extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	ProductReviewPage productReviewPageObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws InterruptedException {
		homePageObject = new HomePage(driver);
		userRegisterObject = new UserRegistertionPage(driver);
		homePageObject.openRegisterationPage();
		userRegisterObject.userRegisteration("soso", "tito", "2", "11", "1987", "mnbvc12345@yahoo.com",
				"sosoGFG345");
		Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void userCanSearchForProductFromSuggestion() throws InterruptedException {
		searchPageObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchPageObject.productSearchUsingSuggest("mac");
		Assert.assertTrue(productDetailsObject.productNameBreadCramb.getText().equalsIgnoreCase(productName));
	}

	@Test(priority = 3)
	public void userCanReviewProduct() throws InterruptedException {
		productDetailsObject.openProductReviewPage();
		productReviewPageObject = new ProductReviewPage(driver);
		productReviewPageObject.submitReviewForProduct("First Review From Mac", "Amazing");
		Assert.assertTrue(productReviewPageObject.reviewNotificationMessage.getText()
				.contains("Product review is successfully added."));
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanLogOut() throws InterruptedException {
		userRegisterObject.userLogOut();
	}
}
