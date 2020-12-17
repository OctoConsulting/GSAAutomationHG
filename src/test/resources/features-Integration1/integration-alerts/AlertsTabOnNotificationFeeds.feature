Feature: Automate System Alerts to show up on Alerts tab on feeds

Scenario: As a content CMS admin automate Alert creation and checks notifications are visible on Alerts feeds page

	Given CMS Content Admin user logs in 
	When user enters system alerts page
	Then the user creates error alert
	And the user validates that error alert is on ALERT notification feeds page
	Then the user creates informational alert
	And the user validates that informational alert is on ALERT notification feeds page
	Then the user creates warning alert
	And the user validates that warning alert is on ALERT notification feeds page
	Then the user creates wage determination alert
	And the user validates that wage determination alert is NOT on ALERT notification feeds page
	Then user runs filters including tabs and search and sort and pagination on alert feeds
	And Browser closes