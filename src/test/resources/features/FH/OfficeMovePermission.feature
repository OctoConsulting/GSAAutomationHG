Feature: FH testing of MOVE permission


Scenario: Testing MOVE permission for various fh users. Super Admin has the "Transfer" permission by default.Super admin can always MOVE an office between one sub-tier to another under a same department
Department admin has the "transfer" permission as an permission.The "Transfer" permission is available, then a department admin can MOVE an office between one sub-tier to another under a same department
Sub-tier admin CAN NOT move an office

	Given a FH PMO logs in 
	When FH user goes into FH Homepage
	Then the user should be able to find an office to start editing
	And Super Admin can always MOVE an office between one sub-tier to another under a same department
	And Browser closes
	When a dept Admin of FH logs in
	When FH user goes into FH Homepage 
	Then Department admin has the "transfer" permission as an permission.The "Transfer" permission is available, then a department admin can MOVE an office between one sub-tier to another under a same department
	And Browser closes
	When a subtier Admin of FH logs in 
	When FH user goes into FH Homepage
	And Sub-tier admin CAN NOT move an office	
	And Browser closes