Feature: As a content admin Run filters on FAQ homepage

Scenario: Run filters on FAQ homepage that narrow down FAQs

	Given CMS Content Admin user logs in 
    Then The user click on go to FAQs link 
    And The user navigates to FAQs page 
    And CMS The user is able to select new status 
	And CMS The user is able to deselect new filter
	And CMS The user is able to selects published filter 
 	And CMS The user is able to deselect published filter 
	And CMS The user is able to selects draft filter 
	And CMS The user is able to deselect draft filter 
	And CMS The user is able to selects archived filter 
	And CMS The user is able to deselect archived filter 
	And The user CMS is able to search key word 
	Then The user CMS selects clear filter 
	Then The user CMS click on descending sort by list 
	And user CMS click on ascending sort by list 
	And Browser closes
	