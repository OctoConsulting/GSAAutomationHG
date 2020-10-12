Feature: Automate Email Notification SuperAdmin and department admin post move

Scenario: As a FH SuperAdmin, department admin, perform a move. When an office is moved.Troy gets a email with xml attachment, super admin gets email without attachment. 
Validation is done per user verifying the users email, body. When office is edited Troy receives email for some edits-negative scenarios added. Same for department admin

Given a FH PMO logs in 
When FH user goes into FH Homepage
And During move, the confirmation page should show new sub-tier's name and its agency code2.
Then On completion of move, the office should now reside under a new parent sub-tier i.e breadcrumb should be updated, office profile should now reflect the new parent sub-tier's name and the office should be available from new sub-tier's hierarchy tab.
Then user should receive an email (TROY) with the proper message post move
Then user should receive an email (SuperAdmin) with the proper message post move
And Browser closes
Given a dept Admin of FH logs in
When FH user goes into FH Homepage 
And user should receive an email (TROY) with the proper message for DepartmentAdmin as requester post move
Then user should receive an email (DepartmentAdmin) with the proper message post move
And Browser closes