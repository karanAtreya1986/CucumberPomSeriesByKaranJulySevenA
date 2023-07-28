package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

	// every page object will have by locators, constructor and page actions.

	private WebDriver driver; // every class will have this webdriver.

	// 1. by locators.
	// by locators are also known as object repositories.

	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPasswordLink = By.linkText("Forgot your password?1111");

	// 2.constructor of the page class
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// page classes should not have assertion.
	// assertion should be written in test class or step def class.

	// 3. page actions: features (behaviour) of the page in the form of methods.

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkPresent() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public void enterUserName(String userName) {
		driver.findElement(emailID).sendKeys(userName);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnSignInButton() {
		driver.findElement(signInButton).click();
	}

	// in step def do not maintain by locators and page methods. its ugly
	// programming.
	// in page object, selenium code should be written in page class.

	// we will write one combine method for login which will take in username,
	// password and login button click

	public AccountPageObject doLogin(String un, String pwd) {
		System.out.println("login with " + un + "pwd " + pwd);
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountPageObject(driver); // this is called page chaining concept.
		//do login gives accounts page once logged in.
	}
	
	//according to page object model, when a method is landing you to next page from the current one
	//then it is that methods responsibility to give you the object of that landing (new) page.
	//this is page chaining concept used in frameworks.
}
