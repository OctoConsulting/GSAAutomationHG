Feature: Role Assign flow With Feeds 
	Description:  The purpose of this feature is to test users
capability for requesting a role and getting relevant feeds notifications

Scenario: Assign role get feeds notifications 


Given a role admin signs in
When admin searches user
Then admin assigns role to a user
Then the role should be in sent tab in feeds with timestamp,status approved
And browser close
When a User without role signs in 
Then user will see in received tab in feeds with timestamp, status approved 
And browser close
When user from same domain signs in the role should not be in the feeds 
And browser close
When a role admin signs in
Then the admin will delete the role
And status will be in feeds as removed 
And browser close
When a User without role signs in 
And status will be in feeds as removed for the user 
And browser close
