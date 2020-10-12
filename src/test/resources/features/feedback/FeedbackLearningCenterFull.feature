Feature: Fully enter feedback from homepage
Scenario: enter feedback from Home page
	Given Environment COMP_HOME_PAGE 
	Then Click on learning center link as the first link
	Then Click on the provide feed back link 
	Then the submit button will be disabled
	When user enters fields for feedback
	Then the submit button is enabled to be submitted
	Then the user will validate that data has been stored in the backend using a GET call
	And Browser close