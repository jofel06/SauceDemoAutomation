package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.ConfigReader;
import io.cucumber.java.Scenario;


public class Hooks {
    // used ThreadLocal to manage WebDriver instances for parallel execution
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static String browserName;

    // Sets the browser for the test run
    public static void setBrowser(String browser) {
        browserName = browser;
    }
    @Before
    public void setupWebDriver(Scenario scenario) {
        // If no browser is explicitly set, use the default browser from ConfigReader
        if (browserName == null || browserName.isEmpty()) {
            browserName = ConfigReader.getBrowser(); // Default to Chrome if not specified
        }
        Allure.step("Running test on " + browserName + " browser");
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        getDriver().get(ConfigReader.getUrl());
        getDriver().manage().window().maximize();
        System.out.println("Starting scenario: " + scenario.getName() + "on browser: " + browserName);
    }

    @After
    public void quitWebDriver(Scenario scenario) {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
        System.out.println("Ending scenario: " + scenario.getName());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
