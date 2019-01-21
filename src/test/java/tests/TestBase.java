package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	static String downloadPath = System.getProperty("user.dir") + "\\Downloads\\";

	@BeforeSuite
	@Parameters({ "browser" })
	public void startDriver(@Optional("chrome") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(chromeOptions());

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxOptions());

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\Drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			
		} else if (browserName.equalsIgnoreCase("headless")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir") + "\\Drivers\\phantomjs.exe");
			String[] phantomjsArgs = { "--web-security=no", "--ignore-ssl-errors=yes" };
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomjsArgs);
			driver = new PhantomJSDriver(caps);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopDriver() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterMethod
	public void captureScreenShotOnFaluire(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Failed");
			System.out.println("Taking Screen Shot");
			Helper.captureScreenShot(driver, result.getName());
		}
	}

	public static FirefoxOptions firefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", downloadPath);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		options.addPreference("browser.download.manager.showWhenStarting", false);
		options.addPreference("pdfjs.disabled", true);
		return options;
	}

	public static ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
		chromePreferences.put("profile.default.content_settings.popups", 0);
		chromePreferences.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePreferences);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}

}
