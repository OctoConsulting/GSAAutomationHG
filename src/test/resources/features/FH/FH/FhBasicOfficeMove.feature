Feature: FH Office Move

@FH @IntegrationFH
Scenario: Office Move-Only active offices can be moved i.e. inactive offices and offices that are scheduled to be active cannot be moved (MOVE drop-down doesnt show up)
Offices can be moved between one active sub-tier to another under a same department. (Note: Inactive and scheduled to be active sub-tiers should not show up in the agency picker drop-down)
During office move, same parent sub-tier cannot be chosen. UI Should throw an error if a same parent sub-tier is chosen
During move, the confirmation page should show new sub-tier's name and its agency code.
On completion of move, the office should now reside under a new parent sub-tier i.e breadcrumb should be updated, office profile should now reflect the new parent sub-tier's name and the office should be available from new sub-tier's hierarchy tab.
Validate success messages, error messages, error pop ups and other UI specific validations

Given a FH PMO logs in 
When FH user goes into FH Homepage
Then Only active offices can be moved i.e. inactive offices and offices that are scheduled to be active cannot be moved (MOVE drop-down doesnt show up)
And Offices can be moved between one active sub-tier to another under a same department. (Note: Inactive and scheduled to be active sub-tiers should not show up in the agency picker drop-down)
Then During office move, same parent sub-tier cannot be chosen. UI Should throw an error if a same parent sub-tier is chosen
And During move, the confirmation page should show new sub-tier's name and its agency code.
Then On completion of move, the office should now reside under a new parent sub-tier i.e breadcrumb should be updated, office profile should now reflect the new parent sub-tier's name and the office should be available from new sub-tier's hierarchy tab.
And Browser closes