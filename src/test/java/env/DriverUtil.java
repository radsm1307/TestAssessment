package env;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
	public static long DEFAULT_WAIT = 20;
	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public static WebDriver getDefaultDriver() {
		if (driver != null) {
			return driver;
		}
		System.setProperty("webdriver.chrome.driver", "C:/Automation/Webdriver/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void WaitFor(){
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT));
	}
	public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector,
															int seconds) {
		By selection = By.cssSelector(selector);
		return (new WebDriverWait(driver, Duration.ofSeconds(seconds))).until( // ensure element is visible!
				ExpectedConditions.visibilityOfElementLocated(selection));
	}


	public static void closeDriver() {
		if (driver != null) {
			try {
				driver.close();
				driver.quit(); // fails in current geckodriver! TODO: Fixme
			} catch (NoSuchMethodError nsme) { // in case quit fails
			} catch (NoSuchSessionException nsse) { // in case close fails
			} catch (SessionNotCreatedException snce) {} // in case close fails
			driver = null;
		}
	}
}