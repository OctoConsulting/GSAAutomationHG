Feature: About us & User accounts
Scenario: New to beta Sam gov page 
	Given Environment COMP_HOME_PAGE 
	Then Click on learning center link as the first link
	And Navigate into New to beta.SAM.gov page
	And The user clicks on about us tab 
	Then User successfully navigates into about us page 
	And The user clicks on User Accounts tab 
	Then User successfully navigates into User Accounts page 
	And Browser close