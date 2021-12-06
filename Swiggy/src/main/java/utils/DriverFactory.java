package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.BasePage;
import pageFactory.MainPage;
import pageFactory.RestaurantPage;

public class DriverFactory {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static BasePage basePage;
	public static MainPage mainPage;
	public static RestaurantPage restaurantPage;

	public static void setDriver() {

		try {
			// Read Config
			ReadProperties config = new ReadProperties();
			config.loadProperties("config.properties");
			String browser = config.get("browser");

			switch (browser) {

			case "firefox": {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				FirefoxProfile profile = new FirefoxProfile();
				options.setProfile(profile);
				// driver.set(new FirefoxDriver(options));
				driver.set(new FirefoxDriver(options));
			}
				break;

			case "chrome": {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				// driver.set(new ChromeDriver(options));
				driver.set(new ChromeDriver(options));
			}
				break;
			case "edge": {
				WebDriverManager.edgedriver().setup();
				EdgeOptions options = new EdgeOptions();
				// driver.set(new EdgeDriver(options));
				driver.set(new EdgeDriver(options));
			}
				break;
			}
		} catch (Exception e) {
			System.out.println("Fail to setup browser: " + e.getMessage());
		} finally {
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			basePage = PageFactory.initElements(getDriver(), BasePage.class);
			mainPage = PageFactory.initElements(getDriver(), MainPage.class);
		    restaurantPage = PageFactory.initElements(getDriver(), RestaurantPage.class);
		}

	}

	public static WebDriver getDriver() {
		return driver.get();
	}

}
