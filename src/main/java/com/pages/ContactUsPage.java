package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	private WebDriver driver;
	
	private By subjectHeading=By.id("id_contact1111");
	private By email=By.id("email");
	private By orderRef=By.name("id_order");
	private By messageText=By.id("message");
	private By submitButton=By.id("submitMessage");
	private By successMessage=By.cssSelector("div#center_column p");
	
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	//order ref and heading are select classes, so we use select class and create select class object and use
	//the select methods.
	
	public void fillContactUsForm(String heading, String emailId, String orderReference, String message) {
		Select select=new Select(driver.findElement(subjectHeading));
		select.selectByVisibleText(heading);
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(orderRef).sendKeys(orderReference);
		driver.findElement(messageText).sendKeys(message);		
	}
	
	public void clickSend() {
		driver.findElement(submitButton).click();
	}
	
	public String getSuccessMessage() {
		return driver.findElement(successMessage).getText();
	}
}
