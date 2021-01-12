@FH @EndDateWarningMsgValidation @IntegrationFH 
Feature: Office and Office type end date warning message validations


	@WarningMsgValidationForOfficeEndDate
	Scenario: During the move, Office end date warning message validations with respect to the new parent sub-tier
	
		Given a FH PMO logs in 
		When FH user goes into FH Homepage
		And User navigates to office by searching office name "HGTESTOFFICENOOFFICETYPE"
		#And User navigates to Department "ACTIONS TESTING 2.0"
		#And User navigates to Subtier "AUTOMATED_SUBTIER_TEST_1"
		#And User creates an office "HGTESTOFFICENOOFFICETYPE" with end date "01102022", without office type
		And User try to move newly created office to the new Subtier
		Then User validates error message for office move "Office end date" is after new Subtier
		And Browser closes
			
			
	@WarningMsgValidationForOfficeTypeEndDate
	Scenario Outline: During the move, "<office type>" office type end date warning message validations with respect to the new parent sub-tier
	
		Given a FH PMO logs in 
		When FH user goes into FH Homepage
		And User navigates to office by searching office name "<office name>"
		#And User navigates to Department "ACTIONS TESTING 2.0"
		#And User navigates to Subtier "AUTOMATED_SUBTIER_TEST_1"
		#And User creates an office "HGTESTOFFICETYPECF" no end date, with "Contract Awards" office type end date "01102022"
		And User try to move newly created office to the new Subtier
		Then User validates error message for office move "Office type end date" is after new Subtier
		And Browser closes
		
		Examples:
			| office name         | office type                  |
			| HGTESTOFFICETYPECA  | Contract Awards              |
			| HGTESTOFFICETYPECF  | Contract Funding             |
			| HGTESTOFFICETYPEFAA | Financial Assistance Awards  |
			| HGTESTOFFICETYPEFAF | Financial Assistance Funding |