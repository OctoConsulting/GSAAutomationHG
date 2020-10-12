Feature:Feed Filters/SideBar
	Description:  The purpose of this feature is to test filter
capability for user and getting relevant feeds notifications

Scenario: Run all side filters on feeds page to see if all is functional 

Given assistance admin logs in
When User goes to feeds homepage
Then User validates sent and received tabs
When User validates search request box
And user clear filters for feeds
Then User validates search requester box
And user clear filters for feeds
Then validates search approver box
And user clear filters for feeds
When User validates search organization box
And user clear filters for feeds
Then user validates that a non GSA dept will not show up in request(DEPT OF ARGRICULTURE)
And user clear filters for feeds
Then User validates side request type filters
When User validates side status filers
And user clear filters for feeds
Then user validates that all side request type are valid for Admin, SAM PMO All domain Admin, Contracting user, Contracting Admin
Given a role admin signs in
Then User validates search Entity box 
And browser close