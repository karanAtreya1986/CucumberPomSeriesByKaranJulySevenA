package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;

public class AccountPageObject {

	private WebDriver driver;
		
	//we will create a list of objects and capture the text from the account section.
	private By accountsSection = By.cssSelector("div.center_column span");
	
	public AccountPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public int getAccountSectionCount() {
		return driver.findElements(accountsSection).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountsList=new ArrayList<>();
		List<WebElement> accountsHeadersList=driver.findElements(accountsSection);
		//using for each we capture the text and store element in new array list
		for(WebElement e:accountsHeadersList) {
			String accountText=e.getText();
			System.out.println(accountText);
			accountsList.add(accountText);
		}
		return accountsList; //to return the list of strings which is easy to manipulate, first we created
		//list of web elements and then captured the text,  store in new list and return the new list. 
	}
	
	/**
	 * this will return the title of the accounts page
	 * @return 
	 */
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
}
