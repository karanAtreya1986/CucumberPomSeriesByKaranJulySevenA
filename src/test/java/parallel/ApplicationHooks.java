package parallel;

import static org.junit.Assume.assumeTrue;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;
	private String browserName;
	
	/**
	 * we skip the scenario using the value and the order
	 * @param scenario
	 */
	@Before(value="@Skip", order=0)
	public void skipScenario(Scenario scenario) {
		System.out.println("skipped scenario is " + scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order=1)
		public void getProperty() {
			configReader=new ConfigReader();
			prop=configReader.initProp();
		}
	
	@Before(order=2)
	public void launchBrowser() {
		browserName=prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName); // we need to assign driver here, else driver.quit will 
		//give null pointer exception and the webdriver driver declared in step 16 is not pointing anywhere.
	}
	
	//note - in after the order works in reverse direction.
	//order = 2 is executed before order = 1 and order =0.
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot
			String screenshotName=scenario.getName().replaceAll(" ", "_"); // replace all space in file name with _
			byte [] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);// we keep the output type as 
			//bytes or base64 so that it is compatible with jenkins/ci/cd toold
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
	

}
