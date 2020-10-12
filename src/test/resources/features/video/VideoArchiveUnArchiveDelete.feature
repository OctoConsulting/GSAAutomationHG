Feature:As a content CMS admin automate Video functionalities 

Scenario:  Edit/publish/Archive/Unarchive/delete on Video 
	
	
	Given CMS Content Admin user logs in 
     And The user navigates to Video page 
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