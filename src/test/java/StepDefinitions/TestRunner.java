package StepDefinitions;


import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/Features", glue="StepDefinitions",
monochrome = true, plugin={"pretty",
		"json:target/cucumber.json"},
	tags="@smoketest"
		)
public class TestRunner {
				
	
}
