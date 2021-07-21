package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/java/feature/BikeWale.feature", glue ="steps", monochrome = true)

public class TestBikeWale extends AbstractTestNGCucumberTests {

}
