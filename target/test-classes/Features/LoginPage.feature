Feature: Login to Application

@Execute @UI
Scenario Outline: Test to validate user is able to login to the application
	Given User is in Home Page
	When User Navigates to login page
	When User Enters username <username>
	When User Enters password <password>
	When Click on Login Button 
	
	Examples:
	|username|password|
	|"saurabh2495@gmail.com"|"@g2tANw7PZGV9aM"| 

@Execute @UI
Scenario Outline: Test to validate Username text field is mandatory
	Given User is in Home Page
	When User Navigates to login page
	When User Enters password <password>
	When Click on Login Button 
	Then Validate Login Error message displayed
	
	Examples:
	|username|password|
	|"saurabh2495@gmail.com"|"q1w2e3r4t5"| 
	
@Execute @UI
Scenario Outline: Test to validate Password field is a mandatory field
	Given User is in Home Page
	When User Navigates to login page
	When User Enters username <username>
	When Click on Login Button 
	Then Validate Login Error message displayed
	
	Examples:
	|username|password|
	|"saurabh2495@gmail.com"|"q1w2e3r4t5"|
	
@Execute @UI
Scenario Outline: Test to validate Forgot Password link is working
	Given User is in Home Page
	When User Navigates to login page
	And User Click on Forgot Password Link
	Then Validate Forgot Password page is loaded
	When User Enters username <username>
	When User Click on Reset password Button
	Then Validate Password reset link is sent to registered email address


	Examples:
	|username|password|
	|"saurabh2495@gmail.com"|"q1w2e3r4t5"|

Scenario: Test to validate Login to Classic CRM hyperlink is working
Scenario: Test to validate SignUp Hyperlink is working
Scenario: Test to validate Bell Icon for Subscribe to notification is working