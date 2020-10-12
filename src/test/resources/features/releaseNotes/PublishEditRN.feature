Feature:Edit Release note and publish so user validates that has been published into Release notes homepage and old Note is Archived

Scenario: As a content CMS admin automate release notes functionalities

	Given CMS Content Admin user logs in 
    Then The user click on go to Release notes link 
    When CMS user Clicks on actions dropdown list 
	Then user will click on edit
	And CMS The user enters the REVISED edit field 
	Then The users click on Release done button 
	And The users click on Release link 
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish 
	And CMS User successfully published the new CMS
	Then user will validate that Release note is Archived
	Then user will validate newly published Release Note
	Then user will return to workspace from release notes page
	Then The user click on go to Release notes link 
	And Browser close
	