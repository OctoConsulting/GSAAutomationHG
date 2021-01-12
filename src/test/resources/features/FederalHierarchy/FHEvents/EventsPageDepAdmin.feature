@FH @FhEvents @IntegrationFH
Feature: FH events page for dep admin

@FhEventsDepAdmin
Scenario: FH events page filtering and counts for fh dept admin

	Given a dept Admin of FH logs in
	And user should have events widget visible 
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
