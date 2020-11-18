Feature: FH Office Move Functionality for office types, versions


Scenario: Offices that are not are moved user cannot edit start dates, office type(Correct versions),Office move twice with correct versions.User Pick a office with no changes and EDIT city and validate version.Then move THE SAME office and check the version there should be four version -current,created,updated, updated. Current version has history tag with blue lining.

Given a FH PMO logs in 
When FH user goes into FH Homepage
Then For offices that are moved, do not allow editing of start date for office and office types (Disable the input date field). Unless its a offices thats not veen moved
When office types move on confirmation office type and start date and end date should not change unless past date 
Then user validates version for office types after a move
When user picks a office with no changes and EDIT city there should be changes in the version and validate the new and old changes.
Then move THE SAME office and check the version there should be four version as current,created,updated,updated 
And Browser closes