package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistertionPage;

public class UserRegisterationWithDDTAndDataProviderTest extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	UserLogInPage userLogInObject;

	@DataProvider(name = "testDataProviderRegister")
	public static Object [][] userDataRegisteration(){
		return new Object [][] {
			{"zaied", "Moktar", "15", "8", "1984", "zaied2018@gmail.com","123456ddff"},
			{"soltan", "Moktar", "25", "3", "1977", "soltan9999@hotmail.com","ppyy258528"}
			};
	}
	
	@Test(dataProvider = "testDataProviderRegister")
	public void userCanRegisterSuccessfullyAndLogIn(String fName, String lName, String day,
			String month, String year, String email,String password) throws InterruptedException {
		homePageObject = new HomePage(driver);
		userRegisterObject = new UserRegistertionPage(driver);
		homePageObject.openRegisterationPage();
		userRegisterObject.userRegisteration(fName, lName, day, month, year, email, password);
		Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
		userRegisterObject.userLogOut();
		userLogInObject = new UserLogInPage(driver);
		homePageObject.openLogInPage();
		userLogInObject.userLogIn(email,password);
		Assert.assertTrue(userRegisterObject.logoutLink.getText().contains("Log out"));
		userRegisterObject.userLogOut();
	}

}
