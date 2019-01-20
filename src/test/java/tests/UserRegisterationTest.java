package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistertionPage;

public class UserRegisterationTest extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	UserLogInPage userLogInObject;

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException {
		homePageObject = new HomePage(driver);
		userRegisterObject = new UserRegistertionPage(driver);
		homePageObject.openRegisterationPage();
		userRegisterObject.userRegisteration("saed", "Moktar", "9", "8", "1993", "nahlasa55@hotmail.com",
				"222jaby559988");
		Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = ("userCanRegisterSuccessfully"))
	public void RegisteredUserCanLogOut() throws InterruptedException {
		userRegisterObject.userLogOut();
	}

	@Test(dependsOnMethods = ("RegisteredUserCanLogOut"))
	public void RegisteredUserCanLogIn() throws InterruptedException {
		userLogInObject = new UserLogInPage(driver);
		homePageObject.openLogInPage();
		userLogInObject.userLogIn("nahla258@gmail.com", "222jaby559988");
		Assert.assertTrue(userRegisterObject.logoutLink.getText().contains("Log out"));
		userRegisterObject.userLogOut();
	}
}
