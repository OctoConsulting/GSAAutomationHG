Feature:As a Content Admin Go to VIDEO page and Create VIDEO

Scenario: Creates a NEW VIDEO that is blank then create a valid VIDEO
	
	Given CMS Content Admin user logs in 
    And The user navigates to Video page 
	Then user Clicks on new Video
	Then the user trys to submit a blank CMS
	And The user enters Question field 
	And The user enters the Response field 
	Then the user uploads a video from local
	Then The users click on CMS done button 
	And The users click on Video Breadcrumb link 
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish 
	And CMS User successfully published the new CMS
	And Browser close

