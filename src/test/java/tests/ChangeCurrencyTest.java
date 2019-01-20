package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	
	HomePage homePageObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	String productName = "Levi's 511 Jeans";

	@Test(priority = 0)
	public void userCanchangeCurrency() {
		homePageObject = new HomePage(driver);
		homePageObject.chooseCurrency(1);
	}
	
	@Test(priority = 1)
	public void userCanSearchForProductFromSuggestion() throws InterruptedException {
		searchPageObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchPageObject.productSearchUsingSuggest("Levi's");
		Assert.assertTrue(productDetailsObject.productPrice.getText().contains("Ђ"));
		System.out.println(productDetailsObject.productPrice.getText());
	}
}
