Feature: FH events page for Subtier Admin

Scenario: FH events page filtering and counts for Subtier Admin
Given a subtier Admin of FH logs in
Then user goes in FH Events page 
And User validates that results shown on events page match the workspace
Then the FH user runs filters on Events Page
When User goes back to workspace
Then the user will enter Event Expired Events Page
Then the FH user runs filters on Events Page 
When user clears all filters total count should be validated
Then user works with pagination
When User goes back to workspace
And Browser closes