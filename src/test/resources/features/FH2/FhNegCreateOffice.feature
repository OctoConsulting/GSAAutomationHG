Feature: FH Create Office Negative Flow- Running all negative scenarios for individuals fields

@FH @FH2 @IntegrationFH
Scenario: User try to create office Negative Flow. Only FH pmo can do so, Running all negative scenarios for individuals fields

Given a FH PMO logs in 
When FH user goes into FH Homepage
Then the user should be able to find the subtier to create an office
Then the user will validate Aac requriments 
Then the user will validate office name requriments 
Then the user will validate start date requriments 
Then the user will validate end date requriments 
And user will validate contract awards office type
And user will validate financial assistance award office type
And user will validate contract funding office type
And user will validate financial assistance funding office type
And Browser closes