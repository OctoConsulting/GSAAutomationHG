Feature: Edit/publish/Archive/Unarchive/delete on Glossary 

Scenario: As a content CMS admin automate Glossary functionalities 
	
	
	Given CMS Content Admin user logs in 
    And The user navigates to Glossary page 
    And CMS The user is able to selects published filter 
	When CMS user Clicks on actions dropdown list 
	And CMS The user successfully clicks on the archive 
	Then the CMS is archived 
	And CMS The user is able to deselect published filter
	When CMS user Clicks on actions dropdown list 
	Then CMS The user successfully clicks on the unarchive the CMS
	Then CMS User successfully makes CMS into draft
	When CMS user Clicks on actions dropdown list 
	Then user delete generated CMS
	And Browser close