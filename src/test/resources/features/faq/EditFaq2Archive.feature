Feature:Go to FAQs page archive, unarchive generated FAQ

Scenario: User Archives published FAQ then Unarchived a Archived FAQ into a draft.FAQ LOGIN.GOV CONTENT Admin logs in and archived published faq and then unarchives the faq to draft
	
	Given CMS Content Admin user logs in 
    Then The user click on go to FAQs link 
    And The user navigates to FAQs page 
	When CMS user Clicks on actions dropdown list 
	And CMS The user successfully clicks on the archive 
	Then the CMS is archived 
	When CMS user Clicks on actions dropdown list 
	Then CMS The user successfully clicks on the unarchive the CMS
	Then CMS User successfully makes CMS into draft
	When CMS user Clicks on actions dropdown list 
	Then user delete generated CMS
	And Browser closes
	