@FH @IntegrationFH
Feature: FH NEG Create+EditSubtier

@CreateEditSubtierNegative
Scenario: User try to create and edit Subtiers negative scenarios. Only FH pmo can do so

	Given a FH PMO logs in 
	When FH user goes into FH Homepage
	Then user attempts to submit a blank subtier
	And user validates that error messages are given
	When user enters some values blank for a subtier
	Then the user validates the correct error messages
	And user edits the subtier to enter blank values
	Then user validates start and end date on subtier during creation
	And Browser closes

