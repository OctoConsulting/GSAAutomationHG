Feature: FH NEG Create+Edit department

@FH @FH2 @IntegrationFH
Scenario: User try to create and edit departments with negative inputs. Only FH pmo can do so

Given a FH PMO logs in 
When FH user goes into FH Homepage
Then user Creates a blank Department leaving an error
Then user Creates a Department with only a title leaving an error
Then user Creates a Department with only AC and CJAC leaving an error
Then user Creates a Department with only a TAS leaving an error
Then User Submits Department 
Then user Creates a Department validating start date
Then user Creates a Department validating end date
Then user edits a Department without a description leaving an error
Then user edits a Department validating start date
Then user edits a Department validating end date
Then user cancels making a department
Then the user edits departments to add in a end date
And Browser closes