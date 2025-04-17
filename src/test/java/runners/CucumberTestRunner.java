package runners;

import base.Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "steps", "base" }, // Package containing the step definitions and hooks
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true) // Clean console output (no weird symbols or colors).

public class CucumberTestRunner extends AbstractTestNGCucumberTests{
        @BeforeTest
        @Parameters("browser")
        public void setupBrowser(String browser) {
                Hooks.setBrowser(browser); //Passes the browser parameter to Hooks
        }

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}
