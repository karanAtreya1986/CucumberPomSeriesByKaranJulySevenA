package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {
	
	private ContactUsPage contactUsPage=new ContactUsPage(DriverFactory.getDriver());
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
	  DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=contact");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) 
			throws InvalidFormatException, IOException {
	    //create object of excel reader to read the methods
		ExcelReader reader=new ExcelReader();
		//later on add this to config file and read the path of excel.
		List<Map<String, String>> testData= reader.getData
				("E:\\Naveen Java Training\\Cucumber\\CucumberPomSeriesByKaranJulySevenA\\automation.xlsx", sheetName);
		/**
		 * capture all the row data
		 */
		String heading=testData.get(rowNumber).get("subjectHeading");
		String email=testData.get(rowNumber).get("email");
		String orderReference=testData.get(rowNumber).get("orderReference");
		String message=testData.get(rowNumber).get("message");
		//now fill the contact us form
		contactUsPage.fillContactUsForm(heading, email, orderReference, message);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
	    contactUsPage.clickSend();
	}

	@Then("it shows successful message {string}")
	public void it_shows_successful_message(String expectedSuccessMessage) {
	   String actualSuccessMessage=contactUsPage.getSuccessMessage();
	   Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
	}

}
