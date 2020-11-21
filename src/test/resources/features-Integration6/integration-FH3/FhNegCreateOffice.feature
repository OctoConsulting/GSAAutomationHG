Feature:FH Create Office Negative Flow- Running all negative scenarios for individuals fields
Scenario:User try to create office Negative Flow. Only FH pmo can do so, Running all negative scenarios for individuals fields


Given a FH PMO logs in 
When FH user goes into FH Homepage
Then the user should be able to find the subtier to create an office
Then the user will validate Aac requriments 
Then the user will validate office name requriments 
Then the user will validate start date requriments 
And Browser closes