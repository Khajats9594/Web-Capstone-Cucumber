package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/registration.feature",
        plugin = {"pretty","json:target/cucumber.json","html:target/site/cucumber-pretty.html"},
        glue = {"stepDefinition", "dataTableTypeDefinition"},
        tags = "@run"
)
public class UserRegistrationTestRunner {
}
