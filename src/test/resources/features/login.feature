Feature: Login page

Scenario: Check Email Address field validation for valid email address
Given User is already on login page 
When User enters email address as "hemantd17@gmail.com"
Then Email Address box should be highlighted with "ok" 


Scenario: Check Email Address field validation for invalid email address
Given User is already on login page 
When User enters email address as "2342424"
Then Email Address box should be highlighted with "error" 