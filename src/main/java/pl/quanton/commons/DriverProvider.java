package pl.quanton.commons;

import static net.thucydides.core.util.SystemEnvironmentVariables.createEnvironmentVariables;

import cucumber.api.java.After;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProvider implements DriverSource {

	private WebDriver driver;
	private static final String TIMEOUT_IN_SECONDS = createEnvironmentVariables()
			.getProperty("driver.timeout");

	public WebDriver newDriver() {
		//TODO add support for another bro
		setupChromeDriver();
		driver = new ChromeDriver(chromeOptions());
		driver
				.manage()
				.deleteAllCookies();
		driver
				.manage()
				.timeouts()
				.implicitlyWait(Integer.valueOf(TIMEOUT_IN_SECONDS),
						TimeUnit.SECONDS);
		driver
				.manage()
				.window()
				.maximize();
		return driver;
	}

	private static boolean isHeadlessModeOn() {

		return Boolean.valueOf(createEnvironmentVariables()
				.getProperty("driver.headless"));
	}

	private static void setupChromeDriver() {
		WebDriverManager
				.getInstance(DriverManagerType.CHROME)
				.setup();
	}

	private ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-default-apps");
		options.addArguments("--disable-notifications");
		options.addArguments("--touch-events=disabled");
		options.addArguments("--no-sandbox");
		options.addArguments("--lang=pl");
		options.addArguments("--force-first-run");
		options.addArguments("--block-new-web-contents");
		if (isHeadlessModeOn()) {
			options.setHeadless(true);
			options.addArguments("--whitelisted-ips");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("window-size=" + createEnvironmentVariables().getProperty("browser.headless.resolution"));
		}
		options.setExperimentalOption("useAutomationExtension", false);
		return options;
	}

	@Override
	public boolean takesScreenshots() {
		return false;
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
