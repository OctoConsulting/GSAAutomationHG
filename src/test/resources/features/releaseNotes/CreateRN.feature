Feature: Create Release note and validate that has been published into Release notes homepage

Scenario: As a content CMS admin automate release notes functionalities

	Given CMS Content Admin user logs in 
    Then The user click on go to Release notes link 
  	When Click on new Release 
	When The users enters blank release note
	And The user enters release field 
	And The user enters the overview field 
	And The user enters the details field 
	Then The users click on Release done button 
	And The users click on Release link 
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish 
	And CMS User successfully published the new CMS
	Then user will validate published Release Note
	Then user will return to workspace from release notes page
	And Browser close
	