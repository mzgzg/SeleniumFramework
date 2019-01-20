package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserAcountPage;
import pages.UserLogInPage;
import pages.UserRegistertionPage;

public class UserAcountTest extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	UserLogInPage userLogInObject;
	UserAcountPage userAccountObject;
	String oldPassword = "qqq123";
	String newPassword = "nnnn321";

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws InterruptedException {
		homePageObject = new HomePage(driver);
		userRegisterObject = new UserRegistertionPage(driver);
		homePageObject.openRegisterationPage();
		userRegisterObject.userRegisteration("ali", "Moktar", "10", "10", "1988", "mmnnbb123@gmail.com",oldPassword);
		Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void registeredUserCanChangePassword() throws InterruptedException {
		userAccountObject = new UserAcountPage(driver);
		userRegisterObject.userNavigateToAccount();
		userAccountObject.userNavigateToChangeHisPassword();
		userAccountObject.userChangeHisPassword(oldPassword,newPassword);
		Assert.assertTrue(userAccountObject.changePassMessageResult.getText().contains("Password was changed"));
	}
	
	@Test(priority = 3)
	public void RegisteredUserCanLogOut() throws InterruptedException {
		userRegisterObject.userLogOut();
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanLogIn() throws InterruptedException {
		userLogInObject = new UserLogInPage(driver);
		homePageObject.openLogInPage();
		userLogInObject.userLogIn("mmnnbb123@gmail.com",newPassword);
		Assert.assertTrue(userRegisterObject.logoutLink.getText().contains("Log out"));
		userRegisterObject.userLogOut();
	}
}
