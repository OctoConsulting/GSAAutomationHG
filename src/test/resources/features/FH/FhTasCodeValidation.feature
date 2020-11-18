Feature: FH TAS code validation


Scenario: There is a department which currently have a TAS Code but has an inactive office say with AAC 123456. Now, I update the TAS code to 98 and try to re-activate the inactive office by clicking edit and removing end date and getting an error. 
After their internal tech discussions, the dev team decided to provide below error message when activating an office that doesnt meet the AAC rules
" The TAS-2 Code for the parent department has changed. Please work with your Federal Hierarchy administrator to update the AAC for this office".
User tries to change the TAS code for a department which has active offices and gets the error message "This department has offices(s) with AAC codes that do not start with the provided TAS-2 Code."

Given a FH PMO logs in 
When FH user goes into FH Homepage
And user searches for a department with inactive offices
Then user edits the TAS code
And user edits a inactive office to active
Then user receives TAS error message on office edit 
When user searches for a department with active offices
And user receives TAS error message on department profile page
When a user searches a department with no tas code
Then user receives correct error message when putting a invalid tas code outside aac
And user searches a department without offices then there is no validation for the TAS 2 code update
Then Once a TAS code is updated a user tries to create an office underneath it, make sure that the AAC gets validated against the newly added TAS Code
And Browser closes