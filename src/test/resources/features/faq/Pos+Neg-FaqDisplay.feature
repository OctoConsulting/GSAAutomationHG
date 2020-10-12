Feature:As a Content Admin Go to FAQs page and Create FAQ that displays 

Scenario: Creates a NEW Faq that displays on homepage and then does not
	
	Given CMS Content Admin user logs in 
    Then The user click on go to FAQs link 
    And The user navigates to FAQs page 
	Then  user Clicks on new FAQs 
	And The user enters Question field 
	And The user enters the Response field 
	And The user enters CMS keywords fields 
	And The user clicks on display on homepage
	Then The users click on CMS done button 
	And The users click on FAQs link 
	And users CMS is generated 
	
	
	When the user will Navigate to Homepage
	Then unpublished faq should not display
	Then the user will go back to workspace from homepage
	Then The user click on go to FAQs link 
    And The user navigates to FAQs page
	
	
	
	
	
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish 
	And CMS User successfully published the new CMS
	
	Then the user will Navigate to Homepage
	Then published faq should display
	Then the user will go back to workspace from homepage
	Then The user click on go to FAQs link 
    And The user navigates to FAQs page
	
	When CMS user Clicks on actions dropdown list 
	Then user will click on edit
	And CMS The user enters the REVISED edit field 
	
	
	And FAQ User successfully click on done button 
	And CMS User successfully makes CMS into draft
	
	Then the user will Navigate to Homepage
	Then published faq should display
	Then the user will go back to workspace from homepage
	Then The user click on go to FAQs link 
    And The user navigates to FAQs page
	
	When CMS user Clicks on actions dropdown list 
	#Then user will click on publish
#And CMS User successfully published the new CMS
	
	
	Then user will click on edit
	And The user clicks on display on homepage
	Then The users click on CMS done button 
	And The users click on FAQs link 
	And users CMS is generated 
		When CMS user Clicks on actions dropdown list 
	Then user will click on publish
	And CMS User successfully published the new CMS
	
	
	
	
	
	
	
		When the user will Navigate to Homepage
	Then unpublished faq should not display
	Then the user will go back to workspace from homepage
	Then The user click on go to FAQs link 
    And The user navigates to FAQs page
	
	And Browser closes
