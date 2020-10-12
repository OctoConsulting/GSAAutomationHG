Feature:Cancel feedback before submitting
Scenario: Cancel the Provide feedback by filling in the form from the home page 
	Given Environment COMP_HOME_PAGE 
	And Click on provide feed back on front page button
Then the submit button will be disabled
	When user enters fields for feedback
Then User click on cancel button
	And Click on learning center link
Then user will confirm the cancelation 
	And Navigate into New to beta.SAM.gov page
	And Browser close