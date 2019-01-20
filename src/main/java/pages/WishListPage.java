package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{
	
	@FindBy(name = "removefromcart")
    WebElement removeCheckedBox;
	
	@FindBy(name = "updatecart")
    WebElement updateWishListButton;
	
	@FindBy(css = "div.no-data")
    public WebElement wishListMessageLabel;
	

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	public void removeWishList() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(removeCheckedBox);
	}
	
	public void updateWishList() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(updateWishListButton);
	}

}
