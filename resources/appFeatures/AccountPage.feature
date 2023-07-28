Feature: account page feature

# we will use background here because we want the precondition that the user should be logged in.
# if we change the hooks method and add the login there then out loginpage.feature will be impacted.

Background:
Given user has already logged into application
|userName|password|
|cucumbertesting1960@gmail.com|Malaravi@123|

#since we dont want to parameterise the above background so we used data table instead of examples.

Scenario: accounts page title
Given user is on accounts page
When user gets the title of the page
Then page title should be "My account - My Shop"

Scenario: account sections count
Given user is on accounts page
Then user gets accounts section on the page
#again we use data tables to pass in the data and check if all ok
# we dont want to parameterise, just verification of data
|ADD MY FIRST ADDRESS|
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|Home|
And account section page should have count as 6