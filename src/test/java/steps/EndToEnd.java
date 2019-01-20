package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistertionPage;
import tests.TestBase;

public class EndToEnd extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage shoppingCartPageObject;
	CheckOutPage checkOutPageObject;
	OrderDetailsPage orderDetailsPageObject;
	
	
	@Given("^The user is in home page$")
	public void the_user_is_in_home_page() throws Throwable {
		homePageObject = new HomePage(driver);

	}

	@When("^user search for \"([^\"]*)\"$")
	public void user_search_for(String productName) throws Throwable {
		searchPageObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchPageObject.productSearchUsingSuggest(productName);
		Assert.assertTrue(productDetailsObject.productNameBreadCramb.getText().equalsIgnoreCase(productName));
	}

	@When("^choose to buy two item$")
	public void choose_to_buy_two_item() throws Throwable {
		productDetailsObject.addProductToShoppingCartPage();
	}

	@When("^move to check out cart and enter personal details on checkout page and place the order$")
	public void move_to_check_out_cart_and_enter_personal_details_on_checkout_page_and_place_the_order()
			throws Throwable {
		homePageObject.openShoppingCartPage();
		shoppingCartPageObject = new ShoppingCartPage(driver);
		shoppingCartPageObject.openCheckOutPage();
		shoppingCartPageObject.openCheckOutAsAguestPage();
		checkOutPageObject = new CheckOutPage(driver);
		checkOutPageObject.guestCanCheckOutProduct("mzgzg","asdain","poioi45@gmail.com", "Egypt", "Cairo",
				"hello hello", "123456", "01112326854");
		Assert.assertTrue(checkOutPageObject.thankYouLabel.getText().contains("Thank you"));
		Assert.assertTrue(checkOutPageObject.successMessageLabel.getText().contains("Your order has been successfully processed!"));
	}

	@Then("^user can view the order and download invoice$")
	public void user_can_view_the_order_and_download_invoice() throws Throwable {
		orderDetailsPageObject = new OrderDetailsPage(driver);
		checkOutPageObject.openMoreDetails();
		orderDetailsPageObject.printOrder();
		orderDetailsPageObject.pdfInvoicePrint();
	}

}
