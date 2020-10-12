Feature: Automate Email Notification SubtierAdmin 

Scenario:As a fh subtier Admin, create an office and validate appropriate email.When an office is submitted, user validates that profile page displays "No office types available". Troy gets a email with xml attachment, subtier admin gets email without attachment. 
Validation is done per user verifying the users email, body. When office is edited Troy receives email for some edits-negative scenarios added.

Given a subtier Admin of FH logs in 
When FH user goes into FH Homepage
Then the user should be able to find the subtier to create an office for a subtier admin
And user should receive an email (TROY) with the proper message for subtier admin as requester
Then user should receive an email (SubtierAdmin) with the proper message
When the user edits the name of the office
Then only Troy should receive an email for the edit
When the user edits the start date of the office
Then only Troy should not receive an email for the edit
When the user edits the short name of the office
Then only Troy should not receive an email for the edit
When the user edits the region name of the office
Then only Troy should not receive an email for the edit
When the user edits the address of the office
Then only Troy should receive an email for the edit
When the user edits office to add in a office type of the office
Then only Troy should receive an email for the edit
When the user edits office to add in a office type as financial funding 
Then only Troy should not receive an email for the edit
And Browser closes