package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {
	
	HomePage homePageObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage shoppingCartPageObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void userCanSearchForProductFromSuggestion() throws InterruptedException {
		searchPageObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchPageObject.productSearchUsingSuggest("mac");
		Assert.assertTrue(productDetailsObject.productNameBreadCramb.getText().equalsIgnoreCase(productName));
	}
	
	@Test(priority = 2)
	public void userCanAddProductToShoppingCart() throws InterruptedException {
		homePageObject = new HomePage(driver);
		shoppingCartPageObject = new ShoppingCartPage(driver);
		productDetailsObject.addProductToShoppingCartPage();
		homePageObject.openShoppingCartPage();
		Assert.assertTrue(shoppingCartPageObject.productNameLabel.getText().contains(productName));
		Assert.assertTrue(shoppingCartPageObject.quantityTotalLabel.getText().contains("3,600.00"));
	}
	
	@Test(priority = 3)
	public void userCanDeleteProductDetailsInShoppingCart() throws InterruptedException {
		shoppingCartPageObject.removeProductFromCart();
		Assert.assertTrue(shoppingCartPageObject.dataClearMessageLabel.getText().contains("Your Shopping Cart is empty!"));
	}

}
