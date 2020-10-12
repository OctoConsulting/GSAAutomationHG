Feature:Create a new Assistance Listing for Feeds 
	Description:  The purpose of this feature is to test 
capability for user creating a new Assistance Listing and getting relevant feeds notifications for the appropriate users

Scenario:User creates New Assistance Listing, OMB Admin will not see in feeds, 
Assistance admin will review and move to OMB, OMB Analyst will publish the Listing,
New Listing will be as Approved for OMB Admin and User 

Given assistance user logs in per Assistance Listing
Then assistance user creates a new listing
Then this listing will be in their feeds as sent
And browser close
When a OMB Admin logs in per Assistance Listing
Then there will be no request of a listing in their feeds yet
And browser close
When assistance admin logs per Assistance Listing 
Then assistance admin will review the listing thats fowarded to OMB
And browser close
When OMB Analyst logs in per Assistance Listing
Then the Analyst will Review the listing and approve the Listing
And browser close
When a OMB Admin logs in per Assistance Listing
Then the listing will be in Feeds with status Approved for the Listing
And browser close
Given assistance user logs in per Assistance Listing
Then the listing will be in Assistance Listing page with status Approved for the Listing
And browser close



#VALIDATIONS
#you requested on feeds
#Pending-omb in assistance listing page
#neg blank
#you requested to publish and then pending on feeds
#Pending-omb 
#status published on listing
#status apporved on feeds
#status published on assistance listing page and approved on feeds
#status published on assistance listing page