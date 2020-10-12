Feature: Create new Glossary

Scenario: As a content CMS admin automate Glossary functionalities


	Given CMS Content Admin user logs in 
    And The user navigates to Glossary page 
    And user Clicks on new Glossary
	Then the user trys to submit a blank CMS
	And The user enters Question field 
	And The user enters the Response field 
	And The user enters CMS keywords fields 
	Then The users click on CMS done button 
	Then The users click on Glossary link
	And users CMS is generated 
	When the user will search the CMS
	Then the user will successfully find the CMS
	When CMS user Clicks on actions dropdown list 
	Then user will click on publish 
	And CMS User successfully published the new CMS
	And Browser close