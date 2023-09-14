package env;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
		features = {"src/test/resources/features/bestBuyAutomation.feature"},
		glue = {"stepDefinition","Hooks.java"},
		plugin = {"pretty", "html:target/cucumber-reports.html"})

public class RunCukeTest extends AbstractTestNGCucumberTests {

}
