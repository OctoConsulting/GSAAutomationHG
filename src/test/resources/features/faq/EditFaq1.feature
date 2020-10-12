Feature:As a content Admin Go to FAQs page and publish, edit generated FAQ

Scenario:  Publishes and edits Faq 

	Given CMS Content Admin user logs in 
    Then The user click on go to FAQs link 
   	And The user navigates to FAQs page 
   	And CMS The user is able to selects published filter 
	When CMS user Clicks on actions dropdown list 
	Then user will click on edit
	And CMS The user enters the REVISED edit field 
	And FAQ User successfully click on done button 
	And CMS User successfully makes CMS into draft
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish
	And CMS User successfully published the new CMS
	And Browser closes
		
	
	