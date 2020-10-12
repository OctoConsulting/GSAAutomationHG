Feature: Enter all feedback
Scenario: Provide feedback from the home page 
Given Environment COMP_HOME_PAGE 
	And Click on provide feed back on front page button 
	Then the submit button will be disabled
	When user enters fields for feedback
	Then the submit button is enabled to be submitted
	Then the user will validate that data has been stored in the backend using a GET call
	And Browser close