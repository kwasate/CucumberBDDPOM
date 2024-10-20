Feature: Admin Page Feature

Background: 
Given user has already logged in to the application
|username|password|
|Admin|admin123|

Scenario: Verify Login Page URL
Given user is on Admin page
When user gets the URL of the page
Then URL should be "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"

Scenario: Admin sections count
Given user is on Admin page
Then  user gets the Admin sections
|User Management |
|Job |
|Organization |
|Qualifications |
|Nationalities|
|Corporate Branding|
|Configuration |
And Admin sections count should be 7

