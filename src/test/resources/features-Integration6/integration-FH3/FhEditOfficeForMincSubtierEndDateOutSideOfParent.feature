Feature:FH Edit Offices on MINC Office WITH enddate Because of old req where subtier end date can be outside of its parent department
Scenario:User test edit functionalities of name, start date, end dates, office type for office creation. User test when an end date is in place for creation of office. On MINC Because of old req where subtier end date can be outside of its parent department


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

