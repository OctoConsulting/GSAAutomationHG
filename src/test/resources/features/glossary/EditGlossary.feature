Feature: Edit/publish Glossary

Scenario: As a content CMS admin automate Glossary functionalities


	Given CMS Content Admin user logs in 
    And The user navigates to Glossary page 
    And CMS The user is able to selects published filter 
	When CMS user Clicks on actions dropdown list 
	Then user will click on edit
	And CMS The user enters the REVISED edit field 
	And Glossary user successfully click on done button 
	Then The users click on Glossary link
	And CMS User successfully makes CMS into draft
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish
	And CMS User successfully published the new CMS
	And Browser close