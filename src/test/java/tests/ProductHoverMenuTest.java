package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {

	HomePage homePageObject;

	@Test(priority = 1 )
	public void userCanSelectDesktopsSubCategoryFromMainMenu() throws InterruptedException {
		homePageObject = new HomePage(driver);
		homePageObject.selectDesktopsMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("desktops"));
		Thread.sleep(2000);
		driver.navigate().back();
	}

	@Test(priority = 2)
	public void userCanSelectNotebooksSubCategoryFromMainMenu() throws InterruptedException {
		homePageObject = new HomePage(driver);
		homePageObject.selectNoteBooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		Thread.sleep(2000);
		driver.navigate().back();
	}

	@Test(priority = 3)
	public void userCanSelectSoftwareSubCategoryFromMainMenu() throws InterruptedException {
		homePageObject = new HomePage(driver);
		homePageObject.selectSoftwareMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("software"));
		Thread.sleep(2000);
		driver.navigate().back();
	}
}
