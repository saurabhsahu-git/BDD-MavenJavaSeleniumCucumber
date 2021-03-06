Feature: Rest Assured APIs

@API
Scenario: To Test Rest Assured 	GET List Users API
When Hitting GET List Users API
Then Validating Response code is "200"
Then printing Response Body on console

@API @Error
Scenario: To Test Rest Assured 	GET Single User API
When Hitting GET Single User API
Then Validating Response code is "200"
Then printing Response Body on console

@API
Scenario: To Test Create Rest Assured POST API
When Hitting POST Create API
Then Validating Response code is "201"
Then printing Response Body on console

@API
Scenario: To Print each Response Attribute Value in Create API
When Hitting POST Create API
Then Validating Response code is "201"
Then printing each attribute along with its value from Create API response body

@API
Scenario: To Print each Response Attribute Value in Create API
When Hitting POST Register API
Then Validating Response code is "200"
Then printing each attribute along with its value from Register API response body

@API
Scenario: To Print each Response Attribute Value in Create API
When Hitting POST Login API
Then Validating Response code is "200"
Then printing each attribute along with its value from Login API response body