Feature: FH Edit Offices on MINC Because of old req where subtier end date can be outside of its parent department


Scenario: User test edit functionalities of name, start date, end dates for office creation. User test office is no end date and then test an office with end date because there are different set of rules when an end date is in place for creation. On MINC Because of old req where subtier end date can be outside of its parent department

Given a FH PMO logs in 
When FH user goes into FH Homepage
Then the user should be able to find an office to start an edit of a office which has a end date from creation
Then the user will edit the office name
Then the user will edit the office start date which has a end date from creation
Then the user will edit the office end date which has a end date from creation
When user edits the contract awards office type for an office 
When user edits the financial assistance awards office type for an office 
When user edits the contract funding office type for an office 
When user edits the financial assistance funding office type for an office 
Then user will validate office type validations match based on having a office end date from creation
And Browser closes

Given a FH PMO logs in 
When FH user goes into FH Homepage
Then the user should be able to find an office to start editing
Then the user will edit the office name
Then the user will edit the office start date which does not have a end date from creation
Then the user will edit the office end date which does not have a end date from creation
And the user adds in contracting awards office type and does validations
And the user adds in financial assistance awards office type and does validations
And the user adds in contract funding office type and does validations
And the user adds in financial assistance funding office type and does validations
Then user will validate office type validations match based on NOT having a office end date from creation
And Browser closes