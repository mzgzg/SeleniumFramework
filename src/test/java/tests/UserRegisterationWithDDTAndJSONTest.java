package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistertionPage;

public class UserRegisterationWithDDTAndJSONTest extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	UserLogInPage userLogInObject;
	JsonDataReader jsonDataReaderObjct;

	@Test
	public void userCanRegisterSuccessfullyAndLogIn() throws InterruptedException {
		jsonDataReaderObjct = new JsonDataReader();
		jsonDataReaderObjct.jsonRreader();
		homePageObject = new HomePage(driver);
		userRegisterObject = new UserRegistertionPage(driver);
		homePageObject.openRegisterationPage();
		userRegisterObject.userRegisteration(jsonDataReaderObjct.firstName, jsonDataReaderObjct.lastName,jsonDataReaderObjct.day, jsonDataReaderObjct.month, jsonDataReaderObjct.year, jsonDataReaderObjct.email,jsonDataReaderObjct.passWord);
		Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
		userRegisterObject.userLogOut();
		userLogInObject = new UserLogInPage(driver);
		homePageObject.openLogInPage();
		userLogInObject.userLogIn(jsonDataReaderObjct.email,jsonDataReaderObjct.passWord);
		Assert.assertTrue(userRegisterObject.logoutLink.getText().contains("Log out"));
		userRegisterObject.userLogOut();
	}
}
