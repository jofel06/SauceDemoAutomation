package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.ConfigReader;
import io.cucumber.java.Scenario;

public class Hooks {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setupWebDriver(Scenario scenario) { // Added Scenario argument
        String browserName = ConfigReader.getBrowser();
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
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After
    public void quitWebDriver(Scenario scenario) { // Added Scenario argument
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); //this wil cleanup Thread Local
        }
        System.out.println("Ending scenario: " + scenario.getName());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
