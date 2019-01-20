package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
	
	HomePage homePageObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	WishListPage wishListPageObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void userCanSearchForProductFromSuggestion() throws InterruptedException {
		searchPageObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchPageObject.productSearchUsingSuggest("mac");
		Assert.assertTrue(productDetailsObject.productNameBreadCramb.getText().equalsIgnoreCase(productName));
	}
	
	@Test(priority = 2)
	public void userCanAddProductToWishList() throws InterruptedException {
		homePageObject = new HomePage(driver);
		wishListPageObject = new WishListPage(driver);
		productDetailsObject.addProductToWishListPage();	
	}
	
	@Test(priority = 3)
	public void userCanRemoveProductToWishList() throws InterruptedException {
		homePageObject.openWishListPage();
		wishListPageObject.removeWishList();
		wishListPageObject.updateWishList();
		Assert.assertTrue(wishListPageObject.wishListMessageLabel.getText().contains("The wishlist is empty!"));
	}
}
