Feature: LogIn Page Feature

Scenario: Verify Login Page Title
Given user is on logIn page
When user gets the title of the page
Then page title should be "OrangeHRM"

Scenario: Forgot Password Link
Given user is on logIn page
Then  forgot your password link should be displayed

Scenario: LogIn with valid credentials
Given user is on logIn page
When user enters the username "Admin"
And user enters the password "admin123"
And user clicks the Login button 
Then page url should be "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
