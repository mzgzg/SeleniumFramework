package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

	HomePage homePageObject;
	ContactUsPage contactUsPageObject;
	String name = "Mzgzg";
	String email = "mzgzg2013@gmail.com";
	String message = "I am Sorry";

	@Test
	public void userCanContactUs() throws InterruptedException {
		homePageObject = new HomePage(driver);
		contactUsPageObject = new ContactUsPage(driver);
		homePageObject.openContactUsPage();
		contactUsPageObject.contactUs(name, email, message);
		Assert.assertTrue(contactUsPageObject.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}
}
