package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/parallel/LoginPage.feature"}, 
		glue = { "parallel" }, 
		monochrome=true,
			//	tags = "not @Skip", // do not run @skip scenarios
		plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
		"timeline:test-output-thread/",
		"rerun:target/failedScenarios.txt",/**
		 * rerun plugin should be used for getting failed cases and then run them individually.
		 * it will give one text file, we can give it any name after :
		 * it will generate entry of the failed scenario in the text file.
		 * then create one more runner to run only the failed cases.
		 * @author karan
		 *
		 */
		}

)

public class ParallelRunner extends AbstractTestNGCucumberTests {

	/**
	 * we need to override a method from abstracttestngcucumbertests class
	 * parallel=true means run in parallel, else it will run one by one.
	 * 
	 * @return 2d array containing all scenarios.
	 */
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
