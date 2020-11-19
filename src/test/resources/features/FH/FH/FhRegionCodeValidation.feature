Feature: FH Region code validation scenarios

@FH @IntegrationFH
Scenario: User(Super admin) test Region code validation scenarios both negative and positive 

Given a FH PMO logs in 
When FH user goes into FH Homepage
Then the user should be able to find an office to start editing
When user runs negative scenarios for region code
When user runs positive scenarios for region code
And Browser closes
