package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase{

	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	ComparePage comparePageObject ;
	String productName1 = "Apple MacBook Pro 13-inch";
	String productName2 = "Asus N551JK-XO076H Laptop";

	@Test(priority = 1)
	public void userCanCompareBetweenProducts() throws InterruptedException {
		searchPageObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		comparePageObject = new ComparePage(driver);
		
		searchPageObject.productSearchUsingSuggest("mac");
		Assert.assertTrue(productDetailsObject.productNameBreadCramb.getText().equalsIgnoreCase(productName1));
		productDetailsObject.addProductToComparePage();
		Assert.assertTrue(productDetailsObject.addToComparePageSuccessfullyMessage.getText().
				contains("The product has been added"));
		driver.navigate().back();
		
		searchPageObject.productSearchUsingSuggest("asus");
		Assert.assertTrue(productDetailsObject.productNameBreadCramb.getText().equalsIgnoreCase(productName2));
		productDetailsObject.addProductToComparePage();
		Assert.assertTrue(productDetailsObject.addToComparePageSuccessfullyMessage.getText().
				contains("The product has been added"));
		
		productDetailsObject.openProductComparisonPage();
		comparePageObject.compareProducts();
	}
	
	@Test(priority = 2)
	public void userCanClearListOfCompareProducts() throws InterruptedException {
		comparePageObject.clearCompareList();
		Assert.assertTrue(comparePageObject.dataClearMessageLabel.getText().contains("You have no items to compare."));
	}
}
