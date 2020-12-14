Feature:FH Office Move Functionality for office types, versions WITHOUT END DATE before and after move
Scenario:flow with no end date move created, go into updated and check the end date as todays date after move.Check all versions to match corrected end dates if needed. Do move again and validate correct versions including a moved version 


Given a FH PMO logs in 
When FH user goes into FH Homepage
Then user creates office without end date and does validations
And user will move office with no end date and do validations 
Then user will move office once again with no end date and validates version
And Browser closes