Feature: contact us feature

Scenario Outline: contact us scenario with different sets of data

Given user navigates to contact us page
When user fills the form from given sheetname "<sheetName>" and rownumber <rowNumber>
And user clicks on send button
Then it shows successful message "Your message has been successfully sent to our team."

Examples:
| sheetName | rowNumber |
| contactus | 0 |
| contactus | 1 |
| contactus | 2 |
| contactus | 3 |
| contactus | 4 |
| contactus | 5 |