Feature: FH Create+EditSubtier


Scenario:User try to create and edit Subtiers. Only FH pmo can do so

Given a FH PMO logs in 
When FH user goes into FH Homepage
Then FH user will create Subtier
And FH user will validate that the subtier has been created
Then the user will edit the Subtier
And FH user will validate that the subtier has been created after edit
Then the user will edit and add an end date to the subtier
And FH user will validate that the subtier has been created after edit
And then the user will search the subtier and validate that its been end dated
And Browser closes
