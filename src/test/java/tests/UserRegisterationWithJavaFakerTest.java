package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistertionPage;

public class UserRegisterationWithJavaFakerTest extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	UserLogInPage userLogInObject;
	Random random = new Random();
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String day = Integer.toString(fakeData.number().numberBetween(1, 28));
	String month = Integer.toString(fakeData.number().numberBetween(1, 12));
	String year = Integer.toString(fakeData.number().numberBetween(1960, 1995));
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(12).toString();

	@Test()
	public void userCanRegisterSuccessfully() throws InterruptedException {
		homePageObject = new HomePage(driver);
		userRegisterObject = new UserRegistertionPage(driver);
		homePageObject.openRegisterationPage();
		userRegisterObject.userRegisteration(firstName, lastName, day, month, year, email, password);
		Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
		userRegisterObject.userLogOut();
		userLogInObject = new UserLogInPage(driver);
		homePageObject.openLogInPage();
		userLogInObject.userLogIn(email, password);
		Assert.assertTrue(userRegisterObject.logoutLink.getText().contains("Log out"));
		userRegisterObject.userLogOut();
		System.out.print(firstName + " , " + lastName + " , " + day + " , " + month + " , " + year + " , " + email
				+ " , " + password);
		System.out.println();
	}
}
