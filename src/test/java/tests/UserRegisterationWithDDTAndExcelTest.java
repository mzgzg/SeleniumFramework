package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.UserLogInPage;
import pages.UserRegistertionPage;

public class UserRegisterationWithDDTAndExcelTest extends TestBase {

	HomePage homePageObject;
	UserRegistertionPage userRegisterObject;
	UserLogInPage userLogInObject;

	@DataProvider(name = "ExcelDataa")
	public Object[][] userDataRegisterationExcel() throws IOException {
		ExcelReader e = new ExcelReader();
		return e.getExcelData();
	}

	@Test(dataProvider = "ExcelDataa")
	public void userCanRegisterSuccessfullyAndLogInWithExcelDataSheet(String fNamee, String lNamee, String dayy, String monthh, String yearr,
			String emaill, String passwordd) throws InterruptedException {
			homePageObject = new HomePage(driver);
			userRegisterObject = new UserRegistertionPage(driver);
			homePageObject.openRegisterationPage();
			userRegisterObject.userRegisteration(fNamee, lNamee, dayy, monthh, yearr, emaill, passwordd);
			//userRegisterObject.userRegisterationn(fNamee, lNamee,emaill, passwordd);
			Assert.assertTrue(userRegisterObject.succesfulNotification.getText().contains("Your registration completed"));
			userRegisterObject.userLogOut();
			userLogInObject = new UserLogInPage(driver);
			homePageObject.openLogInPage();
			userLogInObject.userLogIn(emaill, passwordd);
			Assert.assertTrue(userRegisterObject.logoutLink.getText().contains("Log out"));
			userRegisterObject.userLogOut();
		
	}
}
