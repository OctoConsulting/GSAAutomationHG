Feature: Entity Validation and Non Fed Validation for FEEDS
	Description:  The purpose of this feature is to test users
capability for requesting a role and getting relevant feeds notifications

Scenario: Entity tab visibility for Domain Admin. Non Fed user should see role in feeds.


Given a role admin signs in
Then User validates search Entity box 
And browser close