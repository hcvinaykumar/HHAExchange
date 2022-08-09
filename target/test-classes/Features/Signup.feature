Feature: Check Signup Functionality

@Regresion
Scenario: validate the  functionality of Signup
    Given user is on the login page
    When user clicks on Sign_Up_Here button
    When user fills Email Address Password Confirm Password Fields
    When user clicks on Signup button
    When user clicks on Email button for verification
    When user selects Perfom EVV option
    When user enters verification code and click submit code
    When user enter mandatory fields
    When user clicks on continue button
    Then user clicks on enable biometric ID