package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class) // this is the only change when we want serenity report
@CucumberOptions(
		features = { "src/test/resources/parallel/LoginPage.feature" }, 
glue = { "parallel" }, 
plugin = { "pretty"}
		

)

public class SerenityTestRunner {

}
