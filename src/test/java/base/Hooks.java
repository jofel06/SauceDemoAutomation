package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.ConfigReader;

public class Hooks {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setupWebDriver() {
        String browserName = ConfigReader.getBrowser();
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        driver.get(ConfigReader.getUrl());
    }

    @After
    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
