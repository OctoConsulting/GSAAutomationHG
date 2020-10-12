Feature:Run filters on Release homepage that narrow down Release Notes 

Scenario: As a content CMS admin automate release notes functionalities

	Given CMS Content Admin user logs in 
    Then The user click on go to Release notes link 
  	And Release user is able to select new status 
	And Release user is able to deselect new filter
	And Release user is able to selects published filter 
	And Release user is able to deselect published filter 
	And Release user is able to selects draft filter 
	And Release user is able to deselect draft filter 
	And Release user is able to selects archived filter 
	And Release user is able to deselect archived filter 
	And Release user is able to search key word 
	Then Release user selects clear filter 
	Then Release user click on descending sort by list 
	And Release click on ascending sort by list 
	And Browser close
	
	

	
	
	
	