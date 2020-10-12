	Feature:  without submitting FeedBack go to learning center

Scenario: Submit the Provide feedback without filling the form from the home page 
	Given Environment COMP_HOME_PAGE 
	And Click on provide feed back on front page button
Then the submit button will be disabled
	When user enters fields for feedback
	Then the submit button is enabled to be submitted
	Then the user will validate that data has been stored in the backend using a GET call
	And Click on learning center link 
	And Navigate into New to beta.SAM.gov page
	And Browser close
	