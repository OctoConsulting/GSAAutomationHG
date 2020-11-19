Feature: FH ORG PICKER Validation

@FH @IntegrationFH
Scenario: FH org picker validation for contracting validation within a L2[argriculture]

Given a contracting officer logs in within a L2
When user creates a new Opportunity
Then user can submit all appropiate details to create opportunity
Then the user search ORG through Org picker 
Then User successfully submits opportunity and then deletes
And Browser closes
