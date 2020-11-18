Feature: FH searches pages/searching permissions for FH PMO/nonFH user/dept admin for fh/subtier admin


Scenario: Validations on searches for status/organization type

Given a FH PMO logs in 
Then FH pmo searches heirarchy 
And Browser closes
When a user whos domain is not FH logs in
Then They will validate searches for non FH users
And Browser closes
When a dept Admin of FH logs in
Then They will validate searches for FH users
And Browser closes
When a subtier Admin of FH logs in
Then They will validate searches for FH users
And Browser closes