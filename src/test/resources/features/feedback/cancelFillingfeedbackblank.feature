Feature:  cancel filling FeedBack


Scenario: Cancel the Provide feedback without filling the form from the home page 
	Given Environment COMP_HOME_PAGE 
	And Click on provide feed back on front page button
	Then User click on cancel button
	And Click on learning center link
	And Navigate into New to beta.SAM.gov page
	And Browser close