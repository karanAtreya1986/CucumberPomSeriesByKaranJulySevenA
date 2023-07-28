package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPageObject;
import com.pages.LoginPageObject;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPageObject loginPageObject=new LoginPageObject(DriverFactory.getDriver());
	private AccountPageObject accountPageObject;

	@Given("user has already logged into application")
	public void user_has_already_logged_into_application(DataTable credTable) {
	    List<Map<String, String>> credList=credTable.asMaps(); //as maps returns list of map which contains two string
	    //arguments.
	    //get(0) will give the first map pair of strings. from that first map pair we pass the key and get the value.
	    //in our case the first map pair will be username and password.
	    String userName=credList.get(0).get("userName");
	    String password=credList.get(0).get("password");
	    DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	    accountPageObject=loginPageObject.doLogin(userName, password);
	}

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
	 String pageTitle=   accountPageObject.getAccountPageTitle();
	 System.out.println("accounts page title is " + pageTitle);
	}

	@Then("user gets accounts section on the page")
	public void user_gets_accounts_section_on_the_page(DataTable sectionsList) {
		List<String> expectedAccountSectionList= sectionsList.asList();
		System.out.println("expected account section list is " + expectedAccountSectionList);
		
		List<String> actualAccountSectionList = accountPageObject.getAccountsSectionList();
		System.out.println("actual account section list is " + actualAccountSectionList);
		
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("account section page should have count as {int}")
	public void account_section_page_should_have_count_as(Integer expectedAccountSectionCount) {
	    Assert.assertTrue(accountPageObject.getAccountSectionCount()==expectedAccountSectionCount);
	}
}
