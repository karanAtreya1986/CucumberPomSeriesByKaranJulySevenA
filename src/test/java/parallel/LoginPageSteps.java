package parallel;

import com.pages.LoginPageObject;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginPageSteps {
	
	private static String title;
	private LoginPageObject loginPageObject = new LoginPageObject(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	    //getdriver from driver factory returns web driver and with this web driver we can use all the
	    //browser controls and actions
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() throws InterruptedException {
		Thread.sleep(10000);
		 title=loginPageObject.getLoginPageTitle();
		System.out.println("page title is " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName)); // assert has to come from junit and not testng else we get 
	    //deprecated error.
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPageObject.isForgotPasswordLinkPresent());
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String userName) {
		loginPageObject.enterUserName(userName);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String password) {
		loginPageObject.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPageObject.clickOnSignInButton();
	}

	//we always write assertions in then
	//when is for test actions
	//given is pre condition
}
