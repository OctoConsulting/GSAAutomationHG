Feature:As a Content Admin Go to FAQs page and Create FAQ

Scenario: Creates a NEW Faq that is blank then create a valid FAQ 
	
	Given CMS Content Admin user logs in 
    Then The user click on go to FAQs link 
    And The user navigates to FAQs page 
	Then  user Clicks on new FAQs 
	Then the user trys to submit a blank CMS
	And The user enters Question field 
	And The user enters the Response field 
	And The user enters CMS keywords fields 
	And The user clicks on display on homepage
	Then The users click on CMS done button 
	And The users click on FAQs link 
	And users CMS is generated 
	When the user will search the CMS
	Then the user will successfully find the CMS
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish 
	And CMS User successfully published the new CMS
	And Browser closes
	