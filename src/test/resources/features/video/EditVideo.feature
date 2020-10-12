Feature:  As a content CMS admin automate Video functionalities 

Scenario:Edit/publish Video


	Given CMS Content Admin user logs in 
    And The user navigates to Video page 
    And CMS The user is able to selects published filter 
	When CMS user Clicks on actions dropdown list 
	Then user will click on edit
	And CMS The user enters the REVISED edit field 
Then The users click on CMS done button 
	And The users click on Video Breadcrumb link 
	And CMS User successfully makes CMS into draft
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish
	And CMS User successfully published the new CMS

	And Browser close