@FH @FhEvents @IntegrationFH
Feature: FH events page for non fh user and non fed user

@FhEventsFedNonFed
Scenario: FH events page filtering and counts for non fh user and non fed user

	Given a user whos domain is not FH logs in
	Then the user whos domain is not FH should not have access to events
	And Browser closes
	When a non fed user log in
	Then the user whos domain is not FH should not have access to events
	And Browser closes