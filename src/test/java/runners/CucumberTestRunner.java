package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "steps", "base" }, // Package containing the step definitions and hooks
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true) // Clean console output (no weird symbols or colors).

public class CucumberTestRunner extends AbstractTestNGCucumberTests{
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
        return super.scenarios();
        }

}
