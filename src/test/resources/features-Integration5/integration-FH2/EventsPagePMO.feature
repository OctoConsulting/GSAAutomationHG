Feature: FH events page for fh super admin

Scenario: FH events page filtering and counts for FH Super PMO Admin


Given a FH PMO logs in 
Then user goes in FH Events page 
And User validates that results shown on events page match the workspace
Then the FH user runs filters on Events Page
When User goes back to workspace
Then the user will enter Event Expired Events Page
Then the FH user runs filters on Events Page
When user clears all filters total count should be validated
Then user works with pagination
When User goes back to workspace


When FH user goes into FH Homepage
Then fh pmo creates Department for events page check
#When Department Profile is created, user validation description option
#Then user edits Department right after creation
#Then User will do a section edit on each section for codes and header
When User goes back to workspace
Then user will validated that expired event count has gone up
And Browser closes


