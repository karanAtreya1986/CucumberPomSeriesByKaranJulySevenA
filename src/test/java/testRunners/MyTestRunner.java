package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/appFeatures/" }, 
glue = { "stepDefinitions", "appHooks" }, 
//this adapter needed for the new extent reports.
//we can generate timeline html reports for threads using timeline plugin. we can know how many threads participated.
//we can see what threads present in a pool, which threads executed which scenario.
//we can give name for timeline .. this is the folder which will be created once test runs.
plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/"}
		

)
public class MyTestRunner {

}
