Feature: FH Edit Offices on MINC office WITHOUT end date Because of old req where subtier end date can be outside of its parent department

@FH @FH3
Scenario: User test edit functionalities of name, start date, end dates,office type for office creation. User test office is no end date there are different set of rules when an end date is in place for creation. On MINC Because of old req where subtier end date can be outside of its parent department
Validation is done based on office having no end date, validating with parents

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