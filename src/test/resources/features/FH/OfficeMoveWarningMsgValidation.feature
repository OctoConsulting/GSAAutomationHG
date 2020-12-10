@FH @IntegrationFH
Feature: Office and Office type end date error message validations - Negative scenarios

	@WarningMsgValidationForOfficeEndDate
	Scenario: During the move Office end date error message validations with respect to the new parent sub-tier
	
		Given a FH PMO logs in 
		When FH user goes into FH Homepage
		And User navigates to Department "ACTIONS TESTING 2.0"
		And User navigates to Subtier "AUTOMATED_SUBTIER_TEST"
		And User creates an office with end date "01102022", without office type
		And User try to move newly created office to the new Subtier
		Then User validates error message for office move end date is after new Subtier
		And Browser closes
			
	@WarningMsgValidationForOfficeTypeEndDate1
	Scenario: During the move Office type end date error message validations with respect to the new parent sub-tier
	
		Given a FH PMO logs in 
		When FH user goes into FH Homepage
		And User navigates to Department "ACTIONS TESTING 2.0"
		And User navigates to Subtier "AUTOMATED_SUBTIER_TEST"
		And User creates an office no end date, with Contract Awards office type end date "01102022"
		And User try to move newly created office to the new Subtier
		Then User validates error message for office move end date is after new Subtier	
		And Browser closes
		
	@WarningMsgValidationForOfficeTypeEndDate2
	Scenario: During the move Office type end date error message validations with respect to the new parent sub-tier
	
		Given a FH PMO logs in 
		When FH user goes into FH Homepage
		And User navigates to Department "ACTIONS TESTING 2.0"
		And User navigates to Subtier "AUTOMATED_SUBTIER_TEST"
		And User creates an office no end date, with Contract Funding office type end date "01102022"
		And User try to move newly created office to the new Subtier
		Then User validates error message for office move end date is after new Subtier	
		And Browser closes
		
	@WarningMsgValidationForOfficeTypeEndDate3
	Scenario: During the move Office type end date error message validations with respect to the new parent sub-tier
	
		Given a FH PMO logs in 
		When FH user goes into FH Homepage
		And User navigates to Department "ACTIONS TESTING 2.0"
		And User navigates to Subtier "AUTOMATED_SUBTIER_TEST"
		And User creates an office no end date, with Financial Assistance Awards office type end date "01102022"
		And User try to move newly created office to the new Subtier
		Then User validates error message for office move end date is after new Subtier	
		And Browser closes
		
	@WarningMsgValidationForOfficeTypeEndDate4
	Scenario: During the move Office type end date error message validations with respect to the new parent sub-tier
	
		Given a FH PMO logs in 
		When FH user goes into FH Homepage
		And User navigates to Department "ACTIONS TESTING 2.0"
		And User navigates to Subtier "AUTOMATED_SUBTIER_TEST"
		And User creates an office no end date, with Financial Assistance Funding office type end date "01102022"
		And User try to move newly created office to the new Subtier
		Then User validates error message for office move end date is after new Subtier	
		And Browser closes
		
		