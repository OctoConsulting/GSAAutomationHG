Feature: Automate System Alerts 

Scenario: As a content CMS admin automate Alert creation and filters and visibility on homepage


	Given CMS Content Admin user logs in 
	When user enters system alerts page
	When user sets all the filters back to all
	Then the user will validate pagination is working on alerts
	Then the user will validate all filters and dropdowns on alerts page 
	When a user enters blank values to create a alerts for all types
	And user creates each type of alert so user validates that they are created
	And user expires all the created alerts except one needed for validation
	And user validates that a published alert is visible on the homepage
	And Browser closes