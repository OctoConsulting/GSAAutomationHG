Feature: Role Request FORL3
	Description:  The purpose of this feature is to test users
capability for requesting a role and getting relevant feeds notifications

Scenario: request L3 role and get feeds notifications 
Given a User without role signs in 
When this user requests L3 OIG ofc of Investigations role
Then this request should be visible in Sent tab for the requester for a l3 in their feeds with status pending and timestamp
And browser close
Given a role admin signs in
Then this request should be visible in recieved tab for the admin for a L1 and L2 in their feeds with status
And browser close
When a L2 user within the same domain signs in(Inspector)
Then this request should be visible in recieved tab for the admin for a L1 and L2 in their feeds with status
And browser close