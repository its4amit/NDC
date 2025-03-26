Feature: Login Functionality

#Background: BAT application launch

# Given user launch site url


@regression
Scenario: verify login with multiple set of data

When user enter username "standard_user" and password "secret_sauce"
And user clicks on login button
Then validate successful login with heading "Products"

@regression
Scenario: verify login with invalid data

When user enter username "test" and password "test"
And user clicks on login button
Then validate error is displayed




