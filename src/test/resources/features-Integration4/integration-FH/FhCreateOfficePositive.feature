
Feature:FH Create Office Postive Flow- Running Postive scenarios flow
Scenario:User try to create office Postive  Flow. Only FH pmo can do so, Running all positive scenarios for individuals fields


Given a FH PMO logs in 
When FH user goes into FH Homepage
Then the user should be able to find the subtier to create an office
Then the user creates office with a positive flow
And Browser closes
When a dept Admin of FH logs in
When FH user goes into FH Homepage
Then the user should not be able to find the subtier to create an office
And Browser closes
When a subtier Admin of FH logs in
When FH user goes into FH Homepage
Then the user should not be able to find the subtier to create an office
And Browser closes