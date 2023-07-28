@Login
Feature: login page feature

@Smoke
Scenario: login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Shop"

@Smoke
Scenario: forgot password link
Given user is on login page
Then forgot your password link should be displayed

@Regression @Skip
Scenario: login with correct credentials
Given user is on login page
When user enters username as "cucumbertesting1960@gmail.com"
And user enters password as "Malaravi@123"
And user clicks on login button
Then user gets the title of the page
And page title should be "My account - My Shop"