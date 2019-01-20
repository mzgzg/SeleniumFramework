package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	@FindBy(css = "a.button-2.print-order-button")
	WebElement printOrderButton;

	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement pdfInvoiceButton;

	public void printOrder() throws InterruptedException {
		clickButton(printOrderButton);
		Thread.sleep(2000);
	}

	public void pdfInvoicePrint() throws InterruptedException {
		clickButton(pdfInvoiceButton);
		Thread.sleep(2000);
	}

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}

}
