package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistertionPage;

public class UserRegisterationWithDDTAndPropertiesFileTest extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	UserLogInPage userLogInObject;
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String day = LoadProperties.userData.getProperty("day");
	String month = LoadProperties.userData.getProperty("month");
	String year = LoadProperties.userData.getProperty("year");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException {
		homePageObject = new HomePage(driver);
		userRegisterObject = new UserRegistertionPage(driver);
		homePageObject.openRegisterationPage();
		userRegisterObject.userRegisteration(firstname, lastname, day, month, year, email, password);
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
		userLogInObject.userLogIn(email, password);
		Assert.assertTrue(userRegisterObject.logoutLink.getText().contains("Log out"));
		userRegisterObject.userLogOut();
	}
}
