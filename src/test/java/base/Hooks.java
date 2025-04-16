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
    public static WebDriver driver;

    @Before
    public void setupWebDriver(Scenario scenario) { // Added Scenario argument
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
        driver.manage().window().maximize();
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After
    public void quitWebDriver(Scenario scenario) { // Added Scenario argument
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Ending scenario: " + scenario.getName());
    }
}
