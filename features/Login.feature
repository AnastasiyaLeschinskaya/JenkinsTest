Feature: Login to saks page

Scenario: login to saks account and check the name
Given saks account login page
When user entered email and password 
Then users should see their name 

Scenario Outline: login to saks acc with separeted email and password
Given saks account login page
When entered email <email>
And entered password <password> 
Then users should see their name 

Examples: 
| email | password |
| qa3www@mailinator.com | Qa1234567; |
| qa3www@mailinator.com | Qa1234567! |