package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class RegisteredUserCheckOutProductTest extends TestBase {

	HomePage homePageObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage shoppingCartPageObject;
	CheckOutPage checkOutPageObject;
	OrderDetailsPage orderDetailsPageObject;
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
	public void userCanAddProductToChechOutPage() throws InterruptedException {
		shoppingCartPageObject.openCheckOutPage();
		shoppingCartPageObject.openCheckOutAsAguestPage();
		checkOutPageObject = new CheckOutPage(driver);
		checkOutPageObject.guestCanCheckOutProduct("Ali","asdin","ali123654@gmail.com", "Egypt", "Cairo",
				"asd asd asd", "123456", "01112326854");
		Assert.assertTrue(checkOutPageObject.thankYouLabel.getText().contains("Thank you"));
		Assert.assertTrue(checkOutPageObject.successMessageLabel.getText().contains("Your order has been successfully processed!"));
	}
	
	@Test(priority = 4)
	public void userCanPrintProductCheckOutDetails() throws InterruptedException {
		orderDetailsPageObject = new OrderDetailsPage(driver);
		checkOutPageObject.openMoreDetails();
		orderDetailsPageObject.printOrder();
		orderDetailsPageObject.pdfInvoicePrint();
	}
}
