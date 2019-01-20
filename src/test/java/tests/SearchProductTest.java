package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {

	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test
	public void userCanSearchForProduct() throws InterruptedException {
		searchPageObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchPageObject.productSearch(productName);
		searchPageObject.openProductDetailsPage();
		Assert.assertTrue(productDetailsObject.productNameBreadCramb.getText().equalsIgnoreCase(productName));
	}

}
