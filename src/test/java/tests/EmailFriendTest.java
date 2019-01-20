package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserLogInPage;
import pages.UserRegistertionPage;

public class EmailFriendTest extends TestBase {
	
	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	UserLogInPage userLogInObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	EmailPage emailPageObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority=1)
	public void userCanRegisterSuccessfully() throws InterruptedException {
		homePageObject = new HomePage(driver);
		userRegisterObject = new UserRegistertionPage(driver);
		homePageObject.openRegisterationPage();
		userRegisterObject.userRegisteration("saed", "Moktar", "9", "8", "1993", "poiuy444@hotmail.com","111jaby559988");
		Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void userCanSearchForProductFromSuggestion() throws InterruptedException {
		searchPageObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchPageObject.productSearchUsingSuggest("mac");
	}
	
	@Test(priority=3)
	public void userCanSendEmailToFriend() throws InterruptedException {
		emailPageObject = new EmailPage(driver);
		productDetailsObject.openEmailToFriendPage();
		emailPageObject.sendEmailToFriend("mz2017@hotmail.com", "Hello My Friend");
		Assert.assertTrue(emailPageObject.messageResultLabel.getText().contains("Your message has been sent."));
	}
	
	
	@Test(priority=4)
	public void RegisteredUserCanLogOut() throws InterruptedException {
		userRegisterObject.userLogOut();
	}

}
