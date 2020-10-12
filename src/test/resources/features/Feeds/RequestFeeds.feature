Feature: Role Request ENTIRE FLOW FOR ASSISTANCE LISTING With Feeds 
	Description:  The purpose of this feature is to test users
capability for requesting a role and getting relevant feeds notifications

Scenario: request assistance user role and get feeds notifications 


Given a User without role signs in 
When this user requests assistance user role in assistance listing 
Then this request should be visible in Sent tab for the requester in their feeds with status pending and timestamp
And browser close
When non domain admin logs in
And this request should NOT be visible in feeds Received for non domain admin with status pending and timestamp
And browser close
When assistance admin logs in
And this request should be visible in feeds dropdown for assistance admin
And this request should be visible in Received tab for assistance admin with status pending and timestamp
When the request is rejected by the admin
Then rejected status with timestamp and email should be visible in feeds for assistance admin
And browser close
When a User without role signs in 
Then rejected status with timestamp and email should be visible in feeds for user who requested 
And browser close
