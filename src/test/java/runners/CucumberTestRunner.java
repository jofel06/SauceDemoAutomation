package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "steps", "base" }, // Package containing the step definitions and hooks
        plugin = {"pretty"},
        monochrome = true) // Clean console output (no weird symbols or colors).

public class CucumberTestRunner extends AbstractTestNGCucumberTests{
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
        return super.scenarios();
        }

}
