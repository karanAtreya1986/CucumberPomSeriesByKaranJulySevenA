package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"@target/failedScenarios.txt"}, // path of the failed text file. 
		glue = { "parallel" }, 
		monochrome=true,
		plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
		"timeline:test-output-thread/",
		"rerun:target/failedScenarios.txt" // give the location of the text file which failed.
}

)

public class FailedRuns extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
}
}
