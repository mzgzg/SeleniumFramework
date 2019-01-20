package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected Actions action;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement btn) {
		btn.click();
	}

	protected static void sendKeysToElement(WebElement element, String key) {
		element.sendKeys(key);
	}

	protected static void selectValueFromList(Select select, String value) {
		select.selectByValue(value);
	}

	protected static void selectIndexFromList(Select select, int index) {
		select.selectByIndex(index);
	}

	protected static void selectVisibleTextFromList(Select select, String value) {
		select.selectByVisibleText(value);
	}
	
	protected static void clearText(WebElement webElement) {
		webElement.clear();
	}

	protected void scrollToBottmPage() {
		js.executeScript("scrollBy(0,2500)");
	}

}
