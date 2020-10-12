Feature: Role Request verifying random users 
	Description:  The purpose of this feature is to test users
capability for requesting a role and getting relevant feeds notifications

Scenario: request contracting officer role and validate who sees feeds notifications(L2/L3)

Given a new User without role signs in 
When this user requests contract data user role in contracting opportunities 
Then this request should be visible in Sent tab for the new requester in their feeds with status pending 
And browser close
When a user from a different domain as admin logs in
And this request should NOT be visible in feeds Received 
And browser close
When a admin from same domain logs in 
Then this request should be visible in feeds Received 
And browser close
When non department level(L3) admin logs into feeds from the same domain will not see request
And browser close
When a subtier(L2) admin logs into feeds from the same domain will not see request
And browser close
When a user within the same domain without admin privileges logs in they will not see request
And browser close


