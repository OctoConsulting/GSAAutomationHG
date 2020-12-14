
Feature:FH ORG PICKER
Scenario:Feature:FH org picker endpoint use in KIT

Given a user goes to Org Picker endpoint
Then the user will validate departments are all in order
Then the user will validate inactive departments are all in order
Then the user will validate subtier are all in order
Then the user will validate major command are all in order
Then the user will validate sub-command are all in order
Then the user will validate office are all in order
And Browser closes