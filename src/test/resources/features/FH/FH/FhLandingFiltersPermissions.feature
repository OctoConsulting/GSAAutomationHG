Feature: FH landing pages/FILTERS for FH PMO/DEP/SUBTIER-ADMIN/Non FH user/Non Fed

@FH @IntegrationFH
Scenario: FH Sorting/Pagination/Creating/editing/Administrator rights/FH Widget 
FH landing pages/FILTERS for FH PMO/DEP/SUBTIER-ADMIN/Non FH user/Non Fed
	
Given a FH PMO logs in
Then FH PMO validates all appropriate functions on their landing pages(FH link is visible,Create dep/createL2/L3 are applicable. Administrator icons are visible and Sorts and pagination is working)
#And Browser closes
When a user whos domain is not FH logs in
Then this user will validate FH link is on workspace, and No Admin rights on fh
#And Browser closes
When a dept Admin of FH logs in
Then dept admin will validate all appropriate functions on their landing pages(FH link is visible, createL2/L3 are applicable. Administrator icons are visible and Sorts and pagination is working)
#And Browser closes
When a subtier Admin of FH logs in
Then subtier admin will validate all appropriate functions on their landing pages(FH link is visible, L3 are applicable. Administrator icons are visible and Sorts and pagination is working)
#And Browser closes
When a non fed user log in
Then this NonFed will validate FH link not on workspace, and No Admin rights on fh
#And Browser closes
Then a fed user with no roles signs and validates that FH widget is visible without full counts
And Browser closes