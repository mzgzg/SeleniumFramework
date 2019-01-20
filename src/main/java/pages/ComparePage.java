package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;

	@FindBy(css = "a.clear-list")
	WebElement clearListButton;

	@FindBy(css = "div.no-data")
	public WebElement dataClearMessageLabel;
	// You have no items to compare.

	@FindBy(tagName = "tr")
	public List<WebElement> allRows;

	@FindBy(tagName = "td")
	List<WebElement> allColumns;

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	public void clearCompareList() throws InterruptedException {
		Thread.sleep(3000);
		clickButton(clearListButton);
	}

	public void compareProducts() {
		System.out.println(allRows.size());
		for (WebElement row : allRows) {
			System.out.println(row.getText());
			for (WebElement cloumn : allColumns) {
				System.out.println(cloumn.getText());
			}
		}
	}
}
