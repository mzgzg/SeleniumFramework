package steps;

import java.util.Random;

import org.testng.Assert;

import com.github.javafaker.Faker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegistertionPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	Random random = new Random();
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String day = Integer.toString(fakeData.number().numberBetween(1, 28));
	String month = Integer.toString(fakeData.number().numberBetween(1, 12));
	String year = Integer.toString(fakeData.number().numberBetween(1970, 1995));
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(12).toString();

	@Given("^The user in home page$")
	public void the_user_in_home_page() throws Throwable {
		homePageObject = new HomePage(driver);
	}

	@When("^user click in register link$")
	public void user_click_in_register_link() throws Throwable {
		homePageObject.openRegisterationPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("^entered his/her data$")
	public void entered_his_her_data() throws Throwable {
		userRegisterObject = new UserRegistertionPage(driver);
		userRegisterObject.userRegisteration(firstName, lastName, day, month, year, email, password);
	}

	@Then("^the registeration page displayed successfully$")
	public void the_registeration_page_displayed_successfully() throws Throwable {

		Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
		Assert.assertTrue(userRegisterObject.logoutLink.getText().contains("Log out"));
		userRegisterObject.userLogOut();
	}
}
